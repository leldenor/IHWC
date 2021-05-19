package com.example.ihwc.ui.teams;

import com.example.ihwc.ui.schedule.Game;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TeamApi {

    @GET("v3/0c1b6144-89ac-4163-ac45-624d3bbed3cc")
    Call<ArrayList<Team>> getTeams();

    @GET("v3/a33199ae-9538-4065-a10e-0e6dfd8ac4d3")
    Call<TeamResponse> getTeam();

    @GET("v3/3de88c45-5056-43cf-b631-ef375ef05830")
    Call<ArrayList<Game>> getGames();;
}
