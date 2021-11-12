package com.example.app_actividadsemanaaa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DBEstante extends DBHelper{

    private Context context;
    private DBHelper dbHelper;
    private SQLiteDatabase db;

    public DBEstante(@Nullable Context context) {
        super(context);
        this.context=context;

    }

    public void insertarDatos(String letra, int numero, String color){
        ContentValues values = new ContentValues();
        this.dbHelper= new DBHelper(context);
        this.db=dbHelper.getReadableDatabase();
        values.put("letra",letra);
        values.put("numero",numero);
        values.put("color",color);
        this.db.insert(TABLA_ESTANTE,null,values);
    }

    public Cursor mostrarDatos(){
        this.dbHelper= new DBHelper(context);
        this.db=dbHelper.getReadableDatabase();
        Cursor filas = db.rawQuery("SELECT * FROM "+TABLA_ESTANTE+"",null);
        return filas;
    }


    public Cursor mostrarDatosEspecificos(String nombre){
        this.dbHelper= new DBHelper(context);
        this.db=dbHelper.getReadableDatabase();
        Cursor filas = db.rawQuery("SELECT * FROM "+TABLA_ESTANTE+" WHERE nombre = "+nombre+" LIMIT 1",null);
        return filas;
    }
}
