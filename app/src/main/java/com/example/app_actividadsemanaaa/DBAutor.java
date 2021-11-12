package com.example.app_actividadsemanaaa;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObservable;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DBAutor extends DBHelper{

    private Context context;
    private DBHelper dbHelper;
    private SQLiteDatabase db;

    public DBAutor(@Nullable Context context) {
        super(context);
        this.context=context;
    }

    public void insertarDatos(String nombre, String apellido, String nacionalidad){
        ContentValues values = new ContentValues();
        this.dbHelper= new DBHelper(context);
        this.db=dbHelper.getWritableDatabase();
        values.put("nombre",nombre);
        values.put("apellido",apellido);
        values.put("nacionalidad",nacionalidad);
        this.db.insert(TABLA_AUTOR,null,values);
    }


    public Cursor mostrarDatos(){
        this.dbHelper= new DBHelper(context);
        this.db=dbHelper.getReadableDatabase();
        Cursor filas = db.rawQuery("SELECT * FROM "+TABLA_AUTOR+"",null);
        return filas;
    }


    public Cursor mostrarDatosEspecificos(String nombre){
        this.dbHelper= new DBHelper(context);
        this.db=dbHelper.getReadableDatabase();
        Cursor filas = db.rawQuery("SELECT * FROM "+TABLA_AUTOR+" WHERE nombre = "+nombre,null);
        return filas;
    }


}
