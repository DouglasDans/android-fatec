package com.example.aula2703

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

public class MainActivity : AppCompatActivity() {
    override fun onCreate(bundle : Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.activity_main)

        val btnConverter = findViewById<Button>(R.id.btnConverter)
        val editMoeda = findViewById<EditText>(R.id.editMoeda)
        val editCotacao = findViewById<EditText>(R.id.editCotacao)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        btnConverter.setOnClickListener {
            val moeda = editMoeda.text.toString().toFloat();
            val cocacao = editCotacao.text.toString().toFloat();

            val resultado = moeda * cocacao

            txtResultado.text = "Resultado: ${resultado}"
        }
    }
}