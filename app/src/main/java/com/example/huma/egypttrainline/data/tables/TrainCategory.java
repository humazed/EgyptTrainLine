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
@StorIOSQLiteType(table = TrainCategory.TABLE_NAME)
@StorIOContentResolverType(uri = TrainCategory.CONTENT_URI_STRING)
public class TrainCategory implements BaseColumns,Parcelable {
    public static final String PATH = "traincategory";
    public static final String CONTENT_URI_STRING = TrainContract.BASE_CONTENT_URI_STRING + "/" + PATH;
    public static final Uri CONTENT_URI = Uri.parse(CONTENT_URI_STRING);

    public static final String TABLE_NAME = "TrainCategory";

    public static final String COLUMN_CATEGORY = "Category";
    public static final String COLUMN_CATEGORY_ARABIC = "CategoryArabic";


    @StorIOSQLiteColumn(name = _ID, key = true)
    @StorIOContentResolverColumn(name = _ID, key = true)
    public int ID;
    @StorIOSQLiteColumn(name = COLUMN_CATEGORY)
    @StorIOContentResolverColumn(name = COLUMN_CATEGORY)
    String Category;
    @StorIOSQLiteColumn(name = COLUMN_CATEGORY_ARABIC)
    @StorIOContentResolverColumn(name = COLUMN_CATEGORY_ARABIC)
    String CategoryArabic;
    @Override
    public String toString() {
        return "TrainCategory{" +
                "ID=" + ID +
                ", Category='" + Category + '\'' +
                ", CategoryArabic='" + CategoryArabic + '\'' +
                '}';
    }

    public TrainCategory() {
    }

    protected TrainCategory(Parcel in) {
        ID = in.readInt();
        Category = in.readString();
        CategoryArabic = in.readString();
    }

    public static final Creator<TrainCategory> CREATOR = new Creator<TrainCategory>() {
        @Override
        public TrainCategory createFromParcel(Parcel in) {
            return new TrainCategory(in);
        }

        @Override
        public TrainCategory[] newArray(int size) {
            return new TrainCategory[size];
        }
    };



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeString(Category);
        dest.writeString(CategoryArabic);
    }

    public String getCategoryArabic() {
        return CategoryArabic;
    }

    public int getID() {
        return ID;
    }

    public String getCategory() {
        return Category;
    }
}
