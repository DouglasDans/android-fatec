package com.example.ex6restaurante

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson

class RestauranteActivity : AppCompatActivity() {

    val listaRestaurantes = ArrayList<Restaurante>()
    val gson = Gson()

    override fun onCreate( bundle : Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.restaurante_layout)

        val edtNome = findViewById<EditText>(R.id.txtNomeRestaurante)
        val edtEndereco = findViewById<EditText>(R.id.txtEndereco)
        val edtTipo = findViewById<EditText>(R.id.txtTipoComida)
        val edtClassificacao = findViewById<EditText>(R.id.txtClassificacao)
        val edtLatitude = findViewById<EditText>(R.id.txtLatitude)
        val edtLongitude = findViewById<EditText>(R.id.txtLongitude)
        val edtDescricao = findViewById<EditText>(R.id.txtDescricao)

        val btnSalvar = findViewById<Button>(R.id.btnSalvar)
        val btnVerLista = findViewById<Button>(R.id.btnVerLista)

        btnSalvar.setOnClickListener {

            val nome = edtNome.text.toString()
            val endereco = edtEndereco.text.toString()
            val tipo = edtTipo.text.toString()
            val classificacao = edtClassificacao.text.toString().toInt()
            val latitude = edtLatitude.text.toString().toDouble()
            val longitude = edtLongitude.text.toString().toDouble()
            val descricao = edtDescricao.text.toString()

            val restaurante = Restaurante(1, nome, endereco, latitude, longitude, tipo, classificacao, descricao)
            listaRestaurantes.add( restaurante )

            salvarPrefs()
        }
        btnVerLista.setOnClickListener {
            val intent = Intent(this, ListaRestauranteActivity::class.java)
            startActivity(intent)
        }
    }

    fun salvarPrefs() {
        val strRestaurantes = gson.toJson(listaRestaurantes)
        val sp = this.getSharedPreferences("RESTAURANTES", MODE_PRIVATE)

        Log.i("RESTAURANTES", strRestaurantes)

        sp.edit().apply {
            putString("LISTA", strRestaurantes)
            commit()
        }
    }
}