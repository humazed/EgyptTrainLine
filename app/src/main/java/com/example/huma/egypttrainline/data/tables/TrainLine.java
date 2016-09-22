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
 * Date: 22-Sep-16
 */
@StorIOSQLiteType(table = TrainLine.TABLE_NAME)
@StorIOContentResolverType(uri = TrainLine.CONTENT_URI_STRING)
public class TrainLine implements BaseColumns {
    public static final String PATH = "trainline";
    public static final String CONTENT_URI_STRING = TrainContract.BASE_CONTENT_URI_STRING + "/" + PATH;
    public static final Uri CONTENT_URI = Uri.parse(CONTENT_URI_STRING);

    public static final String TABLE_NAME = "TrainLine";

    public static final String FK_TRAIN_CATEGORY_ID = "FK_TrainCategoryID";
    public static final String FK_FROM_STATION_ID = "FK_FromStationID";
    public static final String FK_TO_STATION_ID = "FK_ToStationID";


    @StorIOSQLiteColumn(name = _ID, key = true)
    @StorIOContentResolverColumn(name = _ID, key = true)
    public int ID;
    @StorIOSQLiteColumn(name = FK_TRAIN_CATEGORY_ID)
    @StorIOContentResolverColumn(name = FK_TRAIN_CATEGORY_ID)
    String FK_TrainCategoryID;
    @StorIOSQLiteColumn(name = FK_FROM_STATION_ID)
    @StorIOContentResolverColumn(name = FK_FROM_STATION_ID)
    String FK_FromStationID;
    @StorIOSQLiteColumn(name = FK_TO_STATION_ID)
    @StorIOContentResolverColumn(name = FK_TO_STATION_ID)
    String FK_ToStationID;

    @Override
    public String toString() {
        return "TrainLine{" +
                "ID=" + ID +
                ", FK_TrainCategoryID='" + FK_TrainCategoryID + '\'' +
                ", FK_FromStationID='" + FK_FromStationID + '\'' +
                ", FK_ToStationID='" + FK_ToStationID + '\'' +
                '}';
    }
}
