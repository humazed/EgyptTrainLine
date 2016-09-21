package com.example.huma.egypttrainline.data;

import android.net.Uri;

/**
 * User: huma
 * Date: 20-Sep-16
 */
public class TrainContract {
    public static final String CONTENT_AUTHORITY = "com.example.huma.egypttrainline.train_provider";

    public static final String BASE_CONTENT_URI_STRING = "content://" + CONTENT_AUTHORITY;
    public static final Uri BASE_CONTENT_URI = Uri.parse(BASE_CONTENT_URI_STRING);


    public static final String PATH_STATION = "station";
}