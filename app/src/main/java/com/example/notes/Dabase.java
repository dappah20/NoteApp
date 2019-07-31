package com.example.notes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Dabase extends SQLiteOpenHelper {

    private static final int dbversion = 1;                 
    private static final String dbname = "noteapp";
    private static final String notetable = "tabel_note";
    private static final String id = "id";
    private static final String Title = "title";
    private static final String Desc = "desc";

    public Dabase(Context context) {
        super(context, dbname, null, dbversion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {       //define table for note
        String query = "CREATE TABLE " + notetable + " (" +
                id + " INTEGER PRIMARY KEY, " +
                Title + " TEXT, " +
                Desc + " TEXT, ";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if (oldVersion >= newVersion)
            return;
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + notetable);

        onCreate(sqLiteDatabase);
    }

    //CRUD process

    public int addNote(ModelNote noteModel){                //add new note
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Title, noteModel.getJudul());
        values.put(Desc, noteModel.getDesc());;

        long ID = db.insert(notetable, null, values);
        db.close();

        return (int) ID;
    }

    public List<ModelNote> getNotes(){                          //untuk mengambil data note yang telah dibuat
        List<ModelNote> noteList = new ArrayList<>();
        String query = "SELECT * FROM " + notetable;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String desc = cursor.getString(2);
                String date = cursor.getString(3);

                ModelNote noteModel = new ModelNote(id, title, desc);

                noteList.add(noteModel);
            } while (cursor.moveToNext());
        }

        return noteList;
    }
}
