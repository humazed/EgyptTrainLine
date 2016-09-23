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
@StorIOSQLiteType(table = Train.TABLE_NAME)
@StorIOContentResolverType(uri = Train.CONTENT_URI_STRING)
public class Train implements BaseColumns, Parcelable {
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

    @Override
    public String toString() {
        return "Train{" +
                "ID=" + ID +
                ", TrainNumber='" + TrainNumber + '\'' +
                ", FK_TrolleyTypeID='" + FK_TrolleyTypeID + '\'' +
                ", FK_TrainLineID='" + FK_TrainLineID + '\'' +
                ", FK_WorkingState='" + FK_WorkingState + '\'' +
                '}';
    }

    public Train() {
    }

    protected Train(Parcel in) {
        ID = in.readInt();
        TrainNumber = in.readString();
        FK_TrolleyTypeID = in.readString();
        FK_TrainLineID = in.readString();
        FK_WorkingState = in.readString();
    }

    public static final Creator<Train> CREATOR = new Creator<Train>() {
        @Override
        public Train createFromParcel(Parcel in) {
            return new Train(in);
        }

        @Override
        public Train[] newArray(int size) {
            return new Train[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeString(TrainNumber);
        dest.writeString(FK_TrolleyTypeID);
        dest.writeString(FK_TrainLineID);
        dest.writeString(FK_WorkingState);
    }

    public int getID() {
        return ID;
    }

    public String getTrainNumber() {
        return TrainNumber;
    }

    public String getFK_TrolleyTypeID() {
        return FK_TrolleyTypeID;
    }

    public String getFK_TrainLineID() {
        return FK_TrainLineID;
    }

    public String getFK_WorkingState() {
        return FK_WorkingState;
    }
}
