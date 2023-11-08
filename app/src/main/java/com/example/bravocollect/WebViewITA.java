package com.example.bravocollect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewITA extends AppCompatActivity {

    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_ita);

        wv = findViewById(R.id.wv1);

        String URL = "www.instagram.com/dormi_ita_/?next=%2F";
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl("http://"+URL);

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