package com.example.ihwc.main.teams;


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

}