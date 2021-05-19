package com.example.ihwc.ui.schedule;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class ScheduleViewModel extends ViewModel {
    GameRepository repository;

    public ScheduleViewModel() {
        repository=GameRepository.getInstance();
    }

    LiveData<ArrayList<Game>> getGames()
    {
        repository.setGames();
        return repository.getGames();
    }
}