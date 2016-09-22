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
@StorIOSQLiteType(table = Travel.TABLE_NAME)
@StorIOContentResolverType(uri = Travel.CONTENT_URI_STRING)
public class Travel implements BaseColumns {
    public static final String PATH = "travel";
    public static final String CONTENT_URI_STRING = TrainContract.BASE_CONTENT_URI_STRING + "/" + PATH;
    public static final Uri CONTENT_URI = Uri.parse(CONTENT_URI_STRING);

    public static final String TABLE_NAME = "Travel";

    public static final String COLUMN_FK_TRAIN_ID = "FK_TrainID";
    public static final String COLUMN_FK_START_STATION_ID = "FK_StartStationID";
    public static final String COLUMN_FK_ARRIVE_STATION_ID = "FK_ArriveStationID";
    public static final String COLUMN_START_TIME = "StartTime";
    public static final String COLUMN_ARRIVE_TIME = "ArriveTime";
    public static final String COLUMN_TN_UMBER = "TNumber";


    @StorIOSQLiteColumn(name = _ID, key = true)
    @StorIOContentResolverColumn(name = _ID, key = true)
    public int ID;
    @StorIOSQLiteColumn(name = COLUMN_FK_TRAIN_ID)
    @StorIOContentResolverColumn(name = COLUMN_FK_TRAIN_ID)
    String FK_TrainID;
    @StorIOSQLiteColumn(name = COLUMN_FK_START_STATION_ID)
    @StorIOContentResolverColumn(name = COLUMN_FK_START_STATION_ID)
    String FK_StartStationID;
    @StorIOSQLiteColumn(name = COLUMN_FK_ARRIVE_STATION_ID)
    @StorIOContentResolverColumn(name = COLUMN_FK_ARRIVE_STATION_ID)
    String FK_ArriveStationID;
    @StorIOSQLiteColumn(name = COLUMN_START_TIME)
    @StorIOContentResolverColumn(name = COLUMN_START_TIME)
    String StartTime;
    @StorIOSQLiteColumn(name = COLUMN_ARRIVE_TIME)
    @StorIOContentResolverColumn(name = COLUMN_ARRIVE_TIME)
    String ArriveTime;
    @StorIOSQLiteColumn(name = COLUMN_TN_UMBER)
    @StorIOContentResolverColumn(name = COLUMN_TN_UMBER)
    String TNumber;

    @Override
    public String toString() {
        return "Travel{" +
                "ID=" + ID +
                ", FK_TrainID='" + FK_TrainID + '\'' +
                ", FK_StartStationID='" + FK_StartStationID + '\'' +
                ", FK_ArriveStationID='" + FK_ArriveStationID + '\'' +
                ", StartTime='" + StartTime + '\'' +
                ", ArriveTime='" + ArriveTime + '\'' +
                ", TNumber='" + TNumber + '\'' +
                '}';
    }
}
