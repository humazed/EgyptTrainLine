package com.example.huma.egypttrainline.adapters;

import android.support.percent.PercentFrameLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.huma.egypttrainline.R;
import com.example.huma.egypttrainline.data.custom_tables.reslut.Result;
import com.example.huma.egypttrainline.data.tables.Travel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * User: huma
 * Date: 21-Sep-16
 */

public class TrainsAdapter extends RecyclerView.Adapter<TrainsAdapter.TrainVH> {
    private static final String TAG = TrainsAdapter.class.getSimpleName();

    private final ArrayList<Result> mResults;
    private final String mFromStation;
    private final String mToStation;

    public TrainsAdapter(ArrayList<Result> results, String fromStation, String toStation) {
        mResults = results;
        mFromStation = fromStation;
        mToStation = toStation;
    }

    @Override
    public TrainVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_journey_planner_result, parent, false);
        return new TrainVH(view);
    }

    @Override
    public void onBindViewHolder(TrainVH holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mResults.size();
    }

    class TrainVH extends RecyclerView.ViewHolder {
        @BindView(R.id.origin_station_name) TextView mOriginStationName;
        @BindView(R.id.origin_station_time) TextView mOriginStationTime;
        @BindView(R.id.dest_station_time) TextView mDestStationTime;
        @BindView(R.id.dest_station_name) TextView mDestStationName;
        @BindView(R.id.journey_duration) TextView mJourneyDuration;
        @BindView(R.id.journey_changes) TextView mJourneyChanges;
        @BindView(R.id.journey_planner_bar) ImageView mJourneyPlannerBar;
        @BindView(R.id.journey_planner_changes_bar) PercentFrameLayout mJourneyPlannerChangesBar;
        @BindView(R.id.journey_planner_bar_vertical_layout) ImageView mJourneyPlannerBarVerticalLayout;
        @BindView(R.id.journey_leg_description) TextView mJourneyLegDescription;
        @BindView(R.id.journey_cost) TextView mJourneyCost;
        @BindView(R.id.journey_planner_result_row_divider) View mJourneyPlannerResultRowDivider;

        TrainVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(int position) {
            Result result = mResults.get(position);
            mOriginStationName.setText(mFromStation);
            mOriginStationTime.setText(Travel.formatDate(result.getStartTime()));
            mDestStationName.setText(mToStation);
            mDestStationTime.setText(Travel.formatDate(result.getArriveTime()));
            mJourneyDuration.setText(result.getTravelDuration());

        }
    }
}





