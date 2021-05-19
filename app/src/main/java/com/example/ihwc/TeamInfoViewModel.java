package com.example.ihwc;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.ihwc.ui.teams.Team;
import com.example.ihwc.ui.teams.TeamRepository;

import java.util.ArrayList;

public class TeamInfoViewModel extends ViewModel {
    TeamRepository repository;

    public TeamInfoViewModel() {
        repository=TeamRepository.getInstance();
    }

    /*LiveData<ArrayList<Team>> getTeams(){
        repository.setTeams();
        return repository.getTeams();
    }*/
    public LiveData<Team> getTeam()
    {
        return repository.getTeam();
    }


    public void setTeam(String country){
        repository.setTeam(country);}
}
