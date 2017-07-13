package com.example.acer.stl2.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.acer.stl2.Database.Model.Activator;

/**
 * Created by Acer on 6/7/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "STL";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_BETS = "CREATE TABLE bets (id INTEGER PRIMARY KEY AUTOINCREMENT, combination_number text, amount INTEGER, number_recipient text, type text)";
        String CREATE_ACTIVATOR = "CREATE TABLE activator (id INTEGER PRIMARY KEY AUTOINCREMENT, code text, activator_number text, activate INTEGER)";
        db.execSQL(CREATE_BETS);
        db.execSQL(CREATE_ACTIVATOR);
        seedActivator(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS bets");
        db.execSQL("DROP TABLE IF EXISTS activator");
        onCreate(db);
    }

    private void seedActivator (SQLiteDatabase db) {

        ContentValues values = new ContentValues();
        ContentValues values2 = new ContentValues();
        values.put("code", "ACTIVATE");
        values.put("activator_number", "+639309556910");
        values.put("activate", 0);
        db.insert("activator", null, values);
        values2.put("code", "ACTIVATE");
        values2.put("activator_number", "+639095618478");
        values2.put("activate", 0);
        db.insert("activator", null, values2);

    }

    public boolean checkActive () {
        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursor = db.query("activator", new String[]{"activate"}, "activate > ?",
            new String[]{"0"}, null, null, null, null);
        return cursor.moveToFirst();

    }

    public Activator getActivator (String phonenumber) {SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("activator", new String[] { "code", "activator_number", "activate" }, "activator_number =?",
            new String[] {phonenumber}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Activator activator = new Activator(cursor.getString(0), cursor.getString(1), cursor.getInt(2));

        return activator;
    }

    public int activateApp (String phonenumber) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("activate", 1);

        return db.update("activator", values, "activator_number =?", new String[] {phonenumber});
    }



    public boolean deactivateApp () {
        SQLiteDatabase db = this.getWritableDatabase();


        Cursor cursor = db.query("activator", new String[] { "activator_number"}, "activate=?",
            new String[] {"1"}, null, null, null, null);
            while (cursor.moveToNext()){

                ContentValues values = new ContentValues();
                values.put("activate", 0);
                db.update("activator", values, "activator_number =?", new String[] {cursor.getString(0)});
            }

        return true;
    }

}
