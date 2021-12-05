package com.tylerjohnston.workoutapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.RecyclerView;
import com.tylerjohnston.workoutapp.Models.Plan;

public class PlansAdapter extends RecyclerView.Adapter<PlansAdapter.ViewHolder> {

    private ObservableArrayList<Plan> plans;

    public PlansAdapter(ObservableArrayList<Plan> plans) {
        this.plans = plans;
        this.plans.addOnListChangedCallback(new ObservableList.OnListChangedCallback<ObservableList<Plan>>() {
            @Override
            public void onChanged(ObservableList<Plan> sender) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeChanged(ObservableList<Plan> sender, int positionStart, int itemCount) {

                notifyItemRangeChanged(positionStart, itemCount);
            }

            @Override
            public void onItemRangeInserted(ObservableList<Plan> sender, int positionStart, int itemCount) {

                notifyItemRangeInserted(positionStart, itemCount);
            }

            @Override
            public void onItemRangeMoved(ObservableList<Plan> sender, int fromPosition, int toPosition, int itemCount) {

                notifyItemMoved(fromPosition, toPosition);
            }

            @Override
            public void onItemRangeRemoved(ObservableList<Plan> sender, int positionStart, int itemCount) {

                notifyItemRangeRemoved(positionStart, itemCount);
            }
        });

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plan_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        TextView titleTextView = (TextView)holder.itemView.findViewById(R.id.planTitle);
        titleTextView.setText(plans.get(position).Title);

        TextView descTextView = (TextView)holder.itemView.findViewById(R.id.planDesc);
        descTextView.setText(plans.get(position).Description);
    }

    @Override
    public int getItemCount() {
        return plans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
