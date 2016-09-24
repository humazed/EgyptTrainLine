package com.example.huma.egypttrainline.data.custom_tables.reslut;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.huma.egypttrainline.util.TimeUtils;
import com.pushtorefresh.storio.sqlite.SQLiteTypeMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * User: huma
 * Date: 24-Sep-16
 */

public class Result implements Parcelable {
    public static final String RESULT_QUERY =
            "SELECT\n" +
                    "  t._id            AS FK_TravelID,\n" +
                    "  t.StartTime,\n" +
                    "  t.ArriveTime,\n" +
                    "  s1._id           AS FK_StartStationID,\n" +
                    "  s1.StationName   AS StartStation,\n" +
                    "  s1.StationArabic AS StartStationArabic,\n" +
                    "  s2._id           AS FK_ArriveStationID,\n" +
                    "  s2.StationName   AS ArriveStation,\n" +
                    "  s2.StationArabic AS ArriveStationArabic,\n" +
                    "  tr._id           AS FK_TrainID,\n" +
                    "  tr.TrainNumber   AS TrainNumber\n" +
                    "FROM Travel AS t\n" +
                    "  INNER JOIN Station AS s1 ON t.FK_StartStationID = s1._id\n" +
                    "  INNER JOIN Station AS s2 ON t.FK_ArriveStationID = s2._id\n" +
                    "  INNER JOIN Train AS tr ON t.FK_TrainID = tr._id\n" +
                    "WHERE FK_StartStationID = @StartStationID AND\n" +
                    "      (FK_TrainID IN (\n" +
                    "        SELECT FK_TrainID\n" +
                    "        FROM Travel\n" +
                    "        WHERE FK_StartStationID = @StartStationID\n" +
                    "        INTERSECT\n" +
                    "        SELECT FK_TrainID\n" +
                    "        FROM Travel\n" +
                    "        WHERE FK_ArriveStationID = @ArriveStationID))\n" +
                    "ORDER BY StartTime;";

    public static final String COLUMN_FK_TRAVEL_ID = "FK_TravelID";
    public static final String COLUMN_START_TIME = "StartTime";
    public static final String COLUMN_ARRIVE_TIME = "ArriveTime";
    public static final String COLUMN_FK_START_STATION_ID = "FK_StartStationID";
    public static final String COLUMN_START_STATION = "StartStation";
    public static final String COLUMN_START_STATION_ARABIC = "StartStationArabic";
    public static final String COLUMN_FK_ARRIVE_STATION_ID = "FK_ArriveStationID";
    public static final String COLUMN_ARRIVE_STATION = "ArriveStation";
    public static final String COLUMN_ARRIVE_STATION_ARABIC = "ArriveStationArabic";
    public static final String COLUMN_FK_TRAIN_ID = "FK_TrainID";
    public static final String COLUMN_TRAIN_NUMBER = "TrainNumber";

    private long FK_TravelID;
    private String StartTime;
    private String ArriveTime;
    private long FK_StartStationID;
    private String StartStation;
    private String StartStationArabic;
    private long FK_ArriveStationID;
    private String ArriveStation;
    private String ArriveStationArabic;
    private long FK_TrainID;
    private String TrainNumber;

    public Result(long FK_TravelID, String startTime, String arriveTime,
                  long FK_StartStationID, String startStation, String startStationArabic,
                  long FK_ArriveStationID, String arriveStation, String arriveStationArabic,
                  long FK_TrainID, String trainNumber) {
        this.FK_TravelID = FK_TravelID;
        StartTime = startTime;
        ArriveTime = arriveTime;
        this.FK_StartStationID = FK_StartStationID;
        StartStation = startStation;
        StartStationArabic = startStationArabic;
        this.FK_ArriveStationID = FK_ArriveStationID;
        ArriveStation = arriveStation;
        ArriveStationArabic = arriveStationArabic;
        this.FK_TrainID = FK_TrainID;
        TrainNumber = trainNumber;
    }

    public static SQLiteTypeMapping<Result> MAPPER = SQLiteTypeMapping.<Result>builder()
            .putResolver(new ResultPutResolver())
            .getResolver(new ResultGetResolver())
            .deleteResolver(new ResultDeleteResolver())
            .build();


    public String getTravelDuration() {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.US);
        try {
            Date d1 = format.parse(StartTime);
            Date d2 = format.parse(ArriveTime);
            Map<TimeUnit, Long> timeMap = TimeUtils.computeDiff(d1, d2);
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


    @Override
    public String toString() {
        return "Result{" +
                "FK_TravelID=" + FK_TravelID +
                ", StartTime='" + StartTime + '\'' +
                ", ArriveTime='" + ArriveTime + '\'' +
                ", FK_StartStationID=" + FK_StartStationID +
                ", StartStation='" + StartStation + '\'' +
                ", StartStationArabic='" + StartStationArabic + '\'' +
                ", FK_ArriveStationID=" + FK_ArriveStationID +
                ", ArriveStation='" + ArriveStation + '\'' +
                ", ArriveStationArabic='" + ArriveStationArabic + '\'' +
                ", FK_TrainID=" + FK_TrainID +
                ", TrainNumber='" + TrainNumber + '\'' +
                '}';
    }

    public static final Creator<Result> CREATOR = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };

    private Result(Parcel in) {
        FK_TravelID = in.readLong();
        StartTime = in.readString();
        ArriveTime = in.readString();
        FK_StartStationID = in.readLong();
        StartStation = in.readString();
        StartStationArabic = in.readString();
        FK_ArriveStationID = in.readLong();
        ArriveStation = in.readString();
        ArriveStationArabic = in.readString();
        FK_TrainID = in.readLong();
        TrainNumber = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(FK_TravelID);
        dest.writeString(StartTime);
        dest.writeString(ArriveTime);
        dest.writeLong(FK_StartStationID);
        dest.writeString(StartStation);
        dest.writeString(StartStationArabic);
        dest.writeLong(FK_ArriveStationID);
        dest.writeString(ArriveStation);
        dest.writeString(ArriveStationArabic);
        dest.writeLong(FK_TrainID);
        dest.writeString(TrainNumber);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public long getFK_TravelID() {
        return FK_TravelID;
    }

    public String getStartTime() {
        return StartTime;
    }

    public String getArriveTime() {
        return ArriveTime;
    }

    public long getFK_StartStationID() {
        return FK_StartStationID;
    }

    public String getStartStation() {
        return StartStation;
    }

    public String getStartStationArabic() {
        return StartStationArabic;
    }

    public long getFK_ArriveStationID() {
        return FK_ArriveStationID;
    }

    public String getArriveStation() {
        return ArriveStation;
    }

    public String getArriveStationArabic() {
        return ArriveStationArabic;
    }

    public long getFK_TrainID() {
        return FK_TrainID;
    }

    public String getTrainNumber() {
        return TrainNumber;
    }
}
