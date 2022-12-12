package com.example.registroalumnos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.registroalumnos.BaseDatos.InfoAlumnos
import com.example.registroalumnos.BaseDatos.ListaApp
import com.example.registroalumnos.databinding.ActivityEliminarBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Eliminar : ActivityWithMenu() {

    private lateinit var bindingEliminar: ActivityEliminarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingEliminar= ActivityEliminarBinding.inflate(layoutInflater)
        setContentView(bindingEliminar.root)
        bindingEliminar.DeleteAlumno.setOnClickListener(){

            if(bindingEliminar.nombreDelete.text.toString().isEmpty()    ){

                Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show()
            }
            else{
                CoroutineScope(Dispatchers.IO).launch {
                    var nombre=bindingEliminar.nombreDelete.text.toString()

                    var eliminar: InfoAlumnos
                    eliminar = ListaApp.database.daoAlumnos().ObteneralumnoPorNombre(nombre)

                    eliminar.nombre=nombre

                    ListaApp.database.daoAlumnos().deleteAlumno(eliminar)


                    clearFocus()


                }
            }

        }

    }
    fun clearFocus(){
        bindingEliminar.nombreDelete.setText("")

    }
}