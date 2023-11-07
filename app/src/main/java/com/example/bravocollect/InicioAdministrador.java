package com.example.bravocollect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InicioAdministrador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_administrador);

        ListView lv1 = findViewById(R.id.listView_productos);
        HashMap<String, String> productos = new HashMap<>();
        productos.put("Coca Cola 600ml","$18.00 mxn");
        productos.put("Jabón","$15.00 mxn");
        productos.put("Ariel","$28.00 mxn");
        productos.put("Pan","$8.00 mxn");
        productos.put("1Kg. Tortillas","$24.00 mxn");
        productos.put("Leche","$35.00 mxn");
        productos.put("Queso","$34.00 mxn");
        productos.put("Chicle","$2.50 mxn");
        productos.put("Escoba","$42.00 mxn");
        productos.put("Cerveza","$25.00 mxn");

        List<HashMap<String, String >> listItems = new ArrayList<>();
        SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.list_item,
                new String[]{"First Line", "Second Line"},
                new int[]{R.id.tv_productos, R.id.tv_precios});
        for (Map.Entry<String, String> stringStringEntry : productos.entrySet()) {
            HashMap<String, String> resultMap = new HashMap<>();
            resultMap.put("First Line", ((Map.Entry<?, ?>) stringStringEntry).getKey().toString());
            resultMap.put("Second Line", ((Map.Entry<?, ?>) stringStringEntry).getValue().toString());
            listItems.add(resultMap);
        }

        lv1.setAdapter(adapter);
        //ola
    }
    public void pedidos(View view) {
        Intent ini_sesion = new Intent(this, PedidosAdministrador.class);
        startActivity(ini_sesion);
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