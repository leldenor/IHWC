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
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class RosterFragment extends Fragment {
    private RecyclerView recyclerViewCoach;
    private RecyclerView recyclerViewForwards;
    private RecyclerView recyclerViewDefense;
    private RecyclerView recyclerViewGoalie;
    private View view;
    private DatabaseReference reference;
    List<Player> coaches;
    List<Player> forwards;
    List<Player> defense;
    List<Player> goalie;
    RosterAdapter adapterCoaches;
    RosterAdapter adapterForwards;
    RosterAdapter adapterDefense;
    RosterAdapter adapterGoalie;



    public RosterFragment() {
        // Required empty public constructor
    }


    public static RosterFragment newInstance() {
        return new RosterFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_roster, container, false);
        recyclerViewCoach=view.findViewById(R.id.coachesRV);
        recyclerViewForwards=view.findViewById(R.id.forwardsRV);
        recyclerViewDefense=view.findViewById(R.id.defenseRV);
        recyclerViewGoalie=view.findViewById(R.id.goalieRV);
        recyclerViewCoach.setHasFixedSize(true);
        recyclerViewCoach.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerViewForwards.setHasFixedSize(true);
        recyclerViewForwards.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerViewDefense.setHasFixedSize(true);
        recyclerViewDefense.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerViewGoalie.setHasFixedSize(true);
        recyclerViewGoalie.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        coaches=new ArrayList<>();
        forwards=new ArrayList<>();
        defense=new ArrayList<>();
        goalie=new ArrayList<>();
        adapterCoaches=new RosterAdapter(getContext(), coaches);
        adapterForwards=new RosterAdapter(getContext(), forwards);
        adapterDefense=new RosterAdapter(getContext(), defense);
        adapterGoalie=new RosterAdapter(getContext(), goalie);
        reference= FirebaseDatabase.getInstance("https://ihwc-app-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Players");
        Bundle bundle=getActivity().getIntent().getExtras();

        reference.orderByChild("country").equalTo(bundle.getString("Team Item")).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {
                Player player=snapshot.getValue(Player.class);
                Log.i("Name", player.name);

                if(player.position.equals("Coach")){
                    adapterCoaches.notifyDataSetChanged();
                    coaches.add(player);
                }else if(player.position.equals("Forward")){
                    adapterForwards.notifyDataSetChanged();
                    forwards.add(player);
                }else if(player.position.equals("Defense")){
                    adapterDefense.notifyDataSetChanged();
                    defense.add(player);
                }else if(player.position.equals("Goalie")){
                    adapterGoalie.notifyDataSetChanged();
                    goalie.add(player);
                }
            }

            @Override
            public void onChildChanged(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {

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

        recyclerViewCoach.setAdapter(adapterCoaches);
        recyclerViewForwards.setAdapter(adapterForwards);
        recyclerViewDefense.setAdapter(adapterDefense);
        recyclerViewGoalie.setAdapter(adapterGoalie);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);





    }
}