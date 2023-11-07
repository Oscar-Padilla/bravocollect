package com.example.bravocollect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }
    //Barra de navegación
    public void carrito(View view) {
        Intent ini_sesion = new Intent(this, PedidosAdministrador.class);
        startActivity(ini_sesion);
    }
    public void home(View view) {
        Intent ini_sesion = new Intent(this, InicioAdministrador.class);
        startActivity(ini_sesion);
    }
    public void ajustes(View view) {
        Intent ini_sesion = new Intent(this, Settings.class);
        startActivity(ini_sesion);
    }
}