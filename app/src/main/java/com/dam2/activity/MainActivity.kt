package com.dam2.activity

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.browse
import org.jetbrains.anko.longToast


const val REQUEST_IMAGE_CAPTURE =0


class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Botones de colores
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

        // Boton Url
        btUrl.setOnClickListener{
            browse("https://www.google.es/")

        }

        btnCamara.setOnClickListener {camera(it)}


    }

    // Permisos para usar la camara
    private fun camera(y: View?){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CAMERA)) {
                longToast("Permitido")
                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.CAMERA),0)
            } else {
                longToast("Rechazado permanentemente")

            }
        } else {
            longToast("Ya permitido")
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
        }
    }


    // Guardar la imagen en una imageView
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            val imageBitmap = data!!.extras!!.get("data") as Bitmap
            imageView.setImageBitmap(imageBitmap)
        }

    }

    }



