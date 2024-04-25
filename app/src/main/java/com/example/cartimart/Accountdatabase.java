package com.example.cartimart;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Accountdatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Account.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "UserInfo";

    public Accountdatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_QUERY = "CREATE TABLE " + TABLE_NAME + "("
                + "full_name TEXT,"
                + "email_address TEXT,"
                + "password TEXT"
                + ")";
        db.execSQL(CREATE_TABLE_QUERY);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS UserInfo");
        onCreate(db);
    }

    public long addUsersInfo (UsersInfo usersInfo){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("full_name", usersInfo.getFull_name());
        values.put("email_address", usersInfo.getEmail_address());
        values.put("password", usersInfo.getPassword());
        return db.insert(TABLE_NAME, null, values);
    }

}
