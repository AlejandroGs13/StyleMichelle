package com.example.alejandrogs.stylemichelle;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;

/**
 * Created by alejandrogs on 15/05/17.
 */

public class DBHelper extends SQLiteOpenHelper {
    String nametable = "Usuario";
    static private final String namedb = "Usuario";
    static int DATABASE_VERSION = 1;
    /*************************************************************/
    String usuid = "id";
    String usucorreo ="correo";
    String usucontraseña ="contraseña";
    String usutono = "tono";
    String usuojo = "ojo";
    /****************************************************************/

    public DBHelper(Context context) {
        super(context, namedb, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_NOTES_TABLE = "CREATE TABLE " + nametable + "("
                + usuid+ " INTEGER AUTOINCREMENT PRIMARY KEY," + usucorreo + " TEXT"+","+ usucontraseña +" TEXT,"+usutono+" TEXT,"+usuojo+" TEXT);";
        db.execSQL(CREATE_NOTES_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + nametable);
        // Create tables again
        onCreate(db);
    }


    public void  addusu(String correo, String contraseña,String tono,String ojo,View v) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Insertar
        try{
            //db.insert(TABLE_NOTAS, null, values);
            String query = ("INSERT INTO "+nametable+" ("+usucorreo+","+usucontraseña+","+usutono+","+usuojo+") VALUES('"+correo+"','"+contraseña+"','"+tono+"','"+ojo+"');");
            db.execSQL(query);
        }catch (SQLException ex){


            Log.e("Error",ex.toString());
        }
        db.close();
    }

    public String getUsuario(String id,View view) {
        String selectQuery = "SELECT "+usucontraseña+" FROM " + nametable +" WHERE "+usucorreo+" = '"+id+"';";
        SQLiteDatabase db = this.getWritableDatabase();
        String note = "";
        try {
            Cursor cursor = db.rawQuery(selectQuery, null);

            if (cursor.moveToFirst()) {
                do {

                    note = cursor.getString(0);
                } while (cursor.moveToNext());
            }
        }catch (SQLiteException ex){
           Log.e("ERROR",ex.toString());

        }
        db.close();

        return note;
    }

    public String getPiel(String id) {
        String selectQuery = "SELECT "+usutono+" FROM " + nametable +" WHERE "+usucorreo+" = '"+id+"';";
        SQLiteDatabase db = this.getWritableDatabase();
        String note = "";
        try {
            Cursor cursor = db.rawQuery(selectQuery, null);

            if (cursor.moveToFirst()) {
                do {

                    note = cursor.getString(0);
                } while (cursor.moveToNext());
            }
        }catch (SQLiteException ex){
            Log.e("ERROR",ex.toString());

        }
        db.close();

        return note;
    }

    public String getOjo(String id) {
        String selectQuery = "SELECT "+usuojo+" FROM " + nametable +" WHERE "+usucorreo+" = '"+id+"';";
        SQLiteDatabase db = this.getWritableDatabase();
        String note = "";
        try {
            Cursor cursor = db.rawQuery(selectQuery, null);

            if (cursor.moveToFirst()) {
                do {

                    note = cursor.getString(0);
                } while (cursor.moveToNext());
            }
        }catch (SQLiteException ex){
            Log.e("ERROR",ex.toString());

        }
        db.close();

        return note;
    }

}
