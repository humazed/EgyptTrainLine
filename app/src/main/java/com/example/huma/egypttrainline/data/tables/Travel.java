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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * User: huma
 * Date: 22-Sep-16
 */
@StorIOSQLiteType(table = Travel.TABLE_NAME)
@StorIOContentResolverType(uri = Travel.CONTENT_URI_STRING)
public class Travel implements BaseColumns, Parcelable {
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

    public String getTravelDuration() {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.US);
        try {
            Date d1 = format.parse(StartTime);
            Date d2 = format.parse(ArriveTime);
            Map<TimeUnit, Long> timeMap = Travel.computeDiff(d1, d2);
            Long hDiff = timeMap.get(TimeUnit.HOURS);
            Long mDiff = timeMap.get(TimeUnit.MINUTES);
            if (hDiff < 0) hDiff += 23;
            if (mDiff < 0) mDiff += 59;
            return String.format("%s hrs %s mins", hDiff, mDiff);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static Map<TimeUnit, Long> computeDiff(Date date1, Date date2) {
        long diffInMillies = date2.getTime() - date1.getTime();
        List<TimeUnit> units = new ArrayList<>(EnumSet.allOf(TimeUnit.class));
        Collections.reverse(units);
        Map<TimeUnit, Long> result = new LinkedHashMap<>();
        long milliesRest = diffInMillies;
        for (TimeUnit unit : units) {
            long diff = unit.convert(milliesRest, TimeUnit.MILLISECONDS);
            long diffInMilliesForUnit = unit.toMillis(diff);
            milliesRest = milliesRest - diffInMilliesForUnit;
            result.put(unit, diff);
        }
        return result;
    }

    public static String formatDate(String date) {
        SimpleDateFormat inFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.US);
        SimpleDateFormat outFormat = new SimpleDateFormat("hh:mm a", Locale.US);
        try {
            Date d = inFormat.parse(date);
            return outFormat.format(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


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

    public Travel() {
    }

    //Parcelable impl
    protected Travel(Parcel in) {
        ID = in.readInt();
        FK_TrainID = in.readString();
        FK_StartStationID = in.readString();
        FK_ArriveStationID = in.readString();
        StartTime = in.readString();
        ArriveTime = in.readString();
        TNumber = in.readString();
    }

    public static final Creator<Travel> CREATOR = new Creator<Travel>() {
        @Override
        public Travel createFromParcel(Parcel in) {
            return new Travel(in);
        }

        @Override
        public Travel[] newArray(int size) {
            return new Travel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeString(FK_TrainID);
        dest.writeString(FK_StartStationID);
        dest.writeString(FK_ArriveStationID);
        dest.writeString(StartTime);
        dest.writeString(ArriveTime);
        dest.writeString(TNumber);
    }

    public int getID() {
        return ID;
    }

    public String getFK_TrainID() {
        return FK_TrainID;
    }

    public String getFK_StartStationID() {
        return FK_StartStationID;
    }

    public String getFK_ArriveStationID() {
        return FK_ArriveStationID;
    }

    public String getStartTime() {
        return StartTime;
    }

    public String getArriveTime() {
        return ArriveTime;
    }

    public String getTNumber() {
        return TNumber;
    }
}
