package com.example.bravocollect;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        TextView tv1 = findViewById(R.id.textView_nombre);
        String dato = getIntent().getStringExtra("dato");
        tv1.setText(dato);

        CheckBox cb = findViewById(R.id.checkBox_1);
        MediaPlayer musica =  MediaPlayer.create(getApplicationContext(), R.raw.labota);
        if (cb.isChecked()) {
            musica.start();
        } else if (!cb.isChecked()) {
            musica.stop();
        }

        RadioButton rb = findViewById(R.id.radioButton_1);
        if (rb.isChecked()) {
            Toast.makeText(this, "La maestra Paula, la mejor", Toast.LENGTH_SHORT).show();
        }
    }

    public void Instagram (View view) {
        Intent i = new Intent(this, WebViewITA.class);
        startActivity(i);
    }

    public void Tickets (View view) {
        Intent i = new Intent(this, SD.class);
        startActivity(i);
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