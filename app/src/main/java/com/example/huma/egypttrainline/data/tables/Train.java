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
@StorIOSQLiteType(table = Train.TABLE_NAME)
@StorIOContentResolverType(uri = Train.CONTENT_URI_STRING)
public class Train implements BaseColumns {
    public static final String PATH = "train";
    public static final String CONTENT_URI_STRING = TrainContract.BASE_CONTENT_URI_STRING + "/" + PATH;
    public static final Uri CONTENT_URI = Uri.parse(CONTENT_URI_STRING);

    public static final String TABLE_NAME = "Train";


    public static final String COLUMN_TRAIN_NUMBER = "TrainNumber";
    public static final String COLUMN_FK_TROLLEY_TYPE_ID = "FK_TrolleyTypeID";
    public static final String COLUMN_FK_TRAIN_LINE_ID = "FK_TrainLineID";
    public static final String COLUMN_FK_WORKING_STATE = "FK_WorkingState";


    @StorIOSQLiteColumn(name = _ID, key = true)
    @StorIOContentResolverColumn(name = _ID, key = true)
    public int ID;
    @StorIOSQLiteColumn(name = COLUMN_TRAIN_NUMBER)
    @StorIOContentResolverColumn(name = COLUMN_TRAIN_NUMBER)
    String TrainNumber;
    @StorIOSQLiteColumn(name = COLUMN_FK_TROLLEY_TYPE_ID)
    @StorIOContentResolverColumn(name = COLUMN_FK_TROLLEY_TYPE_ID)
    String FK_TrolleyTypeID;
    @StorIOSQLiteColumn(name = COLUMN_FK_TRAIN_LINE_ID)
    @StorIOContentResolverColumn(name = COLUMN_FK_TRAIN_LINE_ID)
    String FK_TrainLineID;
    @StorIOSQLiteColumn(name = COLUMN_FK_WORKING_STATE)
    @StorIOContentResolverColumn(name = COLUMN_FK_WORKING_STATE)
    String FK_WorkingState;

}
