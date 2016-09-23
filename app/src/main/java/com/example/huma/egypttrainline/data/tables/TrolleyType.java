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
@StorIOSQLiteType(table = TrolleyType.TABLE_NAME)
@StorIOContentResolverType(uri = TrolleyType.CONTENT_URI_STRING)
public class TrolleyType implements BaseColumns,Parcelable {
    public static final String PATH = "trolleytype";
    public static final String CONTENT_URI_STRING = TrainContract.BASE_CONTENT_URI_STRING + "/" + PATH;
    public static final Uri CONTENT_URI = Uri.parse(CONTENT_URI_STRING);

    public static final String TABLE_NAME = "TrolleyType";

    public static final String COLUMN_TYPE = "Type";
    public static final String COLUMN_TYPE_ARABIC = "TypeArabic";


    @StorIOSQLiteColumn(name = _ID, key = true)
    @StorIOContentResolverColumn(name = _ID, key = true)
    public int ID;
    @StorIOSQLiteColumn(name = COLUMN_TYPE)
    @StorIOContentResolverColumn(name = COLUMN_TYPE)
    String Type;
    @StorIOSQLiteColumn(name = COLUMN_TYPE_ARABIC)
    @StorIOContentResolverColumn(name = COLUMN_TYPE_ARABIC)
    String TypeArabic;

    protected TrolleyType(Parcel in) {
        ID = in.readInt();
        Type = in.readString();
        TypeArabic = in.readString();
    }

    public static final Creator<TrolleyType> CREATOR = new Creator<TrolleyType>() {
        @Override
        public TrolleyType createFromParcel(Parcel in) {
            return new TrolleyType(in);
        }

        @Override
        public TrolleyType[] newArray(int size) {
            return new TrolleyType[size];
        }
    };

    @Override
    public String toString() {
        return "TrolleyType{" +
                "ID=" + ID +
                ", Type='" + Type + '\'' +
                ", TypeArabic='" + TypeArabic + '\'' +
                '}';
    }

    public TrolleyType() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeString(Type);
        dest.writeString(TypeArabic);
    }

    public String getTypeArabic() {
        return TypeArabic;
    }

    public int getID() {
        return ID;
    }

    public String getType() {
        return Type;
    }
}
