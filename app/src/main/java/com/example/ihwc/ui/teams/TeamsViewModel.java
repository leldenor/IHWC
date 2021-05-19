package com.example.ihwc.ui.teams;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class TeamsViewModel extends ViewModel {
    TeamRepository repository;

    public TeamsViewModel() {
        repository=TeamRepository.getInstance();
    }

    LiveData<ArrayList<Team>> getTeams(){
        repository.setTeams();
        return repository.getTeams();
    }
    LiveData<Team> getTeam()
    {
        return repository.getTeam();
    }
    void setTeam(String country){repository.setTeam(country);}
}