package com.dam2.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.browse

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btAmarillo.setOnClickListener{
            val miinvent = Intent(this,ActivityDetalle::class.java)
            miinvent.putExtra("color","Amarillo")
            startActivity(miinvent)
        }

        btRojo.setOnClickListener{
            val miinvent = Intent(this,ActivityDetalle::class.java)
            miinvent.putExtra("color","Rojo")
            startActivity(miinvent)
        }

        btUrl.setOnClickListener{
            browse("https://www.google.es/")

        }
    }




}
