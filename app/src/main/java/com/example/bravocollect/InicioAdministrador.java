package com.example.bravocollect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class InicioAdministrador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_administrador);
        Toast.makeText(this, "Inicio de sesion exitoso, Bienvenido", Toast.LENGTH_LONG).show();




    }
}