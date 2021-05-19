package com.example.ihwc.ui.teamInfo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ihwc.R;
import com.example.ihwc.TeamInfoViewModel;
import com.example.ihwc.ui.schedule.Game;
import com.example.ihwc.ui.schedule.GameAdapter;
import com.example.ihwc.ui.teams.Team;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;

public class GamesFragment extends Fragment {

    private RecyclerView recyclerView;
    private View view;
    private ArrayList<Game> games=new ArrayList<>();
    private DatabaseReference reference;
    private TeamInfoViewModel mViewModel;
    GamesAdapter adapter;

    public GamesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_games, container, false);
        recyclerView=view.findViewById(R.id.rvTeamGames);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TeamInfoViewModel.class);
        Bundle bundle=getActivity().getIntent().getExtras();
        reference=FirebaseDatabase.getInstance("https://ihwc-app-default-rtdb.europe-west1.firebasedatabase.app/").getReference().child("Games");
        Log.i("Country", bundle.getString("Team Item"));

        adapter=new GamesAdapter(games,getContext());
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Game game=snapshot.getValue(Game.class);
                adapter.notifyDataSetChanged();
                if(game.getTeam1C().equals(bundle.getString("Team Item"))||game.getTeam2C().equals(bundle.getString("Team Item"))){
                    games.add(game);
                }

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }

}