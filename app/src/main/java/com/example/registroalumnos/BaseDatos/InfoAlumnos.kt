package com.example.registroalumnos.BaseDatos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Alumnos")
data class InfoAlumnos (

    @PrimaryKey(autoGenerate = true)
    var id: Int=0,
    var nombre: String = "",
    var apellidos:String="",
    var curso:String =""
)