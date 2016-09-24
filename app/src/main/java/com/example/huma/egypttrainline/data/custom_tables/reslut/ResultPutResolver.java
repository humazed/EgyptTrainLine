package com.example.huma.egypttrainline.data.custom_tables.reslut;

import android.support.annotation.NonNull;

import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.operations.put.PutResolver;
import com.pushtorefresh.storio.sqlite.operations.put.PutResult;

/**
 * User: huma
 * Date: 24-Sep-16
 */

public class ResultPutResolver extends PutResolver<Result> {

    @NonNull
    @Override
    public PutResult performPut(@NonNull StorIOSQLite storIOSQLite, @NonNull Result object) {
        return PutResult.newUpdateResult(0, "");
    }
}