package com.example.ihwc.ui.schedule;

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

public class GameFragment extends Fragment {
    private RecyclerView recyclerView;
    private View view;
    private DatabaseReference reference;
    GameAdapter adapter;
    private int position;

    public GameFragment() {
    }

    public static GameFragment getInstance(int position) {
        Bundle args=new Bundle();
        args.putInt("Page", position);
        GameFragment fragment=new GameFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
        position=getArguments().getInt("Page");}
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.round_fragment, container, false);
        recyclerView=view.findViewById(R.id.rvSchedule);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        reference= FirebaseDatabase.getInstance("https://ihwc-app-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
        Query query=reference.child("Games").orderByChild("round").equalTo("Round");
        if(position==0){
            query=reference.child("Games").orderByChild("round").equalTo("Round");

        }else if(position==1){
            query=reference.child("Games").orderByChild("round").equalTo("Quarterfinals");

        }else if(position==2){
            query=reference.child("Games").orderByChild("round").equalTo("Semifinals");

        }else if(position==3){
            query=reference.child("Games").orderByChild("round").equalTo("Finals");

        }
        FirebaseRecyclerOptions<Game> options=new FirebaseRecyclerOptions.Builder<Game>()
                .setQuery(query, Game.class).setLifecycleOwner(this)
                .build();

        adapter=new GameAdapter(options,this.getContext());
        recyclerView.setAdapter(adapter);

        return view;
    }
}
