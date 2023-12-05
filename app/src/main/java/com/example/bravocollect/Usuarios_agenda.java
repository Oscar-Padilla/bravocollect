package com.example.bravocollect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Usuarios_agenda extends AppCompatActivity {

    private EditText et_nombre, et_datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios_agenda);
        et_nombre =(EditText) findViewById(R.id.txt_nombre);
        et_datos = (EditText) findViewById(R.id.txt_datos);
    }
    public void Guardar(View view){
        String nombre = et_nombre.getText().toString();
        String datos = et_datos.getText().toString();
        SharedPreferences preferencias = getSharedPreferences("clientes", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferencias.edit();
        obj_editor.putString(nombre, datos);
        obj_editor.commit();
        Toast.makeText(this, "El cliente se guardó de manera correcta", Toast.LENGTH_SHORT).show();
    }
    public void Buscar(View view){
        String nombre = et_nombre.getText().toString();
        SharedPreferences preferencias = getSharedPreferences("clientes", Context.MODE_PRIVATE);
        String datos = preferencias.getString(nombre, "");

        if (datos.length() == 0){
            Toast.makeText(this, "El cliente no existe", Toast.LENGTH_SHORT).show();

        }else{
            et_datos.setText(datos);
            Toast.makeText(this, "Cliente encontrado", Toast.LENGTH_SHORT).show();

        }
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