package com.example.ihwc.ui.teamInfo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ihwc.R;
import com.example.ihwc.TeamInfoViewModel;
import com.example.ihwc.ui.standings.StandingsAdapter;
import com.example.ihwc.ui.standings.StandingsFragment;
import com.example.ihwc.ui.standings.StandingsViewModel;
import com.example.ihwc.ui.teams.Team;
import com.example.ihwc.ui.teams.TeamAdapter;

import java.util.ArrayList;

public class InfoFragment extends Fragment {
    private TeamInfoViewModel mViewModel;
    private View view;

    public static InfoFragment newInstance() {
        return new InfoFragment();
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_info, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TeamInfoViewModel.class);
        mViewModel.getTeam().observe(this.getViewLifecycleOwner(), team->{

            ImageView infoImage=view.findViewById(R.id.infoImage);
            infoImage.setImageResource(team.getFlagIcon());
            TextView memberOfIIHF=view.findViewById(R.id.memberOfIIHF);
            memberOfIIHF.setText(team.getMemberOfIIHF());
            TextView menRank=view.findViewById(R.id.menRank);
            menRank.setText(team.getMenRankString());
            TextView womenRank=view.findViewById(R.id.womenRank);
            womenRank.setText(team.getWomanRankString());
            TextView malePlayers=view.findViewById(R.id.malePlayers);
            malePlayers.setText(team.getMalePlayersString());
            TextView femalePlayers=view.findViewById(R.id.femalePlayers);
            femalePlayers.setText(team.getFemalePlayersString());
            TextView juniorPlayers=view.findViewById(R.id.juniorPlayers);
            juniorPlayers.setText(team.getJuniorPlayersString());
            TextView referees=view.findViewById(R.id.referees);
            referees.setText(team.getRefereesString());
            TextView inRinks=view.findViewById(R.id.inRinks);
            inRinks.setText(team.getInRinksString());
            TextView outRinks=view.findViewById(R.id.outRinks);
            outRinks.setText(team.getOutRinksString());
            Log.i("Info","Team "+team.getCountry());
        });

    }
}