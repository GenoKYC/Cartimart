package com.example.cartimart.helper;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.cartimart.R;
import com.example.cartimart.model.Category;
import com.example.cartimart.model.CategoryItem;

public class HCategoryItem extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Account.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "CategoryItem";

    public static CategoryItem categoryItem = null;
    public HCategoryItem(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        long x = 0;
        String CREATE_TABLE_QUERY = "CREATE TABLE " + TABLE_NAME + "("
                + "id INT,"
                + "category_id INT,"
                + "citem_name TEXT,"
                + "img_url INT,"
                + "created_at TEXT"
                + ")";
        db.execSQL(CREATE_TABLE_QUERY);

       this.addCategoryItems(new CategoryItem(1, 1, "Manga", R.drawable.fruits_item, "2024-05-09"));
       this.addCategoryItems(new CategoryItem(2, 1, "Watermelon", R.drawable.fruits_item, "2024-05-09"));
       this.addCategoryItems(new CategoryItem(3, 2, "Eggplant", R.drawable.veggies_item, "2024-05-09"));
       this.addCategoryItems(new CategoryItem(4, 2, "Sitaw", R.drawable.veggies_item, "2024-05-09"));
       this.addCategoryItems(new CategoryItem(5, 3, "Bangus", R.drawable.fishes_item, "2024-05-09"));
       this.addCategoryItems(new CategoryItem(7, 3, "Tilapia", R.drawable.fishes_item, "2024-05-09"));
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS category");
        onCreate(db);
    }

    public long addCategoryItems (CategoryItem categoryItem){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", categoryItem.getCId());
        values.put("category_id", categoryItem.getCategory_id());
        values.put("citem_name", categoryItem.getCitem_name());
        values.put("image_url", categoryItem.getImage_url());
        values.put("created_at", categoryItem.getCreated_at());


        return db.insert(TABLE_NAME, null, values);
    }

}
