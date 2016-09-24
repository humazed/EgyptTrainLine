package com.example.huma.egypttrainline.data.custom_tables.reslut;

import android.database.Cursor;
import android.support.annotation.NonNull;

import com.pushtorefresh.storio.sqlite.operations.get.DefaultGetResolver;

import static com.example.huma.egypttrainline.data.custom_tables.reslut.Result.COLUMN_ARRIVE_STATION;
import static com.example.huma.egypttrainline.data.custom_tables.reslut.Result.COLUMN_ARRIVE_STATION_ARABIC;
import static com.example.huma.egypttrainline.data.custom_tables.reslut.Result.COLUMN_ARRIVE_TIME;
import static com.example.huma.egypttrainline.data.custom_tables.reslut.Result.COLUMN_FK_ARRIVE_STATION_ID;
import static com.example.huma.egypttrainline.data.custom_tables.reslut.Result.COLUMN_FK_START_STATION_ID;
import static com.example.huma.egypttrainline.data.custom_tables.reslut.Result.COLUMN_FK_TRAIN_ID;
import static com.example.huma.egypttrainline.data.custom_tables.reslut.Result.COLUMN_FK_TRAVEL_ID;
import static com.example.huma.egypttrainline.data.custom_tables.reslut.Result.COLUMN_START_STATION;
import static com.example.huma.egypttrainline.data.custom_tables.reslut.Result.COLUMN_START_STATION_ARABIC;
import static com.example.huma.egypttrainline.data.custom_tables.reslut.Result.COLUMN_START_TIME;
import static com.example.huma.egypttrainline.data.custom_tables.reslut.Result.COLUMN_TRAIN_NUMBER;

/**
 * User: huma
 * Date: 24-Sep-16
 */

public class ResultGetResolver extends DefaultGetResolver<Result> {
    @NonNull
    @Override
    public Result mapFromCursor(@NonNull Cursor cursor) {
        return new Result(
                getLong(cursor, COLUMN_FK_TRAVEL_ID),
                getString(cursor, COLUMN_START_TIME),
                getString(cursor, COLUMN_ARRIVE_TIME),
                getLong(cursor, COLUMN_FK_START_STATION_ID),
                getString(cursor, COLUMN_START_STATION),
                getString(cursor, COLUMN_START_STATION_ARABIC),
                getLong(cursor, COLUMN_FK_ARRIVE_STATION_ID),
                getString(cursor, COLUMN_ARRIVE_STATION),
                getString(cursor, COLUMN_ARRIVE_STATION_ARABIC),
                getLong(cursor, COLUMN_FK_TRAIN_ID),
                getString(cursor, COLUMN_TRAIN_NUMBER)
        );

    }


    private String getString(Cursor cursor, String name) {
        return cursor.getString(cursor.getColumnIndexOrThrow(name));
    }

    private long getLong(Cursor cursor, String name) {
        return cursor.getLong(cursor.getColumnIndexOrThrow(name));
    }
}
