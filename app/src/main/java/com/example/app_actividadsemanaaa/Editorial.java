package com.example.app_actividadsemanaaa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Editorial extends AppCompatActivity {

    EditText nombre, nacionalidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editorial);
        this.nombre = findViewById(R.id.textBoxNombre);
        this.nacionalidad = findViewById(R.id.textBoxNacionalidad);
    }

    public void registrarAutor(View view){

        DBEditorial dBEditorial =  new DBEditorial(Editorial.this);

        dBEditorial.insertarDatos(this.nombre.getText().toString(),this.nacionalidad.getText().toString());

        Toast toast = Toast.makeText(this,"hola",Toast.LENGTH_SHORT);
        toast.show();
    }
}