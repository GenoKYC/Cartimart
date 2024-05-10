package com.example.cartimart.helper;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.cartimart.model.Category;

public class HCategoryItem extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Account.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "Category";

    public HCategoryItem(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_QUERY = "CREATE TABLE " + TABLE_NAME + "("
                + "id INT,"
                + "category_name TEXT,"
                + "img_url TEXT,"
                + "created_at TEXT"
                + ")";
        db.execSQL(CREATE_TABLE_QUERY);




    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS category");
        onCreate(db);
    }

    public long addUsersInfo (Category category){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", category.getId());
        values.put("category_name", category.getCategory_name());
        values.put("image_url", category.getImg_url());
        values.put("created_at", category.getCreated_at());


        return db.insert(TABLE_NAME, null, values);
    }

}
