package com.example.logreg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Adatbazis extends SQLiteOpenHelper {

    public static final int Db_version = 1;
    public static final String Db_name = "Felhasznalok.db";
    public static final String felhasznalo_db = "felhasznalo";

    public static final String FELHASZNALO_TABLA = "felhasznalo";

    public static final String OSZLOP_ID = "id";
    public static final String OSZLOP_EMAIL = "email";
    public static final String OSZLOP_FELHASZNALONEV = "felhnev";
    public static final String OSZLOP_JELSZO = "jelszo";
    public static final String OSZLOP_TELJESNEV = "teljnev";

    public Adatbazis(Context context) {
        super(context, Db_name, null, Db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL = "CREATE TABLE IF NOT EXISTS " + FELHASZNALO_TABLA +
                " (" + OSZLOP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                OSZLOP_EMAIL + " VARCHAR(255) NOT NULL UNIQUE," + OSZLOP_FELHASZNALONEV + " VARCHAR(255) NOT NULL UNIQUE," +
                OSZLOP_JELSZO + " VARCHAR(255) NOT NULL, " + OSZLOP_TELJESNEV + " INTEGER NOT NULL" + ")";
        db.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL = "DROP TABLE IF EXISTS " + FELHASZNALO_TABLA;
        db.execSQL(SQL);
        onCreate(db);
    }

    public Cursor Bejelentkezes(String email, String felhnev, String jelszo, String teljnev){
        SQLiteDatabase db = this.getReadableDatabase();
        return this.getReadableDatabase().rawQuery("SELECT teljesnev FROM " +
                FELHASZNALO_TABLA + " WHERE felhnev = '" + felhnev + "' and jelszo = '" + jelszo + "'" ,null );
    }

    public boolean Regisztracio(String email, String felhnev, String jelszo, String teljnev)  {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(OSZLOP_EMAIL, email);
        values.put(OSZLOP_FELHASZNALONEV, felhnev);
        values.put(OSZLOP_JELSZO, jelszo);
        values.put(OSZLOP_TELJESNEV, teljnev);

        long result = db.insert(FELHASZNALO_TABLA, null, values);

        return result != -1;
    }
}
