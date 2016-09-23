package com.example.huma.egypttrainline.data.tables;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
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
@StorIOSQLiteType(table = WorkingState.TABLE_NAME)
@StorIOContentResolverType(uri = WorkingState.CONTENT_URI_STRING)
public class WorkingState implements BaseColumns, Parcelable {
    public static final String PATH = "workingstate";
    public static final String CONTENT_URI_STRING = TrainContract.BASE_CONTENT_URI_STRING + "/" + PATH;
    public static final Uri CONTENT_URI = Uri.parse(CONTENT_URI_STRING);

    public static final String TABLE_NAME = "WorkingState";

    public static final String COLUMN_STATE = "State";

    @StorIOSQLiteColumn(name = _ID, key = true)
    @StorIOContentResolverColumn(name = _ID, key = true)
    public int ID;
    @StorIOSQLiteColumn(name = COLUMN_STATE)
    @StorIOContentResolverColumn(name = COLUMN_STATE)
    String State;

    @Override
    public String toString() {
        return "WorkingState{" +
                "ID=" + ID +
                ", State='" + State + '\'' +
                '}';
    }

    public WorkingState() {
    }

    protected WorkingState(Parcel in) {
        ID = in.readInt();
        State = in.readString();
    }

    public static final Creator<WorkingState> CREATOR = new Creator<WorkingState>() {
        @Override
        public WorkingState createFromParcel(Parcel in) {
            return new WorkingState(in);
        }

        @Override
        public WorkingState[] newArray(int size) {
            return new WorkingState[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeString(State);
    }

    public int getID() {
        return ID;
    }

    public String getState() {
        return State;
    }
}
