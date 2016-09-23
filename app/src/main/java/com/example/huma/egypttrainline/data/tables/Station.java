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
 * Date: 20-Sep-16
 */
@StorIOSQLiteType(table = Station.TABLE_NAME)
@StorIOContentResolverType(uri = Station.CONTENT_URI_STRING)
public class Station implements BaseColumns, Parcelable {
    public static final String PATH = "station";
    public static final String CONTENT_URI_STRING = TrainContract.BASE_CONTENT_URI_STRING + "/" + PATH;
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

    @Override
    public String toString() {
        return "Station{" +
                "ID=" + ID +
                ", StationName='" + StationName + '\'' +
                ", StationArabic='" + StationArabic + '\'' +
                '}';
    }

    public Station() {
    }

    //Parcelable impl
    protected Station(Parcel in) {
        ID = in.readInt();
        StationName = in.readString();
        StationArabic = in.readString();
    }

    public static final Creator<Station> CREATOR = new Creator<Station>() {
        @Override
        public Station createFromParcel(Parcel in) {
            return new Station(in);
        }

        @Override
        public Station[] newArray(int size) {
            return new Station[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeString(StationName);
        dest.writeString(StationArabic);
    }

    public int getID() {
        return ID;
    }

    public String getStationName() {
        return StationName;
    }

    public String getStationArabic() {
        return StationArabic;
    }
}
