package com.example.cartimart.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.cartimart.R;
import com.example.cartimart.model.Category;

import java.util.ArrayList;
import java.util.List;

public class HCategory extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Account.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "Category";
    public static  Category category = null;

    public HCategory(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        long x = 0;
        String CREATE_TABLE_QUERY = "CREATE TABLE " + TABLE_NAME + "("
                + "id INT,"
                + "category_name TEXT,"
                + "img_url INT,"
                + "created_at TEXT"
                + ")";
        db.execSQL(CREATE_TABLE_QUERY);
//        category = new Category(1,"Fish", R.drawable.cartiad1,"2024-05-09 21:17");
//        x = this.addCategory(category);
//        category = new Category(1,"Fish",R.drawable.cartiad1,"2024-05-09 21:17");
//        x = this.addCategory(category);
//        category = new Category(1,"Fish",R.drawable.cartiad1,"2024-05-09 21:17");
//        x = this.addCategory(category);
//        category = new Category(1,"Fish",R.drawable.cartiad1,"2024-05-09 21:17");
//        x = this.addCategory(category);
//        category = new Category(1,"Fish",R.drawable.cartiad1,"2024-05-09 21:17");
//        x = this.addCategory(category);
//        category = new Category(1,"Fish",R.drawable.cartiad1,"2024-05-09 21:17");
//        x = this.addCategory(category);
//        category = new Category(1,"Fish",R.drawable.cartiad1,"2024-05-09 21:17");
//        x = this.addCategory(category);
//        category = new Category(1,"Fish",R.drawable.cartiad1,"2024-05-09 21:17");
//        x = this.addCategory(category);

        this.addCategory(new Category(1,"FRUITS", R.drawable.fruits_item, "2024-05-09"));
        this.addCategory(new Category(2,"VEGGIES", R.drawable.veggies_item, "2024-05-09"));
        this.addCategory(new Category(3,"FISH", R.drawable.fishes_item, "2024-05-09"));
        this.addCategory(new Category(4,"BEEF", R.drawable.beef_item, "2024-05-09"));
        this.addCategory(new Category(5,"POULTRY", R.drawable.poultry_item, "2024-05-09"));
        this.addCategory(new Category(7, "PORK", R.drawable.pork_item, "2024-05-09"));
        this.addCategory(new Category(8, "MILK", R.drawable.cartiad1, "2024-05-09"));
        this.addCategory(new Category(9, "LEGUMES", R.drawable.legumes_item, "2024-05-09"));
        this.addCategory(new Category(10, "SUGAR", R.drawable.sugar_item, "2024-05-09"));


    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS category");
        onCreate(db);
    }

    public long addCategory (Category category){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", category.getId());
        values.put("category_name", category.getCategory_name());
        values.put("image_url", category.getImg_url());
        values.put("created_at", category.getCreated_at());


        return db.insert(TABLE_NAME, null, values);
    }

    public ArrayList<Category> getCategories (){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<Category> cat_list = new ArrayList<>();

        if(cursor.moveToFirst())
        {
            do {
                cat_list.add(new Category(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getString(3)
                        ));
            } while(cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return cat_list;

    }


}
