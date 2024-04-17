package com.example.ex5agendacontato

import android.app.Activity
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson

class ContatoActivity : Activity() {

    val listaContato = ArrayList<Contato>()
    val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contato_activity)

        val txtNome = findViewById<EditText>(R.id.txtNome)
        val email = findViewById<EditText>(R.id.txtEmail)
        val telefone = findViewById<EditText>(R.id.txtTel)

        val btnSalvar = findViewById<Button>(R.id.btnGravar)

        btnSalvar.setOnClickListener{
            val c = Contato(0, txtNome.text.toString(), email.text.toString(), telefone.text.toString())
            listaContato.add(c)
            salvarPrefs()
        }
    }

    fun salvarPrefs(){
        val strListaContato = gson.toJson(listaContato)
        val sp = this.getSharedPreferences("Contatos", MODE_PRIVATE)
        sp.edit().apply {
            putString("LISTA_CONTATO", strListaContato)
            commit()
        }
    }

    fun carregarPrefs(){
        val sp = this.getSharedPreferences("Contatos", MODE_PRIVATE)
        val strListaContato = sp.getString("LISTA_CONTATO", "[]")
        val lista = gson.fromJson(strListaContato, ArrayList<Contato>()::class.java)

        listaContato.clear()
        listaContato.addAll(lista)
    }

}