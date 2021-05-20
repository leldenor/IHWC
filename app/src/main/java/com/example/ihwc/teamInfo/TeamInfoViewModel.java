package com.example.ihwc.teamInfo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.ihwc.main.teams.Team;
import com.example.ihwc.main.teams.TeamRepository;

public class TeamInfoViewModel extends ViewModel {
    TeamRepository repository;

    public TeamInfoViewModel() {
        repository=TeamRepository.getInstance();
    }


    public LiveData<Team> getTeam()
    {
        return repository.getTeam();
    }


    public void setTeam(String country){
        repository.setTeam(country);}
}
