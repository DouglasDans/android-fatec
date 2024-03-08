package org.fatec.helloworld;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        setContentView(R.layout.principal_layout);

        EditText edNome = findViewById(R.id.txtNome);
        EditText edEmail = findViewById(R.id.txtEmail);
        EditText edTelefone = findViewById(R.id.txtTelefone);

        Button btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener( e -> {
            Log.i("Agenda_Contato", "Nome: " + edNome.getText());
            Log.i("Agenda_Contato", "Email: " + edEmail.getText());
            Log.i("Agenda_Contato", "Telefone: " + edTelefone.getText());
        });
    };
}
