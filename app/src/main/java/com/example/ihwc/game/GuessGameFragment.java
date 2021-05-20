package com.example.ihwc.game;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ihwc.R;
import com.example.ihwc.main.schedule.Game;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GuessGameFragment extends Fragment {

    private RecyclerView recyclerView;
    private View view;
    private DatabaseReference reference;

    GuessGameAdapter adapter;
    List<GuessGame> gameList;
    private int position;

    public GuessGameFragment() {
        // Required empty public constructor
    }

    public static GuessGameFragment newInstance(int position) {
        GuessGameFragment fragment = new GuessGameFragment();
        Bundle args = new Bundle();
        args.putInt("Page", position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position=getArguments().getInt("Page");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_guess_game, container, false);
        recyclerView=view.findViewById(R.id.rvGuessGames);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        Bundle bundle= requireActivity().getIntent().getExtras();
        String userID=bundle.getString("userId");
        gameList=new ArrayList<>();
        reference= FirebaseDatabase.getInstance("https://ihwc-app-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
        Query query=reference.child("Games").orderByChild("round").equalTo("Round");
        if(position==0){
            query=reference.child("Games").orderByChild("round").equalTo("Round");
            query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                    if(snapshot.getValue()!=null){
                        for(DataSnapshot gameSnapshot:snapshot.getChildren()){
                            Game game=gameSnapshot.getValue(Game.class);;
                            gameList.add(new GuessGame(game.getGameNo_time()));

                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull @NotNull DatabaseError error) {
                    Log.i("GuessGame", error.getMessage());
                }
            });

        }else if(position==1){
            query=reference.child("Games").orderByChild("round").equalTo("Quarterfinals");
            query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                    if(snapshot.getValue()!=null){
                        for(DataSnapshot gameSnapshot:snapshot.getChildren()){
                            Game game=gameSnapshot.getValue(Game.class);
                            gameList.add(new GuessGame(game.getGameNo_time()));
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull @NotNull DatabaseError error) {
                    Log.i("GuessGame", error.getMessage());
                }
            });

        }else if(position==2){
            query=reference.child("Games").orderByChild("round").equalTo("Semifinals");
            query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                    if(snapshot.getValue()!=null){
                        for(DataSnapshot gameSnapshot:snapshot.getChildren()){
                            Game game=gameSnapshot.getValue(Game.class);
                            gameList.add(new GuessGame(game.getGameNo_time()));
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull @NotNull DatabaseError error) {
                    Log.i("GuessGame", error.getMessage());
                }
            });

        }else if(position==3){
            query=reference.child("Games").orderByChild("round").equalTo("Finals");
            query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                    if(snapshot.getValue()!=null){
                        for(DataSnapshot gameSnapshot:snapshot.getChildren()){
                            Game game=gameSnapshot.getValue(Game.class);

                            gameList.add(new GuessGame(game.getGameNo_time()));
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull @NotNull DatabaseError error) {
                    Log.i("GuessGame", error.getMessage());
                }
            });

        }
        FirebaseRecyclerOptions<Game> options=new FirebaseRecyclerOptions.Builder<Game>()
                .setQuery(query, Game.class).setLifecycleOwner(this)
                .build();

        adapter=new GuessGameAdapter(options, this.getActivity(), gameList, userID);

        DatabaseReference databaseReference=FirebaseDatabase.getInstance("https://ihwc-app-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
        databaseReference.child("users").child(userID).child("games").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {
                    GuessGame guessGame=snapshot.getValue(GuessGame.class);
                    for(int i=0;i<gameList.size();i++){
                        if(gameList.get(i).gameId.equals(guessGame.gameId)){
                            gameList.get(i).setgScoreTeam1(guessGame.gScoreTeam1);
                            gameList.get(i).setgScoreTeam2(guessGame.gScoreTeam2);
                            adapter.notifyDataSetChanged();
                        }
                }
            }

            @Override
            public void onChildChanged(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {
                    GuessGame guessGame=snapshot.getValue(GuessGame.class);
                    for(int i=0;i<gameList.size();i++){
                        if(gameList.get(i).gameId.equals(guessGame.gameId)){
                            gameList.set(i, guessGame);
                            adapter.notifyDataSetChanged();
                        }
                    }
            }

            @Override
            public void onChildRemoved(@NonNull @NotNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return view;
    }
}