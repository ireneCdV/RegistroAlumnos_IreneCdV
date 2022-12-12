package com.example.registroalumnos.BaseDatos

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = arrayOf(InfoAlumnos::class), version = 1)

abstract class DBalumnos:RoomDatabase() {
    abstract fun daoAlumnos():DAOalumnos
}