package com.example.bravocollect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ola
    }
    public void login (View view){
        Intent ini_sesion = new Intent(this, InicioAdministrador.class);
        startActivity(ini_sesion);
    }
}