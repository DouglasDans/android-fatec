package com.example.ex6restaurante


data class Restaurante( val id : Long = 0,
                        val nome : String = "", val endereco : String = "",
                        val latitude : Double = 0.0, val longitude: Double = 0.0,
                        val tipoComida : String = "", val classificacao : Int = 0,
                        val descricao : String = "")