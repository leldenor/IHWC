package com.example.ihwc.ui.statistics;

import androidx.lifecycle.ViewModelProvider;

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
import com.example.ihwc.ui.standings.Standings;
import com.example.ihwc.ui.teamInfo.Player;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;

public class StatisticsFragment extends Fragment {

    private RecyclerView recyclerView;
    private View view;
    private DatabaseReference reference;
    StatisticsAdapter adapter;

    private StatisticsViewModel mViewModel;

    public StatisticsFragment() {
    }

    public static StatisticsFragment newInstance() {
        return new StatisticsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.statistics_fragment, container, false);
        recyclerView=view.findViewById(R.id.statisticsRV);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        reference= FirebaseDatabase.getInstance("https://ihwc-app-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
        Query query=reference.child("Players").orderByChild("pts").limitToLast(10);

        FirebaseRecyclerOptions<Player> options = new FirebaseRecyclerOptions.Builder<Player>()
                .setQuery(query, Player.class).setLifecycleOwner(this)
                .build();
        List<Integer> rank=new ArrayList<>();
        for(int i=1;i<=10;i++){
            rank.add(i);
        }
        adapter = new StatisticsAdapter(options, rank, getContext());
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(StatisticsViewModel.class);
        // TODO: Use the ViewModel
    }

}