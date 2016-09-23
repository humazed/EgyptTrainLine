package com.example.huma.egypttrainline.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.huma.egypttrainline.R;
import com.example.huma.egypttrainline.data.DbHelper;
import com.example.huma.egypttrainline.data.tables.Station;
import com.example.huma.egypttrainline.data.tables.StationSQLiteTypeMapping;
import com.example.huma.egypttrainline.data.tables.Travel;
import com.example.huma.egypttrainline.data.tables.TravelSQLiteTypeMapping;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.impl.DefaultStorIOSQLite;
import com.pushtorefresh.storio.sqlite.queries.Query;
import com.pushtorefresh.storio.sqlite.queries.RawQuery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    public static final String KEY_TO_STATION = "toStation";
    public static final String KEY_TRAVELS = "travels";
    public static final String KEY_FROM_STATION = "fromStation";

    @BindView(R.id.from_autocomplete) AutoCompleteTextView mFromAutocomplete;
    @BindView(R.id.to_autocomplete) AutoCompleteTextView mToAutocomplete;
    @BindView(R.id.toggle_stations) ImageView mToggleStations;
    @BindView(R.id.go_button) Button mGoButton;

    private StorIOSQLite mStorIOSQLite;
    private ArrayList<String> mStationNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        SimpleDateFormat inFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.US);
        try {
            Date d1 = inFormat.parse("1899/12/30 04:20:00");
            Date d2 = inFormat.parse("1899/12/30 05:40:00");
            Map<TimeUnit, Long> timeMap = Travel.computeDiff(d1, d2);
            Log.d(TAG, "onCreate timeMap: " + timeMap.get(TimeUnit.HOURS));
            Log.d(TAG, "onCreate timeMap: " + timeMap.get(TimeUnit.MINUTES));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        mStorIOSQLite = DefaultStorIOSQLite.builder()
                .sqliteOpenHelper(new DbHelper(this))
                .addTypeMapping(Station.class, new StationSQLiteTypeMapping())
                .addTypeMapping(Travel.class, new TravelSQLiteTypeMapping())
                .build();

        mStorIOSQLite
                .get()
                .listOfObjects(Station.class)
                .withQuery(Query.builder()
                        .table(Station.TABLE_NAME)
                        .build())
                .prepare()
                .asRxObservable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(stations -> {
                            mStationNames = new ArrayList<>();
                            for (Station station : stations) mStationNames.add(station.StationName);

                            mFromAutocomplete.setAdapter(new ArrayAdapter<>(this,
                                    android.R.layout.simple_dropdown_item_1line, mStationNames));
                            mToAutocomplete.setAdapter(new ArrayAdapter<>(this,
                                    android.R.layout.simple_dropdown_item_1line, mStationNames));
                        }
                        , throwable -> Log.e(TAG, "onCreate: ", throwable));

    }


    @OnClick(R.id.go_button)
    public void onClick() {
        if (mFromAutocomplete.getText().toString().isEmpty() || mToAutocomplete.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, R.string.choose_station_msg, Toast.LENGTH_LONG).show();
        } else {

            int fromStationId = mStationNames.indexOf(mFromAutocomplete.getText().toString()) + 1;
            int toStationId = mStationNames.indexOf(mToAutocomplete.getText().toString()) + 1;

            Log.d(TAG, "onClick " + "fromID: " + fromStationId);
            Log.d(TAG, "onClick " + "toID: " + toStationId);

            mStorIOSQLite.get()
                    .listOfObjects(Travel.class)
                    .withQuery(RawQuery.builder()
                            .query("SELECT" +
                                    " t.* " +
                                    "FROM Travel AS t" +
                                    " INNER JOIN Station AS s1 ON t.FK_StartStationID = s1._id" +
                                    " INNER JOIN Station AS s2 ON t.FK_ArriveStationID = s2._id" +
                                    " WHERE t.FK_StartStationID = ? AND t.FK_ArriveStationID = ?;")
                            .args(fromStationId, toStationId)
                            .build())
                    .prepare()
                    .asRxObservable()
                    .subscribe(travels -> {
                        Intent intent = new Intent(MainActivity.this, TrainsActivity.class);
                        intent.putParcelableArrayListExtra(KEY_TRAVELS, new ArrayList<>(travels));
                        intent.putExtra(KEY_FROM_STATION, mFromAutocomplete.getText().toString());
                        intent.putExtra(KEY_TO_STATION, mToAutocomplete.getText().toString());
                        startActivity(intent);
                        Log.d(TAG, "onClick " + travels);
                    }, throwable -> {
                        Log.e(TAG, "onClick: ", throwable);
                    });
        }
        Log.d(TAG, "onClick " + mFromAutocomplete.getText() + " ? " + mToAutocomplete.getText());
    }
}

