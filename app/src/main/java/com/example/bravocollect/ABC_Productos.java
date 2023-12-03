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
import android.widget.Toast;

public class ABC_Productos extends AppCompatActivity {

    private EditText et_codigo, et_descripcion, et_precio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abc_productos);

        et_codigo =(EditText) findViewById(R.id.txt_codigo);
        et_descripcion =(EditText) findViewById(R.id.txt_descripcion);
        et_precio =(EditText) findViewById(R.id.txt_precio);

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
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administrador", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();

        if(!codigo.isEmpty()){
            int cantidad = BaseDeDatos.delete("articulos", "codigo='" + codigo + "'", null);

            BaseDeDatos.close();

            et_codigo.setText("");
            et_descripcion.setText("");
            et_precio.setText("");

            if (cantidad ==1){
                Toast.makeText(this, "El producto fue eliminado exitosamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "El producto no oexiste", Toast.LENGTH_SHORT).show();
            }

        } else{
            Toast.makeText(this, "Debes de introducir el codigo del producto", Toast.LENGTH_SHORT).show();
        }

    }

    public void Modificar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administrador", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();
        String precio = et_precio.getText().toString();
        String descripcion = et_descripcion.getText().toString();


        if (!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()){

            ContentValues registro =new ContentValues();
            registro.put("codigo", codigo);
            registro.put("descripcion", descripcion);
            registro.put("precio",precio);

            int cantidad = BaseDeDatos.update("articulos", registro, "codigo='" + codigo + "'", null);
            BaseDeDatos.close();


            if(cantidad ==1){

                Toast.makeText(this, "El producto fue actualizado correctamente", Toast.LENGTH_SHORT).show();

            } else{

                Toast.makeText(this, "El producto no existe", Toast.LENGTH_SHORT).show();

            }

        } else {

            Toast.makeText(this, "Debes de llenar todos los campos", Toast.LENGTH_SHORT).show();
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