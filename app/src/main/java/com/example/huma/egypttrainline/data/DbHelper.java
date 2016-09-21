package com.example.huma.egypttrainline.data;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * User: huma
 * Date: 20-Sep-16
 */
public class DbHelper extends SQLiteAssetHelper {

    public static final String DB_NAME = "trains.db";
    public static final String DB_LOCATION = "assets/databases/trains.db";
    public static final int DB_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        setForcedUpgrade();
    }


}
