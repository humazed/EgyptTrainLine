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
@StorIOSQLiteType(table = TicketPrice.TABLE_NAME)
@StorIOContentResolverType(uri = TicketPrice.CONTENT_URI_STRING)
public class TicketPrice implements BaseColumns, Parcelable {
    public static final String PATH = "ticketprice";
    public static final String CONTENT_URI_STRING = TrainContract.BASE_CONTENT_URI_STRING + "/" + PATH;
    public static final Uri CONTENT_URI = Uri.parse(CONTENT_URI_STRING);

    public static final String TABLE_NAME = "TicketPrice";

    public static final String COLUMN_FK_STATION_ID = "FK_StationID";
    public static final String COLUMN_FIRST_NEW = "FirstNew";
    public static final String COLUMN_CHILD_FIRST_NEW = "ChildFirstNew";
    public static final String COLUMN_SECOND_NEW = "SecondNew";
    public static final String COLUMN_CHILD_SECOND_NEW = "ChildSecondNew";
    public static final String COLUMN_VIP_FIRST = "VIPFirst";
    public static final String COLUMN_VIP_SECOND = "VIPSecond";

    @StorIOSQLiteColumn(name = _ID, key = true)
    @StorIOContentResolverColumn(name = _ID, key = true)
    public int ID;
    @StorIOSQLiteColumn(name = COLUMN_FK_STATION_ID)
    @StorIOContentResolverColumn(name = COLUMN_FK_STATION_ID)
    String FK_StationID;
    @StorIOSQLiteColumn(name = COLUMN_FIRST_NEW)
    @StorIOContentResolverColumn(name = COLUMN_FIRST_NEW)
    String FirstNew;
    @StorIOSQLiteColumn(name = COLUMN_CHILD_FIRST_NEW)
    @StorIOContentResolverColumn(name = COLUMN_CHILD_FIRST_NEW)
    String ChildFirstNew;
    @StorIOSQLiteColumn(name = COLUMN_SECOND_NEW)
    @StorIOContentResolverColumn(name = COLUMN_SECOND_NEW)
    String SecondNew;
    @StorIOSQLiteColumn(name = COLUMN_CHILD_SECOND_NEW)
    @StorIOContentResolverColumn(name = COLUMN_CHILD_SECOND_NEW)
    String ChildSecondNew;
    @StorIOSQLiteColumn(name = COLUMN_VIP_FIRST)
    @StorIOContentResolverColumn(name = COLUMN_VIP_FIRST)
    String VIPFirst;
    @StorIOSQLiteColumn(name = COLUMN_VIP_SECOND)
    @StorIOContentResolverColumn(name = COLUMN_VIP_SECOND)
    String VIPSecond;

    @Override
    public String toString() {
        return "TicketPrice{" +
                "ID=" + ID +
                ", FK_StationID='" + FK_StationID + '\'' +
                ", FirstNew='" + FirstNew + '\'' +
                ", ChildFirstNew='" + ChildFirstNew + '\'' +
                ", SecondNew='" + SecondNew + '\'' +
                ", ChildSecondNew='" + ChildSecondNew + '\'' +
                ", VIPFirst='" + VIPFirst + '\'' +
                ", VIPSecond='" + VIPSecond + '\'' +
                '}';
    }

    public TicketPrice() {
    }

    protected TicketPrice(Parcel in) {
        ID = in.readInt();
        FK_StationID = in.readString();
        FirstNew = in.readString();
        ChildFirstNew = in.readString();
        SecondNew = in.readString();
        ChildSecondNew = in.readString();
        VIPFirst = in.readString();
        VIPSecond = in.readString();
    }

    public static final Creator<TicketPrice> CREATOR = new Creator<TicketPrice>() {
        @Override
        public TicketPrice createFromParcel(Parcel in) {
            return new TicketPrice(in);
        }

        @Override
        public TicketPrice[] newArray(int size) {
            return new TicketPrice[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeString(FK_StationID);
        dest.writeString(FirstNew);
        dest.writeString(ChildFirstNew);
        dest.writeString(SecondNew);
        dest.writeString(ChildSecondNew);
        dest.writeString(VIPFirst);
        dest.writeString(VIPSecond);
    }

    public String getVIPSecond() {
        return VIPSecond;
    }

    public int getID() {
        return ID;
    }

    public String getFK_StationID() {
        return FK_StationID;
    }

    public String getFirstNew() {
        return FirstNew;
    }

    public String getChildFirstNew() {
        return ChildFirstNew;
    }

    public String getSecondNew() {
        return SecondNew;
    }

    public String getChildSecondNew() {
        return ChildSecondNew;
    }

    public String getVIPFirst() {
        return VIPFirst;
    }
}

