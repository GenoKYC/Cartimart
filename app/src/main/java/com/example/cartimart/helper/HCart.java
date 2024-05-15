package com.example.cartimart.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.cartimart.model.Cart;
import com.example.cartimart.model.CategoryItem;

import java.util.ArrayList;

public class HCart extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Account.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "Cart";
    public static final ArrayList<Cart> CART_ITEM = new ArrayList<Cart>();



    public static Cart cart = null;

    public HCart(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_QUERY = "CREATE TABLE " + TABLE_NAME + " ("
                + "id INT PRIMARY KEY,"
                + "usern TEXT,"
                + "item_name TEXT,"
                + "item_price INT,"
                + "item_qty INT,"
                + "item_subtotal INT,"
                + "created_at TEXT"
                + ")";
        db.execSQL(CREATE_TABLE_QUERY);
//        this.addCartItems(new Cart(1,"Kyle","Apples", 250, 1,250, "2024,20"));
//        this.addCartItems(new Cart(1,"Kye","Watermelon", 120, 1, 120, "2024,20"));
//        this.addCartItems(new Cart(1,"Ke","Mangoes", 50, 1, 50, "2024,20"));
//        this.addCartItems(new Cart(1,"K", "Melon", 70, 1 , 70,"2024,20"));

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS cart");
        onCreate(db);
    }


    public long addCartItems(Cart cart){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", cart.getId());
        values.put("usern", cart.getUsern());
        values.put("item_name", cart.getItem_name());
        values.put("item_price", cart.getItem_price());
        values.put("item_qty", cart.getItem_qty());
        values.put("item_subtotal", cart.getItem_subtotal());
        values.put("created_at", cart.getCreated_at());

        return db.insert(TABLE_NAME, null, values);
    }

    //remove item from cart function
    public static int deleteItemCart(String item_name, String usern, HCart dbHelper){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("item_name",item_name);
        contentValues.put("usern",usern);

        int deleteRows = db.delete(HCart.TABLE_NAME,
                "item_name" + "= ? AND" +
                "usern" + " = ? AND ",

                new String[]{item_name,usern});

        db.close();
        return deleteRows;
    }


    // Update Item Quantity Functiom
    public int updateItemQTY(Cart cart){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("item_qty", cart.getItem_qty());

        String whereClause = "id = ?";
        String[] updateArgs = {(String.valueOf(cart.getId()))};

        int updateRows = db.update(TABLE_NAME, values, whereClause, updateArgs);
        db.close();
        return updateRows;
    }

    public ArrayList<Cart> getCartItems(){

        ArrayList<Cart> items = new ArrayList<Cart>();

        //get cart itesm from database
        //store to items arraylist


        return items;
    }

    public ArrayList<Cart> addCartItem(Cart cartitem){
        CART_ITEM.add(cartitem);
        return CART_ITEM;
    }

}








    // get an item from cart
    // get all  cart item
    // get cart total amount

