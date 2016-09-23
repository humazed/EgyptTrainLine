package com.example.huma.egypttrainline.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.huma.egypttrainline.R;
import com.example.huma.egypttrainline.adapters.TrainsAdapter;
import com.example.huma.egypttrainline.data.tables.Travel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrainsActivity extends AppCompatActivity {
    private static final String TAG = TrainsActivity.class.getSimpleName();
    @BindView(R.id.trains_recyclerView) RecyclerView mTrainsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trains);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        ArrayList<Travel> travels = intent.getParcelableArrayListExtra(MainActivity.KEY_TRAVELS);
        String fromStation = intent.getStringExtra(MainActivity.KEY_FROM_STATION);
        String toStation = intent.getStringExtra(MainActivity.KEY_TO_STATION);

        mTrainsRecyclerView.setAdapter(new TrainsAdapter(travels, fromStation, toStation));
        mTrainsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
