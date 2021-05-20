package com.example.ihwc.main.teams;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ihwc.R;
import com.example.ihwc.teamInfo.TeamInfoActivity;

import java.util.ArrayList;

public class TeamsFragment extends Fragment implements TeamAdapter.OnListItemClickListener {

    private TeamsViewModel mViewModel;
    private RecyclerView recyclerView;
    private View view;
    private ArrayList<Team> teams;



    public TeamsFragment() {

        teams=new ArrayList<>();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.teams_fragment, container, false);
        recyclerView=view.findViewById(R.id.rvTeams);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TeamsViewModel.class);
        mViewModel.getTeams().observe(this.getViewLifecycleOwner(), t->{
            TeamAdapter adapter=new TeamAdapter(t, this.getContext(),this);
            recyclerView.setAdapter(adapter);
            teams=t;
        });

    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        Intent intent=new Intent(TeamsFragment.this.getActivity(),TeamInfoActivity.class);
        intent.putExtra("Team Item", teams.get(clickedItemIndex).getCountryShort());
        startActivity(intent);
    }
}