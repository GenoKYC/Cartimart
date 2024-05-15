package com.example.cartimart;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.cartimart.model.ItemAddress;

import java.util.ArrayList;
import java.util.List;

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
                + "password TEXT,"
                + "blk_address TEXT,"
                + "location TEXT,"
                + "contact_number INTEGER,"
                + "address_name TEXT"

                + ")";
        db.execSQL(CREATE_TABLE_QUERY);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS UserInfo");
        onCreate(db);
    }

    public long addUsersInfo(UsersInfo usersInfo) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("full_name", usersInfo.getFull_name());
        values.put("email_address", usersInfo.getEmail_address());
        values.put("password", usersInfo.getPassword());

        return db.insert(TABLE_NAME, null, values);
    }

    public int addAddress(ItemAddress itemAddress) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("blk_address", itemAddress.getBlk_address());
        contentValues.put("location", itemAddress.getLocation());
        contentValues.put("address_name", itemAddress.getAddress_name());
        contentValues.put("contact_number", itemAddress.getContact_number());

        String updateCondition = "blk_address =? AND location=? AND address_name =? AND contact_number";
        String[] selectionArgs = {itemAddress.getBlk_address(), itemAddress.getLocation(), itemAddress.getAddress_name(), String.valueOf(itemAddress.getContact_number())};
        int updateRows = db.update(TABLE_NAME, contentValues, updateCondition, selectionArgs);
        db.close();
        return updateRows;
    }

    public List<ItemAddress> getAlladdress(String full_name) {
        List<ItemAddress> itemAddress = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String SELECT_QUERY = "SELECT * FROM " + TABLE_NAME + " WHERE full_name = ?";
        String[] selectionArgs = {full_name};
        Cursor cursor = db.rawQuery(SELECT_QUERY, selectionArgs);
        if (cursor.moveToFirst()) {
            do {
                ItemAddress itemAddresses = new ItemAddress();
                itemAddresses.setAddress_name(cursor.getString(cursor.getColumnIndex("address_name")));
                itemAddresses.setBlk_address(cursor.getString(cursor.getColumnIndex("blk_address")));
                itemAddresses.setLocation(cursor.getString(cursor.getColumnIndex("location")));
                itemAddresses.setContact_number(cursor.getInt(cursor.getColumnIndex("contact_number")));
                itemAddress.add(itemAddresses);
            } while (cursor.moveToLast());


        }
        cursor.close();
        return itemAddress;
    }
}
