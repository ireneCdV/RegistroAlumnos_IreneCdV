package com.example.registroalumnos.BaseDatos

import android.app.Application
import androidx.room.Room

class ListaApp: Application() {

    companion object{
        lateinit var database: DBalumnos
    }

    override fun onCreate() {
        super.onCreate()
        ListaApp.database = Room.databaseBuilder(this,DBalumnos::class.java, "DBalumnos").build()

    }
}