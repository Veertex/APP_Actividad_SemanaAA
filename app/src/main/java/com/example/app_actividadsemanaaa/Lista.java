package com.example.app_actividadsemanaaa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.os.RecoverySystem;

import java.util.ArrayList;
import java.util.List;

public class Lista extends AppCompatActivity {
    RecyclerView listaLibros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        this.listaLibros = findViewById(R.id.listaLibros);
        this.listaLibros.setLayoutManager(new LinearLayoutManager(Lista.this));
        Adapter adapter = new Adapter(listarLibros());
        listaLibros.setAdapter(adapter);
    }

    @SuppressLint("Range")
    private ArrayList<Lista.libro> listarLibros(){
        DBLibro DBLibro = new DBLibro(Lista.this);
        Cursor cursor = DBLibro.mostrarDatos();
        ArrayList<Lista.libro> DBLibros = new ArrayList<>();

        if(cursor!=null){
            if(cursor.moveToFirst()){
                do{

                    Lista.libro libro = new Lista.libro(
                            cursor.getString(cursor.getColumnIndex("titulo")),
                            cursor.getString(cursor.getColumnIndex("descripcion")),
                            cursor.getString(cursor.getColumnIndex("fecha")),
                            cursor.getString(cursor.getColumnIndex("copias")),
                            cursor.getString(cursor.getColumnIndex("paginas")),
                            cursor.getString(cursor.getColumnIndex("autor")),
                            cursor.getString(cursor.getColumnIndex("editorial")),
                            cursor.getString(cursor.getColumnIndex("estante")));
                    DBLibros.add(libro);

                }while(cursor.moveToNext());
            }
        }

        return DBLibros;
    }
    public static class libro{
        public String titulo,descripcion,fecha,copias,paginas,autor,editorial,estante;

    public libro(String titulo, String descripcion, String fecha, String copias, String paginas, String autor, String editorial, String estante) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.copias = copias;
        this.paginas = paginas;
        this.autor = autor;
        this.editorial = editorial;
        this.estante = estante;
    }



    }
}