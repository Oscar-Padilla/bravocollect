package com.example.bravocollect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ABC_Productos extends AppCompatActivity {

    private EditText et_codigo, et_descripcion, et_precio;

    private ImageView imageview_producto;

    int num_aleatorio = (int) (Math.random()*10);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abc_productos);

        et_codigo =(EditText) findViewById(R.id.txt_codigo);
        et_descripcion =(EditText) findViewById(R.id.txt_descripcion);
        et_precio =(EditText) findViewById(R.id.txt_precio);
        imageview_producto= (ImageView) findViewById(R.id.imageview_producto);

        int id;
        if(num_aleatorio ==0 || num_aleatorio ==10){
            id = getResources().getIdentifier("coca", "drawable", getPackageName());
            imageview_producto.setImageResource(id);
        } else if(num_aleatorio ==1 ){
            id = getResources().getIdentifier("pan", "drawable", getPackageName());
            imageview_producto.setImageResource(id);
        } else if(num_aleatorio ==9){
            id = getResources().getIdentifier("fruta", "drawable", getPackageName());
            imageview_producto.setImageResource(id);
        }else if(num_aleatorio ==2 ){
            id = getResources().getIdentifier("jabon", "drawable", getPackageName());
            imageview_producto.setImageResource(id);
        } else if( num_aleatorio ==8){
            id = getResources().getIdentifier("verduras", "drawable", getPackageName());
            imageview_producto.setImageResource(id);
        }else if(num_aleatorio ==3 ){
            id = getResources().getIdentifier("tortillas", "drawable", getPackageName());
            imageview_producto.setImageResource(id);
        } else if( num_aleatorio ==7){
            id = getResources().getIdentifier("sabritas", "drawable", getPackageName());
            imageview_producto.setImageResource(id);
        }else if(num_aleatorio ==4 ){
            id = getResources().getIdentifier("leche", "drawable", getPackageName());
            imageview_producto.setImageResource(id);
        }
        else if( num_aleatorio ==5 || num_aleatorio ==6){
            id = getResources().getIdentifier("chocolate", "drawable", getPackageName());
            imageview_producto.setImageResource(id);
        }






    }

    public void Registrar(View view){
       AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion",null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio = et_precio.getText().toString();

        if(!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);
            BaseDeDatos.insert("articulos", null, registro);


            BaseDeDatos.close();

            et_codigo.setText("");
            et_descripcion.setText("");
            et_precio.setText("");

            Toast.makeText(this, "Registro exitoso.", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_LONG).show();

        }


    }

    public void Buscar (View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();

        if(!codigo.isEmpty()){
            Cursor fila = BaseDeDatos.rawQuery
                    ("select descripcion, precio from articulos where codigo ="+codigo, null);

            if(fila.moveToFirst()){
                et_descripcion.setText(fila.getString(0));
                et_precio.setText(fila.getString(1));

                BaseDeDatos.close();

            }else{
                Toast.makeText(this, "Este producto no existe", Toast.LENGTH_LONG).show();
                BaseDeDatos.close();
            }

        } else {
            Toast.makeText(this, "Debes de introducir el código del articulo", Toast.LENGTH_SHORT).show();

        }


    }

    public void Eliminar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper
                (this, "administracion", null, 1);
        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();

        if(!codigo.isEmpty()){

            int cantidad = BaseDatabase.delete("articulos", "codigo=" + codigo, null);
            BaseDatabase.close();

            et_codigo.setText("");
            et_descripcion.setText("");
            et_precio.setText("");

            if(cantidad == 1){
                Toast.makeText(this, "Producto eliminado exitosamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "El producto no existe", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Debes de introducir el código del producto", Toast.LENGTH_SHORT).show();
        }
    }

    //Método para modificar un artículo o producto
    public void Modificar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio = et_precio.getText().toString();

        if(!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()){

            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);

            int cantidad = BaseDatabase.update("articulos", registro, "codigo=" + codigo, null);
            BaseDatabase.close();

            if(cantidad == 1){
                Toast.makeText(this, "Producto modificado correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "El producto no existe", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }



    public void iniciarEscaner(View view) {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setOrientationLocked(false);
        integrator.initiateScan();
    }

    // Manejar el resultado del escaneo
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() != null) {
                // Actualizar el EditText del código con el resultado del escaneo
                et_codigo.setText(result.getContents());
            } else {
                // Mensaje si el escaneo fue cancelado
                // Puedes agregar una notificación o acción aquí
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
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