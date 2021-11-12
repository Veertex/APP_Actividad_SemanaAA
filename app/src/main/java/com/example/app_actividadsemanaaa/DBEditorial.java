package com.example.app_actividadsemanaaa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DBEditorial extends DBHelper{

    private Context context;
    private DBHelper dbHelper;
    private SQLiteDatabase db;

    public DBEditorial(@Nullable Context context) {
        super(context);
        this.context=context;

    }

    public void insertarDatos(String nombre, String nacionalidad){
        ContentValues values = new ContentValues();
        this.dbHelper= new DBHelper(context);
        this.db=dbHelper.getReadableDatabase();
        values.put("nombre",nombre);
        values.put("nacionalidad",nacionalidad);
        this.db.insert(TABLA_EDITORIAL,null,values);
    }

    public Cursor mostrarDatos(){
        this.dbHelper= new DBHelper(context);
        this.db=dbHelper.getReadableDatabase();
        Cursor filas = db.rawQuery("SELECT * FROM "+TABLA_EDITORIAL+"",null);
        return filas;
    }

    public Cursor mostrarDatosEspecificos(String nombre){
        this.dbHelper= new DBHelper(context);
        this.db=dbHelper.getReadableDatabase();
        Cursor filas = db.rawQuery("SELECT * FROM "+TABLA_EDITORIAL+" WHERE nombre = "+nombre+" LIMIT 1",null);
        return filas;
    }
}
