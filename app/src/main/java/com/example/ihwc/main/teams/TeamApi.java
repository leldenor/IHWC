package com.example.ihwc.main.teams;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TeamApi {

    @GET("v3/0c1b6144-89ac-4163-ac45-624d3bbed3cc")
    Call<ArrayList<Team>> getTeams();


}
