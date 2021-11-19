package com.sebamartinez.hoy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//declarar 3 obj tipo editText y 1 tipo btn
    EditText edtCodigo,edtCurso,edtCarrera;
    Button  btnAgregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      edtCodigo=(EditText)findViewById(R.id.editCodigo);
      edtCurso=(EditText) findViewById(R.id.EditCurso);
      edtCarrera=(EditText)findViewById(R.id.EditCarrera);
      btnAgregar=(Button) findViewById(R.id.btnAgregar);

      final Developer developer= new Developer(getApplicationContext());
          btnAgregar.setOnClickListener(new View.OnClickListener(){

              @Override
              public void onClick(View v) {
                  developer.agregarCurso(edtCodigo.getText().toString(),edtCurso.getText().toString(),edtCarrera.getText().toString());
                  Toast.makeText(getApplicationContext(),"Agregado exitoso",Toast.LENGTH_SHORT).show();
              }
          }
    }
}