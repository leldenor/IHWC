package com.example.ihwc.game;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ihwc.R;
import com.example.ihwc.main.schedule.Game;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GuessGameAdapter extends FirebaseRecyclerAdapter<Game, GuessGameAdapter.ViewHolder> {
    Context context;
    List<GuessGame> gameList;
    boolean isOnTextChange1=false;
    boolean isOnTextChange2=false;
    List<Integer> score1List=new ArrayList<>();
    List<Integer> score2List=new ArrayList<>();
    String userId;
    DatabaseReference database;

    public GuessGameAdapter(@NonNull @NotNull FirebaseRecyclerOptions<Game> options, Context context, List<GuessGame> gameList, String userId) {
        super(options);
        this.context=context;
        this.gameList=gameList;
        this.userId=userId;

    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position, @NonNull @NotNull Game model) {
        Glide.with(context).load(model.getTeam1F()).into(holder.flagTeam1);
        Glide.with(context).load(model.getTeam2F()).into(holder.flagTeam2);
        holder.team1.setText(model.getTeam1C());
        holder.team2.setText(model.getTeam2C());
        holder.date.setText(model.getDate());
        holder.gameNo_time.setText(model.getGameNo_time());
        holder.status.setText(model.getStatus());

        score1List.add(position, gameList.get(position).gScoreTeam1);
        score2List.add(position, gameList.get(position).gScoreTeam2);

        Button save= holder.save;
        EditText gScoreTeam1=holder.gScoreTeam1;
        EditText gScoreTeam2=holder.gScoreTeam2;

        if(model.getStatus().equals("SCHEDULED")){

            holder.actualScore.setVisibility(View.GONE);
            holder.guessScore1.setVisibility(View.GONE);
            holder.guessScore2.setVisibility(View.GONE);
            holder.save.setVisibility(View.VISIBLE);
            holder.gScoreTeam1.setVisibility(View.VISIBLE);
            holder.gScoreTeam2.setVisibility(View.VISIBLE);


            gScoreTeam1.setText(String.valueOf(gameList.get(position).gScoreTeam1), TextView.BufferType.EDITABLE);
            gScoreTeam2.setText(String.valueOf(gameList.get(position).gScoreTeam2), TextView.BufferType.EDITABLE);


        gScoreTeam1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                isOnTextChange1=true;
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(isOnTextChange1){
                    isOnTextChange1=false;

                    try {
                            for(int i=0;i<=position;i++){
                                int inPosition=position;
                                if(i!=position){
                                    score1List.add(0);

                                }else{
                                    score1List.add(0);
                                    score1List.set(inPosition, Integer.parseInt(s.toString()));
                                    break;
                                }
                            }
                    }catch (NumberFormatException e){
                        Log.d("GuessGameAdapterText1", e.getMessage());
                    }
                }
            }
        });

        gScoreTeam2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                isOnTextChange2=true;
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(isOnTextChange2){
                    isOnTextChange2=false;

                    try {
                        for(int i=0;i<=position;i++){
                            int inPosition=position;
                            if(i!=position){
                                score2List.add(0);

                            }else{
                                score2List.add(0);
                                score2List.set(inPosition, Integer.parseInt(s.toString()));
                                break;
                            }
                        }
                        


                    }catch (NumberFormatException e){
                        Log.d("GuessGameAdapterText2", e.getMessage());
                    }

                }
            }
        });

        save.setOnClickListener(v->{
            database= FirebaseDatabase.getInstance("https://ihwc-app-default-rtdb.europe-west1.firebasedatabase.app/").getReference("users");

            database.child(userId).child("games").orderByChild("gameId").equalTo(gameList.get(position).gameId).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {

                    for(DataSnapshot gameSnapshot: snapshot.getChildren()){

                        gameSnapshot.getRef().child("gScoreTeam1").setValue(score1List.get(position));
                        gameSnapshot.getRef().child("gScoreTeam2").setValue(score2List.get(position));
                        Toast.makeText(context, "Score "+model.getTeam1C()+" "+score1List.get(position)+" : "+score2List.get(position)+" "+model.getTeam2C(), Toast.LENGTH_LONG).show();
                    }


                }

                @Override
                public void onCancelled(@NonNull @NotNull DatabaseError error) {

                }
            });


        });}
        else{
            holder.actualScore.setVisibility(View.VISIBLE);
            holder.guessScore1.setVisibility(View.VISIBLE);
            holder.guessScore2.setVisibility(View.VISIBLE);
            holder.actualScore.setText(model.getTeam1C()+" "+model.getScoreTeam1()+":"+model.getScoreTeam2()+" "+model.getTeam2C());
            holder.gScoreTeam1.setVisibility(View.GONE);
            holder.gScoreTeam2.setVisibility(View.GONE);
            holder.guessScore1.setText(String.valueOf(gameList.get(position).gScoreTeam1));
            holder.guessScore2.setText(String.valueOf(gameList.get(position).gScoreTeam2));
            holder.save.setVisibility(View.GONE);
        }

    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.game_item, parent, false);


        return new GuessGameAdapter.ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView flagTeam1;
        ImageView flagTeam2;
        TextView team1;
        TextView team2;
        TextView date;
        TextView guessScore1;
        TextView guessScore2;
        TextView actualScore;
        TextView gameNo_time;
        TextView status;
        EditText gScoreTeam1;
        EditText gScoreTeam2;
        Button save;



        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.gGameDate);
            flagTeam1=itemView.findViewById(R.id.gFlagTeam1);
            flagTeam2=itemView.findViewById(R.id.gFlagTeam2);
            team1=itemView.findViewById(R.id.gTeam1);
            team2=itemView.findViewById(R.id.gTeam2);
            actualScore=itemView.findViewById(R.id.actualScore);
            gameNo_time=itemView.findViewById(R.id.gGameNo_time);
            status=itemView.findViewById(R.id.gStatus);

            guessScore1=itemView.findViewById(R.id.guessScore1);
            guessScore2=itemView.findViewById(R.id.guessScore2);

            gScoreTeam1=itemView.findViewById(R.id.gScoreTeam1);
            gScoreTeam2=itemView.findViewById(R.id.gScoreTeam2);
            save=itemView.findViewById(R.id.saveButton);
        }
    }

}
