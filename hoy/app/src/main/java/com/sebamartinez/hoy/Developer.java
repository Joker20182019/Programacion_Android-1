package com.sebamartinez.hoy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Developer extends SQLiteOpenHelper {
    //creamos variables para el nombre
    private static final String NOMBRE_bd="developers.bd";
    private static final int VERSION_BD=1;
    private static final String TABLA_CURSOS = "CREATE TABLE CURSOS (CODIGO TEXT PRIMARY KEY ,CURSO TEXT,CARRERA TEXT) ";

    public Developer(Context context) {
        super(context, NOMBRE_bd, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_CURSOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int il) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLA_CURSOS);
        sqLiteDatabase.execSQL(TABLA_CURSOS);
    }
    public void agregarCurso(String codigo ,String curso ,String carrera){
        SQLiteDatabase bd=getWritableDatabase();
        if (bd!=null){
            bd.execSQL("INSERT INTO CURSOS VALUES ('"+codigo+"','"+curso+"','"+carrera+"')");
            bd.close();
        }

    }
}
