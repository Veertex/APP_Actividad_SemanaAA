package com.example.app_actividadsemanaaa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Autor extends AppCompatActivity {
    EditText nombre, apellido, nacionalidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autor);
        this.nombre = findViewById(R.id.textBoxNombreAutor);
        this.apellido = findViewById(R.id.textBoxApellidoAutor);
        this.nacionalidad = findViewById(R.id.textBoxNacionalidadAutor);

    }

    public void registrarAutor(View view){

        DBAutor dbAutor =  new DBAutor(Autor.this);
        dbAutor.insertarDatos(this.nombre.getText().toString(),this.apellido.getText().toString(),this.nacionalidad.getText().toString());

        Toast toast = Toast.makeText(this,"hola",Toast.LENGTH_SHORT);
        toast.show();
    }




}