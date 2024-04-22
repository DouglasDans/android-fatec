package com.example.ex5

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson

class ContatoActivity : AppCompatActivity() {

    val listaContato = ArrayList<Contato>()
    val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contato_activity)

        val txtNome = findViewById<EditText>(R.id.txtNome)
        val email = findViewById<EditText>(R.id.txtEmail)
        val telefone = findViewById<EditText>(R.id.txtTel)

        val btnSalvar = findViewById<Button>(R.id.btnGravar)
        val btnPesquisar = findViewById<Button>(R.id.btnPesquisar)

        val listView = findViewById<ListView>(R.id.lstContato)

        val adapter = ArrayAdapter<Contato>(this, android.R.layout.simple_list_item_1, listaContato)
        listView.adapter = adapter

        btnSalvar.setOnClickListener {
            val c =
                Contato(0, txtNome.text.toString(), email.text.toString(), telefone.text.toString())
            listaContato.add(c)
            salvarPrefs()
        }

        btnPesquisar.setOnClickListener {
            carregarPrefs()
            adapter.clear()
            adapter.addAll(listaContato)
            adapter.notifyDataSetChanged() // Notifica o adapter sobre a mudança nos dados

        }


    }
    fun salvarPrefs() {
        val strContato = gson.toJson(listaContato)
        Log.i("CONTATOS", "Saving contacts: $strContato")
        val sp = this.getSharedPreferences("CONTATOS", MODE_PRIVATE)
        sp.edit().apply {
            putString("LISTA-CONTATOS", strContato)
            commit()
        }
    }

    fun carregarPrefs() {
        val sp = this.getSharedPreferences("CONTATOS", MODE_PRIVATE)
        val strContato = sp.getString("LISTA-CONTATOS", "[]")
        Log.i("CONTATOS", "Loaded contacts: $strContato")
        val lista = gson.fromJson(strContato, ArrayList<Contato>()::class.java)
        Log.d("CONTATOS", "Carregado ${lista.size} contatos")
        listaContato.clear()
        listaContato.addAll(lista)
    }
}