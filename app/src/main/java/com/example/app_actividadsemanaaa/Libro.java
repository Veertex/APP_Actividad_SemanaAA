package com.example.app_actividadsemanaaa;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Libro extends AppCompatActivity {
    EditText titulo,descripcion,fecha,copias,paginas;
    Bundle datos;
    Spinner autor,editorial,estante;
    Button btnActualizar,btnBorrar,btnGuardar7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libro);
        this.titulo = findViewById(R.id.textBoxNombreLibro);
        this.descripcion = findViewById(R.id.textBoxDescripcion);
        this.fecha = findViewById(R.id.textBoxFecha);
        this.copias = findViewById(R.id.textBoxCopias);
        this.paginas = findViewById(R.id.textBoxPaginas);
        this.autor = findViewById(R.id.spinnerAutor);
        this.editorial = findViewById(R.id.spinnerEditorial);
        this.estante = findViewById(R.id.spinnerEstante);
        this.btnActualizar = findViewById(R.id.btnActualizar);
        this.btnBorrar = findViewById(R.id.btnBorrar);
        this.btnGuardar7 = findViewById(R.id.btnGuardar7);

        List<String> listaAutores = listarAutores();
        ArrayAdapter<String> arrayAdapterAutores = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,listaAutores);
        this.autor.setAdapter(arrayAdapterAutores);

        List<String> listaEditoriales = listarEditoriales();
        ArrayAdapter<String> arrayAdapterEditoriales = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,listaEditoriales);
        this.editorial.setAdapter(arrayAdapterEditoriales);

        List<String> listaEstantes = listarEstantes();
        ArrayAdapter<String> arrayAdapterEstantes = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,listaEstantes);
        this.estante.setAdapter(arrayAdapterEstantes);

        datos=getIntent().getExtras();
        if(datos!=null){
            this.titulo.setText(String.valueOf(datos.getString("titulo")));
            this.descripcion.setText(String.valueOf(datos.getString("descripcion")));
            this.fecha.setText(String.valueOf(datos.getString("fecha")));
            this.copias.setText(String.valueOf(datos.getString("copias")));
            this.paginas.setText(String.valueOf(datos.getString("paginas")));

            for(int x=0;x<listaAutores.size();x++){
                if(listaAutores.get(x).equals(String.valueOf(datos.getString("autor"))))
                this.autor.setSelection(x);
            }

            for(int x=0;x<listaEditoriales.size();x++){
                if(listaEditoriales.get(x).equals(String.valueOf(datos.getString("editorial"))))
                    this.editorial.setSelection(x);
            }

            for(int x=0;x<listaEstantes.size();x++){
                if(listaEstantes.get(x).equals(String.valueOf(datos.getString("estante"))))
                    this.estante.setSelection(x);
            }
            this.btnGuardar7.setEnabled(false);
            this.btnActualizar.setEnabled(true);
            this.btnBorrar.setEnabled(true);
        }

    }

    public void registrarAutor(View view){

        DBLibro dbLibro =  new DBLibro(Libro.this);
        dbLibro.insertarDatos(this.titulo.getText().toString(),this.descripcion.getText().toString(),
                this.fecha.getText().toString(),Integer.parseInt(this.copias.getText().toString()),
                Integer.parseInt(this.paginas.getText().toString()),this.autor.getSelectedItem().toString(),
                this.editorial.getSelectedItem().toString(),this.estante.getSelectedItem().toString());

        Toast toast = Toast.makeText(this,"hola",Toast.LENGTH_SHORT);
        toast.show();
    }

    @SuppressLint("Range")
    private List<String> listarEditoriales(){
        DBEditorial DBEditorial = new DBEditorial(Libro.this);
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
        DBEstante DBEstante = new DBEstante(Libro.this);
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
        DBAutor dbAutor = new DBAutor(Libro.this);
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

    @SuppressLint("Range")
    private List<String> listarAutor(String nombre){
        DBAutor dbAutor = new DBAutor(Libro.this);
        Cursor cursor = dbAutor.mostrarDatosEspecificos(nombre);
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