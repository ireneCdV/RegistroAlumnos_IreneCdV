package com.example.registroalumnos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.registroalumnos.BaseDatos.InfoAlumnos
import com.example.registroalumnos.BaseDatos.ListaApp
import com.example.registroalumnos.databinding.ActivityActualizarBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Actualizar : ActivityWithMenu() {
    private lateinit var bindingActualizar: ActivityActualizarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingActualizar= ActivityActualizarBinding.inflate(layoutInflater)
        setContentView(bindingActualizar.root)
        bindingActualizar.Actualizar.setOnClickListener {
            if(bindingActualizar.Nombre.text.toString().isEmpty()  or bindingActualizar.Curso.text.toString().isEmpty()   ){

                Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show()
            }
            else{
                CoroutineScope(Dispatchers.IO).launch {
                    var nombre=bindingActualizar.Nombre.text.toString()
                    var curso=bindingActualizar.Curso.text.toString()

                    var actualizarA: InfoAlumnos
                    actualizarA = ListaApp.database.daoAlumnos().ObteneralumnoPorNombre(nombre)

                    actualizarA.curso=curso

                    ListaApp.database.daoAlumnos().updateAlumno(actualizarA)

                    clearFocus()

                }
            }
        }


    }

    fun clearFocus(){
        bindingActualizar.Nombre.setText("")
        bindingActualizar.Curso.setText("")

    }
}