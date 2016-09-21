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
 * Date: 20-Sep-16
 */
@StorIOSQLiteType(table = StationTable.TABLE_NAME)
@StorIOContentResolverType(uri = StationTable.CONTENT_URI_STRING)
public class StationTable implements BaseColumns {
    public static final String CONTENT_URI_STRING = TrainContract.BASE_CONTENT_URI_STRING + "/" + TrainContract.PATH_STATION;
    public static final Uri CONTENT_URI = Uri.parse(CONTENT_URI_STRING);

    public static final String TABLE_NAME = "Station";

    public static final String COLUMN_STATION_NAME = "StationName";
    public static final String COLUMN_STATION_ARABIC = "StationArabic";

    @StorIOSQLiteColumn(name = _ID, key = true)
    @StorIOContentResolverColumn(name = _ID, key = true)
    public int ID;
    @StorIOSQLiteColumn(name = COLUMN_STATION_NAME)
    @StorIOContentResolverColumn(name = COLUMN_STATION_NAME)
    public String StationName;
    @StorIOSQLiteColumn(name = COLUMN_STATION_ARABIC)
    @StorIOContentResolverColumn(name = COLUMN_STATION_ARABIC)
    public String StationArabic;

    public StationTable() {
    }

    @Override
    public String toString() {
        return "StationTable{" +
                "ID=" + ID +
                ", StationName='" + StationName + '\'' +
                ", StationArabic='" + StationArabic + '\'' +
                '}';
    }
}
