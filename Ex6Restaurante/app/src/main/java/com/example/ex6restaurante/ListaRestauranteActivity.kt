package com.example.ex6restaurante

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson

class ListaRestauranteActivity : AppCompatActivity() {

    val listaRestaurantes = ArrayList<Restaurante>()
    val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.restaurante_item_layout)

        val listView = findViewById<ListView>(R.id.lvRestaurantes)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaRestaurantes)

        listView.setAdapter(adapter);

        Log.i("TAGa", adapter.toString())

        adapter.addAll(carregarPrefs())
    }

    fun carregarPrefs(): ArrayList<Restaurante> {
        val sp = getSharedPreferences("RESTAURANTES", MODE_PRIVATE)

        val restaurantes = sp.getString("LISTA", "[]")

        val listRestaurantes = gson.fromJson(restaurantes, ArrayList<Restaurante>()::class.java)

        return listRestaurantes
    }
}