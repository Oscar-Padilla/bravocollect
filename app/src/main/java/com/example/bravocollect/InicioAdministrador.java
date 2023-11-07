package com.example.bravocollect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class InicioAdministrador extends AppCompatActivity {

    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_administrador);
        Toast.makeText(this, "Inicio de sesion exitoso, Bienvenido", Toast.LENGTH_LONG).show();

        et1 = (EditText) findViewById(R.id.editText_buscar);

        String dato = getIntent().getStringExtra("dato");
        et1.setText("Hola "+dato);
    }
}