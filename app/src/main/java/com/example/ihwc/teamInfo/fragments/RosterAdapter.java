package com.example.ihwc.teamInfo.fragments;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ihwc.R;


import org.jetbrains.annotations.NotNull;

import java.util.List;


public class RosterAdapter extends  RecyclerView.Adapter<RosterAdapter.ViewHolder>{

    private Context context;
    private List<Player> players;

    public RosterAdapter(Context context, List<Player> players) {
        this.context = context;
        this.players = players;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.player_item, parent, false);
        return new RosterAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.name.setText(players.get(position).name);
        if(players.get(position).number!=0){
        holder.number.setText(String.valueOf(players.get(position).number));}


    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView number;


        public ViewHolder(View itemView) {
           super(itemView);
            name=itemView.findViewById(R.id.rosterName);
            number=itemView.findViewById(R.id.rosterNumber);
        }
    }
}
