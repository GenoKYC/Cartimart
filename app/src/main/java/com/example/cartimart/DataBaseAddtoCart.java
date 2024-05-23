package com.example.cartimart;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

//public class DataBaseAddtoCart extends SQLiteOpenHelper {
//    public static final String DATABASE_NAME = "Cart.db";
//    public static final int DATABASE_VERSION = 1;
//    public static final String TABLE_NAME = "AddtoCart";
//
//    public DataBaseAddtoCart(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String CREATE_TABLE_QUERY = "CREATE TABLE " + TABLE_NAME + "("
//                + "user_name TEXT,"
//                + "CartItem1Name TEXT,"
//                + "CartItem2Name TEXT,"
//                + "CartItem3Name TEXT,"
//                + "CartItem4Name TEXT,"
//                + "CartItem5Name TEXT,"
//                + "CartItem6Name TEXT,"
//                + "CartItem7Name TEXT,"
//                + "CartItem8Name TEXT,"
//                + "CartItem9Name TEXT,"
//                + "CartItem10Name TEXT,"
//
//                + "CartItem1Quantity TEXT,"
//                + "CartItem2Quantity TEXT,"
//                + "CartItem3Quantity TEXT,"
//                + "CartItem4Quantity TEXT,"
//                + "CartItem5Quantity TEXT,"
//                + "CartItem6Quantity TEXT,"
//                + "CartItem7Quantity TEXT,"
//                + "CartItem8Quantity TEXT,"
//                + "CartItem9Quantity TEXT,"
//                + "CartItem10Quantity TEXT,"
//
//                + "CartItem1Price TEXT,"
//                + "CartItem2Price TEXT,"
//                + "CartItem3Price TEXT,"
//                + "CartItem4Price TEXT,"
//                + "CartItem5Price TEXT,"
//                + "CartItem6Price TEXT,"
//                + "CartItem7Price TEXT,"
//                + "CartItem8Price TEXT,"
//                + "CartItem9Price TEXT,"
//                + "CartItem10Price TEXT,"
//
//                + "CartItem1SubTotal TEXT,"
//                + "CartItem2SubTotal TEXT,"
//                + "CartItem3SubTotal TEXT,"
//                + "CartItem4SubTotal TEXT,"
//                + "CartItem5SubTotal TEXT,"
//                + "CartItem6SubTotal TEXT,"
//                + "CartItem7SubTotal TEXT,"
//                + "CartItem8SubTotal TEXT,"
//                + "CartItem9SubTotal TEXT,"
//                + "CartItem10SubTotal TEXT"
//                + ")";
//        db.execSQL(CREATE_TABLE_QUERY);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS BookBorrowing");
//        onCreate(db);
//    }
//    public long addCartItem (CartGetSet cartGetSet){
//        SQLiteDatabase db = getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("book_name", cartGetSet.getBookName());
//
//        return db.insert(TABLE_NAME, null, values);
//    }
//
//    public List<Borrow> getAllReturnedBooks() {
//        List<Borrow> Borrow = new ArrayList<>();
//        SQLiteDatabase db = getReadableDatabase();
//        String SELECT_QUERY = "SELECT * FROM " + TABLE_NAME ;
//        Cursor cursor = db.rawQuery(SELECT_QUERY, null);
//        if (cursor.moveToFirst()) {
//            do {
//                Borrow borrow = new Borrow();
//                borrow.setBookName(cursor.getString(cursor.getColumnIndex("book_name")));
//                borrow.setAuthor(cursor.getString(cursor.getColumnIndex("author")));
//                borrow.setStudentName(cursor.getString(cursor.getColumnIndex("student_name")));
//                borrow.setRequestDate(cursor.getString(cursor.getColumnIndex("request_date")));
//                borrow.setRequestStatus(cursor.getString(cursor.getColumnIndex("request")));
//                borrow.setNumberOfBooks(cursor.getInt(cursor.getColumnIndex("number_of_books")));
//                borrow.setBorrowingDate(cursor.getString(cursor.getColumnIndex("borrowing_date")));
//                borrow.setReturnDate(cursor.getString(cursor.getColumnIndex("return_date")));
//                borrow.setDeadline(cursor.getString(cursor.getColumnIndex("deadline")));
//                Borrow.add(borrow);
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        return Borrow;
//    }
//    public List<Borrow> gerUserReturnBooks(String studentName) {
//        List<Borrow> Borrow = new ArrayList<>();
//        SQLiteDatabase db = getReadableDatabase();
//        String SELECT_QUERY = "SELECT * FROM " + TABLE_NAME + " Where student_name =?";
//        String[] selectionArgs = {studentName};
//        Cursor cursor = db.rawQuery(SELECT_QUERY, selectionArgs);
//        if (cursor.moveToFirst()) {
//            do {
//                Borrow borrow = new Borrow();
//                borrow.setBookName(cursor.getString(cursor.getColumnIndex("book_name")));
//                borrow.setAuthor(cursor.getString(cursor.getColumnIndex("author")));
//                borrow.setStudentName(cursor.getString(cursor.getColumnIndex("student_name")));
//                borrow.setRequestDate(cursor.getString(cursor.getColumnIndex("request_date")));
//                borrow.setReturnDate(cursor.getString(cursor.getColumnIndex("return_date")));
//                borrow.setRequestStatus(cursor.getString(cursor.getColumnIndex("request")));
//                borrow.setBorrowingDate(cursor.getString(cursor.getColumnIndex("borrowing_date")));
//                borrow.setNumberOfBooks(cursor.getInt(cursor.getColumnIndex("number_of_books")));
//                borrow.setDeadline(cursor.getString(cursor.getColumnIndex("deadline")));
//                Borrow.add(borrow);
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        return Borrow;
//    }
//    public List<Borrow> searchBooks(String searchTerm) {
//        List<Borrow> results = new ArrayList<>();
//        SQLiteDatabase db = getReadableDatabase();
//
//        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " +
//                "book_name LIKE ? OR " + "author LIKE ?";
//
//        String[] selectionArgs = {"%" + searchTerm + "%", "%" + searchTerm + "%"};
//
//        Cursor cursor = db.rawQuery(query, selectionArgs);
//
//        if (cursor.moveToFirst()) {
//            do {
//                Borrow borrow = new Borrow();
//                borrow.setBookName(cursor.getString(cursor.getColumnIndex("book_name")));
//                borrow.setAuthor(cursor.getString(cursor.getColumnIndex("author")));
//                borrow.setStudentName(cursor.getString(cursor.getColumnIndex("student_name")));
//                borrow.setRequestDate(cursor.getString(cursor.getColumnIndex("request_date")));
//                borrow.setRequestStatus(cursor.getString(cursor.getColumnIndex("request")));
//                borrow.setBorrowingDate(cursor.getString(cursor.getColumnIndex("borrowing_date")));
//                borrow.setNumberOfBooks(cursor.getInt(cursor.getColumnIndex("number_of_books")));
//                borrow.setDeadline(cursor.getString(cursor.getColumnIndex("deadline")));
//                results.add(borrow);
//            } while (cursor.moveToNext());
//        }
//
//        cursor.close();
//        db.close();
//
//        return results;
//  }
//}
