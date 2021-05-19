package com.example.ihwc.ui.teamInfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ihwc.R;
import com.example.ihwc.ui.schedule.Game;

import java.util.ArrayList;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.ViewHolder>{

    private ArrayList<Game> games;
    private Context context;

    public GamesAdapter(ArrayList<Game> games, Context context) {
        this.games = games;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.schedule_item, parent, false);
        return new GamesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(context).load(games.get(position).getTeam1F()).into(holder.flagTeam1);
        Glide.with(context).load(games.get(position).getTeam2F()).into(holder.flagTeam2);
        holder.team1.setText(games.get(position).getTeam1C());
        holder.team2.setText(games.get(position).getTeam2C());
        holder.scoreTeam1.setText(games.get(position).getScoreTeam1());
        holder.scoreTeam2.setText(games.get(position).getScoreTeam2());
        holder.gameNo_time.setText(games.get(position).getGameNo_time());
        holder.status.setText(games.get(position).getStatus());
        holder.fanCount1.setText(String.valueOf(games.get(position).getFanCount1()));
        holder.fanCount2.setText(String.valueOf(games.get(position).getFanCount2()));
        holder.fanTeam1.setVisibility(View.GONE);
        holder.fanTeam2.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
    ImageView flagTeam1;
    ImageView flagTeam2;
    TextView team1;
    TextView team2;
    TextView scoreTeam1;
    TextView scoreTeam2;
    TextView gameNo_time;
    TextView status;
    ImageButton fanTeam1;
    ImageButton fanTeam2;
    TextView fanCount1;
    TextView fanCount2;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        flagTeam1 = itemView.findViewById(R.id.flagTeam1);
        flagTeam2 = itemView.findViewById(R.id.flagTeam2);
        team1 = itemView.findViewById(R.id.team1);
        team2 = itemView.findViewById(R.id.team2);
        scoreTeam1 = itemView.findViewById(R.id.scoreTeam1);
        scoreTeam2 = itemView.findViewById(R.id.scoreTeam2);
        gameNo_time = itemView.findViewById(R.id.gameNo_time);
        status = itemView.findViewById(R.id.status);
        fanTeam1=itemView.findViewById(R.id.fanTeam1);
        fanTeam2=itemView.findViewById(R.id.fanTeam2);
        fanCount1=itemView.findViewById(R.id.fanCount1);
        fanCount2=itemView.findViewById(R.id.fanCount2);
    }
}
}
