package com.example.app_actividadsemanaaa;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner spinner2,spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.spinner=findViewById(R.id.spinner);
        this.spinner2=findViewById(R.id.spinner2);

        List<String> listaAutores = listarAutores();
        ArrayAdapter<String> arrayAdapterAutores = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,listaAutores);
        this.spinner.setAdapter(arrayAdapterAutores);

        List<String> listaEditoriales = listarEditoriales();
        ArrayAdapter<String> arrayAdapterEditoriales = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,listaEditoriales);
        this.spinner2.setAdapter(arrayAdapterEditoriales);

    }

    public void agregarAutor(View view){
        Intent activityAutor = new Intent(MainActivity.this,Autor.class);
        startActivity(activityAutor);
    }
    public void agregarEditorial(View view){
        Intent activityEditorial = new Intent(MainActivity.this,Editorial.class);
        startActivity(activityEditorial);
    }
    public void agregarEstante(View view){
        Intent activityEstante = new Intent(MainActivity.this,Estante.class);
        startActivity(activityEstante);
    }
    public void agregarLibro(View view){
        Intent activityLibro = new Intent(MainActivity.this,Libro.class);
        startActivity(activityLibro);
    }
    public void listarLibros(View view){
        Intent activityLibro = new Intent(MainActivity.this,Lista.class);
        startActivity(activityLibro);
    }

    @SuppressLint("Range")
    private List<String> listarEditoriales(){
        DBEditorial DBEditorial = new DBEditorial(MainActivity.this);
        Cursor cursor = DBEditorial.mostrarDatos();
        List<String> editoriales = new ArrayList<>();

        if(cursor!=null){
            if(cursor.moveToFirst()){
                do{
                    editoriales.add(cursor.getString(cursor.getColumnIndex("nombre")));
                }while(cursor.moveToNext());
            }
        }

        return editoriales;
    }
    @SuppressLint("Range")
    private List<String> listarEstantes(){
        DBEstante DBEstante = new DBEstante(MainActivity.this);
        Cursor cursor = DBEstante.mostrarDatos();
        List<String> estantes = new ArrayList<>();

        if(cursor!=null){
            if(cursor.moveToFirst()){
                do{
                    estantes.add(cursor.getString(cursor.getColumnIndex("letra"))+
                            " "+cursor.getString(cursor.getColumnIndex("numero"))+
                            " "+cursor.getString(cursor.getColumnIndex("color")));
                }while(cursor.moveToNext());
            }
        }

        return estantes;
    }
    @SuppressLint("Range")
    private List<String> listarAutores(){
        DBAutor dbAutor = new DBAutor(MainActivity.this);
        Cursor cursor = dbAutor.mostrarDatos();
        List<String> autores = new ArrayList<>();

        if(cursor!=null){
            if(cursor.moveToFirst()){
                do{
                    autores.add(cursor.getString(cursor.getColumnIndex("nombre"))+" "+cursor.getString(cursor.getColumnIndex("apellido")));
                }while(cursor.moveToNext());
            }
        }

        return autores;
    }

}