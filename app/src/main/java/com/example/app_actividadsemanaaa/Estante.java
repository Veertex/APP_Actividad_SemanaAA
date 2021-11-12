package com.example.app_actividadsemanaaa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Estante extends AppCompatActivity {
    EditText letra,numero,color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estante);
        this.letra = findViewById(R.id.textBoxLetraEstante);
        this.numero = findViewById(R.id.textBoxNumero);
        this.color = findViewById(R.id.textBoxColor);

    }
    public void registrarAutor(View view){

        DBEstante dbEstante =  new DBEstante(Estante.this);
        dbEstante.insertarDatos(this.letra.getText().toString(),Integer.parseInt(this.numero.getText().toString()),this.color.getText().toString());

        Toast toast = Toast.makeText(this,"hola",Toast.LENGTH_SHORT);
        toast.show();
    }
}