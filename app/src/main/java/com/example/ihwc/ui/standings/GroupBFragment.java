package com.example.ihwc.ui.standings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ihwc.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class GroupBFragment extends Fragment {

    private RecyclerView recyclerView;
    private View view;
    private DatabaseReference reference;
    StandingsAdapter adapter;

    public static GroupBFragment getInstance(){
        return new GroupBFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_group, container, false);
        recyclerView=view.findViewById(R.id.rvStandings);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        reference= FirebaseDatabase.getInstance("https://ihwc-app-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
        Query query=reference.child("GroupB").orderByChild("ranking");

        FirebaseRecyclerOptions<Standings> options = new FirebaseRecyclerOptions.Builder<Standings>()
                .setQuery(query, Standings.class).setLifecycleOwner(this)
                .build();

        adapter = new StandingsAdapter(options, getContext());
        recyclerView.setAdapter(adapter);

        return view;
    }
}
