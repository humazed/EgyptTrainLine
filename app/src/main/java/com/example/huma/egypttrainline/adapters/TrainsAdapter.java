package com.example.huma.egypttrainline.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.huma.egypttrainline.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * User: huma
 * Date: 21-Sep-16
 */

public class TrainsAdapter extends RecyclerView.Adapter<TrainsAdapter.TrainVH> {

    @Override
    public TrainVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_train, parent, false);
        return new TrainVH(view);
    }

    @Override
    public void onBindViewHolder(TrainVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class TrainVH extends RecyclerView.ViewHolder {
        @BindView(R.id.train_name_textView) TextView mTrainNameTextView;

        public TrainVH(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }
    }
}
