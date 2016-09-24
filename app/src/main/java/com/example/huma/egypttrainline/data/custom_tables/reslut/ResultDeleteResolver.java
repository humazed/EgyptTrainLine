package com.example.huma.egypttrainline.data.custom_tables.reslut;

import android.support.annotation.NonNull;

import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.operations.delete.DeleteResolver;
import com.pushtorefresh.storio.sqlite.operations.delete.DeleteResult;

/**
 * User: huma
 * Date: 24-Sep-16
 */

public class ResultDeleteResolver extends DeleteResolver<Result> {
    @NonNull
    @Override
    public DeleteResult performDelete(@NonNull StorIOSQLite storIOSQLite, @NonNull Result object) {
        return DeleteResult.newInstance(0, "");
    }
}
