package com.example.huma.egypttrainline.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;

import com.example.huma.egypttrainline.R;
import com.example.huma.egypttrainline.data.DbHelper;
import com.example.huma.egypttrainline.data.tables.Station;
import com.example.huma.egypttrainline.data.tables.StationTableSQLiteTypeMapping;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.impl.DefaultStorIOSQLite;
import com.pushtorefresh.storio.sqlite.queries.Query;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.from_autocomplete) AutoCompleteTextView mFromAutocomplete;
    @BindView(R.id.to_autocomplete) AutoCompleteTextView mToAutocomplete;
    @BindView(R.id.toggle_stations) ImageView mToggleStations;
    @BindView(R.id.go_button) Button mGoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        DbHelper dbHelper = new DbHelper(this);

        StorIOSQLite storIOSQLite = DefaultStorIOSQLite.builder()
                .sqliteOpenHelper(new DbHelper(this))
                .addTypeMapping(Station.class, new StationTableSQLiteTypeMapping())
                .build();

        storIOSQLite
                .get()
                .listOfObjects(Station.class)
                .withQuery(Query.builder()
                        .table(Station.TABLE_NAME)
                        .build())
                .prepare()
                .asRxObservable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(stations -> {
                            ArrayList<String> strings = new ArrayList<>();
                            for (Station station : stations) strings.add(station.StationName);

                            mFromAutocomplete.setAdapter(new ArrayAdapter<>(this,
                                    android.R.layout.simple_dropdown_item_1line, strings));
                            mToAutocomplete.setAdapter(new ArrayAdapter<>(this,
                                    android.R.layout.simple_dropdown_item_1line, strings));
                        }
                        , throwable -> Log.e(TAG, "onCreate: ", throwable));

    }


    @OnClick(R.id.go_button)
    public void onClick() {
        Log.d(TAG, "onClick " + mFromAutocomplete.getText() + " ? " + mToAutocomplete.getText());
        SimpleDateFormat inFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.US);
        SimpleDateFormat outFormat = new SimpleDateFormat("hh:mm a", Locale.US);
        try {
            Date date = inFormat.parse("1899/12/30 13:30:00");
            Log.d(TAG, "onClick " + outFormat.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

