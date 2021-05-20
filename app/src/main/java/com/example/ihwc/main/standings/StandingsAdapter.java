package com.example.ihwc.main.standings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ihwc.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class StandingsAdapter extends FirebaseRecyclerAdapter<Standings, StandingsAdapter.ViewHolder> {

    private Context context;

    public StandingsAdapter(@NonNull FirebaseRecyclerOptions<Standings> options, Context context) {
        super(options);
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.standings_item, parent, false);
        return new StandingsAdapter.ViewHolder(view);
    }


    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Standings model) {
        holder.position.setText(model.getRanking());
        Glide.with(context).load(model.getFlag()).into(holder.flag);
        holder.country.setText(model.getTeam());
        holder.points.setText(model.getPoints());
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView position;
        ImageView flag;
        TextView country;
        TextView points;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            position=itemView.findViewById(R.id.position);
            flag=itemView.findViewById(R.id.sFlag);
            country=itemView.findViewById(R.id.sCountry);
            points=itemView.findViewById(R.id.points);
        }
    }
}
