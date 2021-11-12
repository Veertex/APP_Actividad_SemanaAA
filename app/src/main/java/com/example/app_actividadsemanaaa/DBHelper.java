package com.example.app_actividadsemanaaa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final int VERSION_BD=1;
    private static final String NOMBRE_BD="biblioteca.db";
    public static final String TABLA_AUTOR="tabla_autor";
    public static final String TABLA_EDITORIAL="tabla_editorial";
    public static final String TABLA_ESTANTE="tabla_estante";
    public static final String TABLA_LIBRO="tabla_libros";

    public DBHelper(@Nullable Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE "+TABLA_AUTOR+"("+"id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL,"+"apellido TEXT NOT NULL,"+"nacionalidad TEXT NOT NULL"+")");
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLA_EDITORIAL+"("+"id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL,"+"nacionalidad TEXT NOT NULL"+")");
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLA_ESTANTE+"("+"id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "letra TEXT NOT NULL,"+"numero INTEGER NOT NULL,"+"color TEXT NOT NULL"+")");
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLA_LIBRO+"("+"id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "titulo TEXT NOT NULL,"+"descripcion TEXT NOT NULL,"+"fecha TEXT NOT NULL,"+"copias INTEGER NOT NULL,"+
                "paginas INTEGER NOT NULL,"+"autor TEXT NOT NULL,"+"editorial TEXT NOT NULL,"+"estante TEXT NOT NULL"+")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE "+TABLA_AUTOR);
        sqLiteDatabase.execSQL("DROP TABLE "+TABLA_EDITORIAL);
        sqLiteDatabase.execSQL("DROP TABLE "+TABLA_ESTANTE);
        sqLiteDatabase.execSQL("DROP TABLE "+TABLA_LIBRO);
    }
}
