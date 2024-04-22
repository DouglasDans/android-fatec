package com.example.agendacontatos;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText txtNome = findViewById(R.id.txtNome);
        EditText txtEmail = findViewById(R.id.txtEmail);
        EditText txtTel = findViewById(R.id.txtTel);
        Button bt_gravar = findViewById(R.id.button);


        bt_gravar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String nome = txtNome.getText().toString();
                String email = txtEmail.getText().toString();
                String telefone = txtTel.getText().toString();

                Log.d("Contato", "Nome: " + nome + ", Email: " + email + ", Telefone: " + telefone);
            }
        });
    }
}