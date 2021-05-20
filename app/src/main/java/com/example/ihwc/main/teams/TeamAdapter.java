package com.example.ihwc.main.teams;

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

import com.example.ihwc.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {

    private ArrayList<Team> teams;
    private Context context;
    final private OnListItemClickListener mOnListClickListener;
    private SharedPreferences pref;

    public TeamAdapter(ArrayList<Team> teams, Context context, OnListItemClickListener listener) {
        this.teams = teams;
        this.context = context;
        mOnListClickListener=listener;
        pref= context.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.team_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.icon.setImageResource(teams.get(position).getFlagIcon());
        holder.country.setText(teams.get(position).getCountry());
        holder.itemView.setOnClickListener(v -> mOnListClickListener.onListItemClick(position));
        if(pref.getString("favorite", "def").equals(teams.get(position).getCountryShort())){
            holder.favorite.setImageResource(R.drawable.ic_baseline_favorite_24_green);
        }else{
        holder.favorite.setImageResource(R.drawable.ic_baseline_favorite_border_24_green);}
        holder.favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!pref.getString("favorite", "def").equals(teams.get(position).getCountryShort())){
                holder.favorite.setImageResource(R.drawable.ic_baseline_favorite_24_green);
                    SharedPreferences.Editor editor= pref.edit();
                    editor.remove("favorite");
                    editor.apply();
                    editor.putString("favorite", teams.get(position).getCountryShort());
                    editor.apply();
                }else{
                    holder.favorite.setImageResource(R.drawable.ic_baseline_favorite_border_24_green);
                    SharedPreferences.Editor editor= pref.edit();
                    editor.remove("favorite");
                    editor.apply();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView icon;
        TextView country;
        ImageButton favorite;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
           icon=itemView.findViewById(R.id.flag);
           country=itemView.findViewById(R.id.country);
           favorite=itemView.findViewById(R.id.favorite);
           itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnListClickListener.onListItemClick(getAdapterPosition());
        }
    }
    public interface OnListItemClickListener{
        void onListItemClick(int clickedItemIndex);
    }
}
