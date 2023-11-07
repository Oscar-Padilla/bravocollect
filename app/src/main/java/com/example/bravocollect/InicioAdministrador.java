package com.example.bravocollect;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class InicioAdministrador extends AppCompatActivity {

    private ListView lv1;
    private EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_administrador);
        Toast.makeText(this, "Inicio de sesión exitoso, Bienvenido", Toast.LENGTH_LONG).show();

        lv1 = findViewById(R.id.listView_productos);
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
        Iterator it = productos.entrySet().iterator();
        while (it.hasNext()) {
            HashMap<String, String> resultMap = new HashMap<>();
            Map.Entry pair = (Map.Entry)it.next();
            resultMap.put("First Line", pair.getKey().toString());
            resultMap.put("Second Line", pair.getValue().toString());
            listItems.add(resultMap);
        }

        lv1.setAdapter(adapter);

        et1 = findViewById(R.id.editText_buscar);
        String dato = getIntent().getStringExtra("dato");
        et1.setText("Hola "+dato);
    }
}