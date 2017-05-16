package com.example.alejandrogs.stylemichelle;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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
    /****************************************************************/

    public DBHelper(Context context) {
        super(context, namedb, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_NOTES_TABLE = "CREATE TABLE " + nametable + "("
                + usuid+ " TEXT PRIMARY KEY," + usucorreo + " TEXT"+","+ usucontraseña +" TEXT,"+usutono+" TEXT);";
        db.execSQL(CREATE_NOTES_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + nametable);
        // Create tables again
        onCreate(db);
    }


    public void  addNota(String correo, String contraseña,String tono,View v) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Insertar
        try{
            //db.insert(TABLE_NOTAS, null, values);
            String query = ("INSERT INTO "+nametable+" ("+usucorreo+","+usucontraseña+","+usutono+") VALUES('"+correo+"','"+contraseña+"','"+tono+"');");
            db.execSQL(query);
        }catch (SQLException ex){

            //Snackbar.make(v, "Error al insertar Titulo ya utilizado", Snackbar.LENGTH_LONG)
            //    .setAction("Action", null).show();
            System.out.println(ex);
        }
        db.close();
    }
}
