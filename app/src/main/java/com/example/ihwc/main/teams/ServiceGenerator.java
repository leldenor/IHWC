package com.example.ihwc.main.teams;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static TeamApi teamApi;

    public static TeamApi getTeamApi() {
        if(teamApi==null){
            teamApi=new Retrofit.Builder()
                    .baseUrl("https://run.mocky.io")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(TeamApi.class);
        }

        return teamApi;
    }

}
