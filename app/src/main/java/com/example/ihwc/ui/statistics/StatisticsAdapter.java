package com.example.ihwc.ui.statistics;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ihwc.R;
import com.example.ihwc.ui.teamInfo.Player;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class StatisticsAdapter extends FirebaseRecyclerAdapter<Player, StatisticsAdapter.ViewHolder> {

    List<Integer> rank;
    Context context;

    public StatisticsAdapter(@NonNull FirebaseRecyclerOptions<Player> options, List<Integer> rank ,Context context) {
        super(options);
        this.rank=rank;
        this.context=context;
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Player model) {
        holder.rank.setText(String.valueOf(rank.get(position)));
        holder.sName.setText(model.name);
        holder.statisticsCountry.setText(model.country);
        holder.goals.setText(String.valueOf(model.gs));
        holder.assists.setText(String.valueOf(model.a));
        holder.points.setText(String.valueOf(model.pts));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.statistics_item, parent, false);
        return new StatisticsAdapter.ViewHolder(view);
    }

    @NonNull
    @NotNull
    @Override
    public Player getItem(int position) {
        return super.getItem(getItemCount()-1-position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView rank;
        TextView sName;
        TextView statisticsCountry;
        TextView goals;
        TextView assists;
        TextView points;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rank=itemView.findViewById(R.id.rank);
            sName=itemView.findViewById(R.id.sName);
            statisticsCountry=itemView.findViewById(R.id.statisticsCountry);
            goals=itemView.findViewById(R.id.goals);
            assists=itemView.findViewById(R.id.assists);
            points=itemView.findViewById(R.id.playerPoints);

        }
    }
}
