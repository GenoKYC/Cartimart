package com.example.cartimart;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.cartimart.model.NotesList;

import java.util.ArrayList;
import java.util.List;

public class DatabaseNotesList extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Notes.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "Noteslist";

    public DatabaseNotesList(List2 context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_QUERY = "CREATE TABLE " + TABLE_NAME + "("
                + "full_name TEXT,"
                + "Content TEXT,"
                + "listTitle TEXT"
                + ")";
        db.execSQL(CREATE_TABLE_QUERY);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Notslist");
        onCreate(db);
    }

    public long addUsersInfo(NotesList notesList) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("full_name", notesList.getFullname());
        values.put("Content", notesList.getContent());
        values.put("listTitle", notesList.getListTitle());

        return db.insert(TABLE_NAME, null, values);
    }
    public List<NotesList> getAlladdress() {
        List<NotesList> NOTES = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String SELECT_QUERY = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(SELECT_QUERY, null);
        if (cursor.moveToFirst()) {
            do {
                NotesList notesListss = new NotesList();
                notesListss.setListTitle(cursor.getString(cursor.getColumnIndex("full_name")));
                notesListss.setContent(cursor.getString(cursor.getColumnIndex("Content")));
                notesListss.setListTitle(cursor.getString(cursor.getColumnIndex("listTitle")));
                NOTES.add(notesListss);
            } while (cursor.moveToLast());


        }
        cursor.close();
        return NOTES;
    }
}
