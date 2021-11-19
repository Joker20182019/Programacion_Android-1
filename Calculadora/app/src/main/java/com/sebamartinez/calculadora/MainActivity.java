package com.sebamartinez.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//enlaces
    private EditText numero_uno;
    private EditText numero_dos;
//enlace a la respuesta
    private TextView respuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //numeros ingresados
        numero_uno.findViewById(R.id.numero_uno);
        numero_dos.findViewById(R.id.numero_dos);

        //respuesta
        respuesta.findViewById(R.id.Respuesta);
    }

    public void suma(View view){
        int respuestaNumero = Integer.parseInt(numero_uno.getText().toString())+ Integer.parseInt(numero_dos.getText().toString());
        respuesta.setText(respuestaNumero);
    }
}