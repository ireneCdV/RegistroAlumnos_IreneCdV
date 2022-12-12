package com.example.registroalumnos.BaseDatos

import androidx.room.*


@Dao
interface DAOalumnos {

    @Insert
    fun addAlumno(taskEntity: InfoAlumnos) : Long

    @Update
    fun updateAlumno(taskEntity: InfoAlumnos): Int

    @Delete
    fun deleteAlumno(taskEntity: InfoAlumnos):Int

    @Query("SELECT * FROM Alumnos WHERE nombre like:nombre")
    fun ObteneralumnoPorNombre(nombre: String):InfoAlumnos
}