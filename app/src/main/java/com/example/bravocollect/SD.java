package com.example.bravocollect;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SD extends AppCompatActivity {

    private EditText et_nombre,et_contenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sd);
        et_nombre=(EditText) findViewById(R.id.txt_nombre_ticket);
        et_contenido=(EditText) findViewById(R.id.txt_contenido);
    }


    public void Guardar(View view){
        String nombre = et_nombre.getText().toString();
        String contenido = et_contenido.getText().toString();

        
        try {
            File tarjetaSD = Environment.getExternalStorageDirectory();

            Toast.makeText(this,tarjetaSD.getPath(), Toast.LENGTH_SHORT).show();

            File rutaarchivo = new File(tarjetaSD.getPath(), nombre);
            OutputStreamWriter creararchivo = new OutputStreamWriter(openFileOutput(nombre, Activity.MODE_PRIVATE));

            creararchivo.write(contenido);
            creararchivo.flush();
            creararchivo.close();

            Toast.makeText(this, "Ticket guardado correctamente", Toast.LENGTH_SHORT).show();

            et_nombre.setText("");
            et_contenido.setText("");

        }catch (IOException e){
            Toast.makeText(this, "No se pudo guardar.", Toast.LENGTH_SHORT).show();
            
            
        }

    }


    public void Consultar(View view){
        String nombre =et_nombre.getText().toString();


        try {
            File tarjetaSD = Environment.getExternalStorageDirectory();
            File rutaarchivo = new File(tarjetaSD, nombre);
            InputStreamReader abrirarchivo = new InputStreamReader(openFileInput(nombre));

            BufferedReader leerarchivo = new BufferedReader(abrirarchivo);

            String linea = leerarchivo.readLine();
            String contenido_completo ="";

            while (linea != null){
                contenido_completo=contenido_completo+ linea+ "\n";
                linea = leerarchivo.readLine();


            }

            leerarchivo.close();
            abrirarchivo.close();
            et_contenido.setText(contenido_completo);


        }catch (IOException e){
            Toast.makeText(this, "Error al leer ticket", Toast.LENGTH_SHORT).show();

        }


    }















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