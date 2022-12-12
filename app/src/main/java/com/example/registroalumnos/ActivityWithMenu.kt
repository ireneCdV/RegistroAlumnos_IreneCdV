package com.example.registroalumnos

import android.content.Intent
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

open class ActivityWithMenu : AppCompatActivity() {

    companion object{
        var actividadActual=0;
    }
    override fun onCreateOptionsMenu(menu: Menu?):Boolean {

        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_principal, menu)
        if (menu != null) {
            for (i in 0 until menu.size()) {
                if (i == actividadActual) menu.getItem(i).isEnabled = false
                else menu.getItem(i).isEnabled = true
            }
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.AnadirAlumno ->{
                val intent = Intent(this, Anadir::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                actividadActual=0;
                startActivity(intent)
                true
            }
            R.id.ActualizarAlumno ->{
                val intent = Intent(this,Actualizar::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                actividadActual=1;
                startActivity(intent)
                true
            }
            R.id.EliminarAlumno ->{
                val intent = Intent(this,Eliminar::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                actividadActual=2;
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}