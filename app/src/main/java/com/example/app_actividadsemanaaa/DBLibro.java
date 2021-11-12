package com.example.app_actividadsemanaaa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DBLibro extends DBHelper{

    private Context context;
    private DBHelper dbHelper;
    private SQLiteDatabase db;

    public DBLibro(@Nullable Context context) {
        super(context);
        this.context=context;

    }

    public void insertarDatos(String titulo, String descripcion, String fecha,
                              int copias, int paginas,
                              String autor, String editorial, String estante){

        ContentValues values = new ContentValues();
        this.dbHelper= new DBHelper(context);
        this.db=dbHelper.getReadableDatabase();
        values.put("titulo",titulo);
        values.put("descripcion",descripcion);
        values.put("fecha",fecha);
        values.put("copias",copias);
        values.put("paginas",paginas);
        values.put("autor",autor);
        values.put("editorial",editorial);
        values.put("estante",estante);

        this.db.insert(TABLA_LIBRO,null,values);
    }

    public Cursor mostrarDatos(){
        this.dbHelper= new DBHelper(context);
        this.db=dbHelper.getReadableDatabase();
        Cursor filas = db.rawQuery("SELECT * FROM "+TABLA_LIBRO+"",null);
        return filas;
    }

    public Cursor mostrarDatosEspecificos(int id){
        this.dbHelper= new DBHelper(context);
        this.db=dbHelper.getReadableDatabase();
        Cursor filas = db.rawQuery("SELECT * FROM "+TABLA_LIBRO+" WHERE id = "+id+" LIMIT 1",null);
        return filas;
    }


}
