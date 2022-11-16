package com.example.examen_interfaces

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.ActionBar
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class activity_pointsofinterest : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pointsofinterest)

        val actionbar = supportActionBar
        if (actionbar != null) {
            actionbar.hide()
        }


        val fab: FloatingActionButton = findViewById(R.id.floating1)
        fab.setOnClickListener{
            lanzarMain()
        }

        val chipGroup = findViewById(R.id.chip_group) as ChipGroup
        var textoToast = ""
        chipGroup.setOnCheckedStateChangeListener{chipGroup, mutableListID ->

            for (e in mutableListID) {
                var chip = chipGroup.findViewById<Chip>(e)
                textoToast += "" + chip.text +" "



            }

            Toast.makeText(this, ""+ textoToast, Toast.LENGTH_SHORT).show()
            textoToast = ""

        }


        val experiences = arrayOf("Adventures", "Guided visits", "Trekking")

        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, experiences)

        val lista_experiences = findViewById(R.id.spinner1) as Spinner
        lista_experiences.adapter = adaptador
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        lista_experiences.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(applicationContext, parent!!.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }

    fun lanzarMain(){
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }
}