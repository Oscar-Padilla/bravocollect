package com.example.bravocollect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

private EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ola
        et1 = (EditText)findViewById(R.id.editText_correo);

    }
    public void login (View view){
        Intent ini_sesion = new Intent(this, InicioAdministrador.class);
        ini_sesion.putExtra("dato",et1.getText().toString());

        startActivity(ini_sesion);

    }



}