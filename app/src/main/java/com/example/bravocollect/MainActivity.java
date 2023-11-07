package com.example.bravocollect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

private EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ola
        et1 = findViewById(R.id.editText_correo);
        et2 = findViewById(R.id.editText_contrasena);


    }
    public void login (View view){

        String correo = et1.getText().toString();
        String contrasena = et2.getText().toString();

        if(correo.length() == 0){
            Toast.makeText(this,"Debes de ingresar tu correo",Toast.LENGTH_SHORT).show();
        }
        if(contrasena.length() == 0){
            Toast.makeText(this,"Debes de ingresar tu contraseña",Toast.LENGTH_SHORT).show();
        }
        if(correo.length() !=0 && contrasena.length() !=0){
            Toast.makeText(this,"Iniciando sesión...",Toast.LENGTH_SHORT).show();


            Intent ini_sesion = new Intent(this, InicioAdministrador.class);
            ini_sesion.putExtra("dato",et1.getText().toString());

            startActivity(ini_sesion);
        }
//ola

    }



}