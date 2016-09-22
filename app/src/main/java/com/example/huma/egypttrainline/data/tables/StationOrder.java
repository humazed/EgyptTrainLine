package com.example.huma.egypttrainline.data.tables;

import android.net.Uri;
import android.provider.BaseColumns;

import com.example.huma.egypttrainline.data.TrainContract;
import com.pushtorefresh.storio.contentresolver.annotations.StorIOContentResolverColumn;
import com.pushtorefresh.storio.contentresolver.annotations.StorIOContentResolverType;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * User: huma
 * Date: 21-Sep-16
 */

@StorIOSQLiteType(table = StationOrder.TABLE_NAME)
@StorIOContentResolverType(uri = StationOrder.CONTENT_URI_STRING)
public class StationOrder implements BaseColumns {
    public static final String PATH = "stationorder";
    public static final String CONTENT_URI_STRING = TrainContract.BASE_CONTENT_URI_STRING + "/" + PATH;
    public static final Uri CONTENT_URI = Uri.parse(CONTENT_URI_STRING);

    public static final String TABLE_NAME = "StationOrder";

    public static final String COLUMN_TRAIN_CATEGORY_ID = "TrainCategoryID";
    public static final String COLUMN_TRAIN_LINE_ID = "TrainLineID";
    public static final String COLUMN_STATION_ID = "StationID";
    public static final String COLUMN_ORDERING = "Ordering";

    @StorIOSQLiteColumn(name = _ID, key = true)
    @StorIOContentResolverColumn(name = _ID, key = true)
    public int ID;
    @StorIOSQLiteColumn(name = COLUMN_TRAIN_CATEGORY_ID)
    @StorIOContentResolverColumn(name = COLUMN_TRAIN_CATEGORY_ID)
    String TrainCategoryID;
    @StorIOSQLiteColumn(name = COLUMN_TRAIN_LINE_ID)
    @StorIOContentResolverColumn(name = COLUMN_TRAIN_LINE_ID)
    String TrainLineID;
    @StorIOSQLiteColumn(name = COLUMN_STATION_ID)
    @StorIOContentResolverColumn(name = COLUMN_STATION_ID)
    String StationID;
    @StorIOSQLiteColumn(name = COLUMN_ORDERING)
    @StorIOContentResolverColumn(name = COLUMN_ORDERING)
    String Ordering;

    @Override
    public String toString() {
        return "StationOrder{" +
                "ID=" + ID +
                ", TrainCategoryID='" + TrainCategoryID + '\'' +
                ", TrainLineID='" + TrainLineID + '\'' +
                ", StationID='" + StationID + '\'' +
                ", Ordering='" + Ordering + '\'' +
                '}';
    }
}
