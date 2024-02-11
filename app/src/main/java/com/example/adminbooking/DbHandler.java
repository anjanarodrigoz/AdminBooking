package com.example.adminbooking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper {
    private static final int VERSION =4;
    private static final String DB_NAME = "booking";
    private static final String TABLE_NAME = "search";


    private static final String ID = "id";
    private static final String SEARCH = "search";
    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String MOBILE = "mobile";
    private static final String FADDRESS = "fAddress";
    private static final String TADDRESS = "tAddress";
    private static final String DATE = "date";
    private static final String TIME = "time";
    private static final String PRICE = "price";
    private static final String DEPOSITE = "deposite";
    private static final String TRUCK = "truck";
    private static final String TIME2 = "time2";
    private static final String NUM = "num";
    private static final String PACK = "pack";
    private static final String EXTRA = "extra";
    private static final String MOVE = "move";
    private static final String NOTE = "note";
    private static final String ITEM = "item";
    private static final String CARD = "card";



    private static DbHandler mInstance = null;

    private SQLiteDatabase db = null;


    public DbHandler(@Nullable Context context, String dbName, int version) {
        super(context, DB_NAME, null, VERSION);
    }

    public static DbHandler getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DbHandler(context,
                    DB_NAME, VERSION);
        }
        return mInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String TABLE_CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + " " +
                "("
                +ID + " TEXT PRIMARY KEY,"
                + SEARCH + " TEXT" +
                ");";

        db.execSQL(TABLE_CREATE_QUERY);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;

        db.execSQL(DROP_TABLE_QUERY);

        onCreate(db);

    }


    public void addBooking(String id,String search) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(ID,id);
        contentValues.put(SEARCH, search);

        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();

    }


    public List<String> getCompleteOrders(String searchWord) {

        String query;
        Cursor cursor;

        List<String> booking_id = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();

            query = "SELECT * FROM " + TABLE_NAME + " WHERE " + SEARCH + " like '%" + searchWord + "%'";
            cursor = db.rawQuery(query, null);


        if (cursor.moveToFirst()) {

            do {

                    booking_id.add(cursor.getString(0));

            }
                while (cursor.moveToNext());

        }
        return booking_id;

    }


    public void deleteBooking() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from "+ TABLE_NAME);
        db.close();
    }


}

