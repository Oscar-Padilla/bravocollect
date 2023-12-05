package com.example.bravocollect;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bitacora extends AppCompatActivity {
    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitacora);

        et1 = (EditText) findViewById(R.id.txt_bitacora);
        String archivos [] = fileList();

        if(ArchivoExiste(archivos,"bitacora.txt")){

            try {
                InputStreamReader archivo  = new InputStreamReader(openFileInput("bitacora.txt"));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();
                String bitacoracompleta="";

                while (linea != null){
                    bitacoracompleta = bitacoracompleta+linea+"\n";
                    linea= br.readLine();
                }
                br.close();
                archivo.close();
                et1.setText(bitacoracompleta);

            }catch (IOException e){
            }
        }
    }

    private boolean ArchivoExiste(String archivos [], String NombreArchivo){
for(int i=0; i< archivos.length;i++)
    if (NombreArchivo.equals(archivos[i]))
        return true;
return false;
    }

    public void Guardar(View view){

        try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("bitacora.txt", Activity.MODE_PRIVATE));
            archivo.write(et1.getText().toString());
            archivo.flush();

        }catch (IOException e){
        }
        Toast.makeText(this, "Recordatorio guardado correctamente", Toast.LENGTH_SHORT).show();
        Intent ini_sesion = new Intent(this, InicioAdministrador.class);
        startActivity(ini_sesion);

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