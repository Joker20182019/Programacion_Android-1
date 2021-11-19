package com.sebastian_martinez.prueba_dos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int BD_version=1;
    public static final String TABLE_NOMBRE ="SQLiteGPS";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DIRECCION="direccion";

    public static final String COLUMN_NAME = "nombre";
    public static final String COLUMN_FECHA = "fecha";
    public static final String COLUMN_HORA= "hora";
    public static final String COLUMN_VALOR ="valor";
    public static final String COLUMN_OBSERVACION="observacion";

    public DatabaseHelper(@Nullable Context context) {
        super(context, TABLE_NOMBRE, null, BD_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = " CREATE TABLE " + TABLE_NOMBRE
                + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + COLUMN_DIRECCION + " VARCHAR ,"
                + COLUMN_NAME + "VARCHAR ,"
                +  COLUMN_FECHA +"VARCHAR,"
                + COLUMN_HORA + "VARCHAR,"
                + COLUMN_VALOR + "VARCHAR,"
                + COLUMN_OBSERVACION + "VARCHAR"
                +")";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = " DROP TABLE IF EXISTS SQLiteGPS";
        db.execSQL(sql);
        onCreate(db);

    }

    public boolean addData (String insertar){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_DIRECCION,insertar);


        long result = db.insert(TABLE_NOMBRE, null,contentValues);
        if (result== -1){
            return false;
        }else{
            return true;
        }

    }
    public Cursor getListaContenidos(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("Select * FROM " + TABLE_NOMBRE, null);
        return data;
    }
}
