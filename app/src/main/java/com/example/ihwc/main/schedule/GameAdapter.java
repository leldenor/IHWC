package com.example.ihwc.main.schedule;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
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
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;

public class GameAdapter extends FirebaseRecyclerAdapter<Game, GameAdapter.ViewHolder>{

    Context context;
    private SharedPreferences pref;
    private DatabaseReference database;

    public GameAdapter(@NonNull FirebaseRecyclerOptions<Game> options, Context context) {
        super(options);
        this.context=context;
        pref=context.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        database= FirebaseDatabase.getInstance("https://ihwc-app-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Games");
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.schedule_item, parent, false);
        return new GameAdapter.ViewHolder(view);
    }


    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Game model) {
        String fan=pref.getString(model.getGameNo_time(),"def");

        final SharedPreferences.Editor editor = pref.edit();
        Glide.with(context).load(model.getTeam1F()).into(holder.flagTeam1);
        Glide.with(context).load(model.getTeam2F()).into(holder.flagTeam2);
        holder.team1.setText(model.getTeam1C());
        holder.team2.setText(model.getTeam2C());
        holder.scoreTeam1.setText(model.getScoreTeam1());
        holder.scoreTeam2.setText(model.getScoreTeam2());
        holder.gameNo_time.setText(model.getGameNo_time());
        holder.status.setText(model.getStatus());
        holder.date.setText(model.getDate());
        holder.fanCount1.setText(String.valueOf(model.getFanCount1()));
        holder.fanCount2.setText(String.valueOf(model.getFanCount2()));
        if(fan.equals(model.getTeam1C())){
            holder.fanTeam1.setImageResource(R.drawable.ic_baseline_star_24);
            holder.fanTeam2.setImageResource(R.drawable.ic_baseline_star_outline_24);
        }else if(fan.equals(model.getTeam2C())){
            holder.fanTeam2.setImageResource(R.drawable.ic_baseline_star_24);
            holder.fanTeam1.setImageResource(R.drawable.ic_baseline_star_outline_24);
        }else{
            holder.fanTeam1.setImageResource(R.drawable.ic_baseline_star_outline_24);
            holder.fanTeam2.setImageResource(R.drawable.ic_baseline_star_outline_24);
        }

        holder.fanTeam1.setOnClickListener(v -> {


            if(fan.equals(model.getTeam2C())) {
                database.getRef().child(position+"").child("fanCount1").setValue(ServerValue.increment(1));
                database.getRef().child(position+"").child("fanCount2").setValue(ServerValue.increment(-1));

                holder.fanTeam1.setImageResource(R.drawable.ic_baseline_star_24);
                holder.fanTeam2.setImageResource(R.drawable.ic_baseline_star_outline_24);
                editor.remove(model.getGameNo_time());
                editor.apply();
                editor.putString(model.getGameNo_time(), model.getTeam1C());
                editor.apply();

            }else if(fan.equals(model.getTeam1C())){
                database.getRef().child(position+"").child("fanCount1").setValue(ServerValue.increment(-1));

                holder.fanTeam1.setImageResource(R.drawable.ic_baseline_star_outline_24);
                editor.remove(model.getGameNo_time());
                editor.apply();

            }else{
                database.getRef().child(position+"").child("fanCount1").setValue(ServerValue.increment(1));
                holder.fanTeam1.setImageResource(R.drawable.ic_baseline_star_24);
                editor.putString(model.getGameNo_time(), model.getTeam1C());
                editor.apply();
            }

        });


        holder.fanTeam2.setOnClickListener(v -> {

            if(fan.equals(model.getTeam1C())) {
                database.getRef().child(position+"").child("fanCount1").setValue(ServerValue.increment(-1));
                database.getRef().child(position+"").child("fanCount2").setValue(ServerValue.increment(1));

                holder.fanTeam2.setImageResource(R.drawable.ic_baseline_star_24);
                holder.fanTeam1.setImageResource(R.drawable.ic_baseline_star_outline_24);
                editor.remove(model.getGameNo_time());
                editor.apply();
                editor.putString(model.getGameNo_time(), model.getTeam2C());
                editor.apply();

            }else if(fan.equals(model.getTeam2C())){
                database.getRef().child(position+"").child("fanCount2").setValue(ServerValue.increment(-1));
                holder.fanTeam2.setImageResource(R.drawable.ic_baseline_star_outline_24);
                editor.remove(model.getGameNo_time());
                editor.apply();
            }else{
                database.getRef().child(position+"").child("fanCount2").setValue(ServerValue.increment(1));
                holder.fanTeam2.setImageResource(R.drawable.ic_baseline_star_24);
                editor.putString(model.getGameNo_time(), model.getTeam2C());
                editor.apply();

            }

        });



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
        TextView date;
        ImageButton fanTeam1;
        ImageButton fanTeam2;
        TextView fanCount1;
        TextView fanCount2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.gameDate);
            flagTeam1=itemView.findViewById(R.id.flagTeam1);
            flagTeam2=itemView.findViewById(R.id.flagTeam2);
            team1=itemView.findViewById(R.id.team1);
            team2=itemView.findViewById(R.id.team2);
            scoreTeam1=itemView.findViewById(R.id.scoreTeam1);
            scoreTeam2=itemView.findViewById(R.id.scoreTeam2);
            gameNo_time=itemView.findViewById(R.id.gameNo_time);
            status=itemView.findViewById(R.id.status);
            fanCount1=itemView.findViewById(R.id.fanCount1);
            fanCount2=itemView.findViewById(R.id.fanCount2);
            fanTeam1=itemView.findViewById(R.id.fanTeam1);
            fanTeam2=itemView.findViewById(R.id.fanTeam2);
        }
    }
}
