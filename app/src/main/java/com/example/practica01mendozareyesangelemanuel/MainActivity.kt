package com.example.practica01mendozareyesangelemanuel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var correo: EditText
    private lateinit var contrasena: EditText

    private val usuarios = listOf(
        Usuario("angel@gmail.com", "12345"),
        Usuario("emanuel@gmail.com", "12345"),
        Usuario("mendoza@gmail.com", "12345"),
        Usuario("reyes@gmail.com", "12345"),
        Usuario("admin@gmail.com", "12345")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        correo = findViewById(R.id.edtCorreo)
        contrasena = findViewById(R.id.edtContrasena)

        val btnIngresar: View = findViewById(R.id.btnIngresar)
        btnIngresar.setOnClickListener { aceptar() }

        val btnSalir: Button = findViewById(R.id.btnSalir)
        btnSalir.setOnClickListener { salir() }
    }

    private fun aceptar() {
        val inputCorreo = correo.text.toString()
        val inputContrasena = contrasena.text.toString()

        if (inputCorreo.isBlank() || inputContrasena.isBlank()) {
            Toast.makeText(this, "Falta completar los campos", Toast.LENGTH_SHORT).show()
            return
        }

        val usuario = usuarios.find { it.correo == inputCorreo && it.contrasena == inputContrasena }
        if (usuario != null) {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Datos Erróneos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun salir() {
        finishAffinity()
    }
}
