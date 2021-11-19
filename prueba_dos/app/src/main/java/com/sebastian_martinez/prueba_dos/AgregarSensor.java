package com.sebastian_martinez.prueba_dos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarSensor extends AppCompatActivity {
        private Button btnGuardaNew;
        private EditText Cname,Cvalor,Cfecha,Chora,Cobservacion;
        DatabaseHelper MIBD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_sensor);
        btnGuardaNew =(Button) findViewById(R.id.saveButton);
        btnGuardaNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertaRegistro();
            }
        });
        Cname =(EditText) findViewById(R.id.editTextNombre);

        Cvalor =(EditText) findViewById(R.id.editTextValor);
        Cfecha =(EditText) findViewById(R.id.editTextFecha);
        Chora =(EditText) findViewById(R.id.editTextHora);
        Cobservacion =(EditText) findViewById(R.id.editTextObservaciones);


    }
    public void insertaRegistro(){
        DatabaseHelper databaseHelper= new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAME,Cname.getText().toString());
        values.put(DatabaseHelper.COLUMN_VALOR,Cvalor.getText().toString());
        values.put(DatabaseHelper.COLUMN_FECHA,Cfecha.getText().toString());
        values.put(DatabaseHelper.COLUMN_HORA,Cfecha.getText().toString());
        values.put(DatabaseHelper.COLUMN_OBSERVACION,Cfecha.getText().toString());

        Long resultado=sqLiteDatabase.insert(DatabaseHelper.TABLE_NOMBRE,DatabaseHelper.COLUMN_ID,values);

        Toast.makeText(getApplicationContext(),"Registrado",Toast.LENGTH_LONG).show();
        sqLiteDatabase.close();
    }

}