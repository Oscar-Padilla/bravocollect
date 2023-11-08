package com.example.bravocollect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CrearCuenta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);
    }
    public void crear (View view) {
        Intent ini = new Intent(this, MainActivity.class);
        startActivity(ini);
    }
}