package com.example.registroalumnos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.registroalumnos.BaseDatos.InfoAlumnos
import com.example.registroalumnos.BaseDatos.ListaApp
import com.example.registroalumnos.databinding.ActivityActualizarBinding
import com.example.registroalumnos.databinding.ActivityAnadirBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Anadir : ActivityWithMenu() {


    private lateinit var binding:ActivityAnadirBinding
    lateinit var listaalumnos: MutableList<InfoAlumnos>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAnadirBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listaalumnos = ArrayList()
        binding.Anadir.setOnClickListener{

            if(binding.Nombre.text.toString().isEmpty()  or binding.Apellido.text.toString().isEmpty() or  binding.Curso.text.toString().isEmpty()  ){

                Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show()
            }

            else{
                // Insertamos en nuestra bbdd el nombre del alumno
                CoroutineScope(Dispatchers.IO).launch {

                    // Información de los campos de texto
                    var nombre=binding.Nombre.text.toString()
                    var apellidos= binding.Apellido.text.toString()
                    var curso= binding.Curso.text.toString()
                    var lumnado = InfoAlumnos(nombre = nombre, apellidos = apellidos, curso = curso)
                    listaalumnos.add(lumnado)

                    // Llamamos al metodo addElemento() del DAO para realizar la inserción
                    ListaApp.database.daoAlumnos().addAlumno(lumnado)
                    clearFocus()
                }
            }


        }

    }
    fun clearFocus(){
        binding.Nombre.setText("")
        binding.Apellido.setText("")
        binding.Curso.setText("")
    }
}