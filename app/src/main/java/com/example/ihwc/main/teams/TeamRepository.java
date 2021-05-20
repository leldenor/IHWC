package com.example.ihwc.main.teams;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ihwc.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class TeamRepository {
    private static TeamRepository instance;
    private final MutableLiveData<Team> team;
    private final MutableLiveData<ArrayList<Team>> teams;


    public TeamRepository() {
        team=new MutableLiveData<>();
        teams=new MutableLiveData<>();
    }

    public static synchronized TeamRepository getInstance(){
        if(instance==null){
            instance=new TeamRepository();
        }
        return instance;
    }

    public LiveData<Team> getTeam()
    {
        return team;
    }

    public void setTeam(String country){

        for(int i=0;i<teams.getValue().size();i++){
            if(teams.getValue().get(i).getCountryShort().equals(country)){
                team.setValue(teams.getValue().get(i));
            }
        }
    }

    public LiveData<ArrayList<Team>> getTeams(){
        return teams;
    }

    public void setTeams(){
        TeamApi teamApi=ServiceGenerator.getTeamApi();
        Call<ArrayList<Team>> call=teamApi.getTeams();
        call.enqueue(new Callback<ArrayList<Team>>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<ArrayList<Team>> call, Response<ArrayList<Team>> response) {
                if(response.isSuccessful()){
                    teams.setValue(response.body());

                    for(int i=0;i<teams.getValue().size();i++) {
                        if (teams.getValue().get(i).getCountryShort().equals("LAT")) {
                            teams.getValue().get(i).setFlagIcon(R.drawable.lat_flag);

                        } else if (teams.getValue().get(i).getCountryShort().equals("BLR")) {
                            teams.getValue().get(i).setFlagIcon(R.drawable.blr_flag);

                        } else if (teams.getValue().get(i).getCountryShort().equals("CAN")) {
                            teams.getValue().get(i).setFlagIcon(R.drawable.can_flag);

                        } else if (teams.getValue().get(i).getCountryShort().equals("CZE")) {
                            teams.getValue().get(i).setFlagIcon(R.drawable.cze_flag);

                        } else if (teams.getValue().get(i).getCountryShort().equals("DEN")) {
                            teams.getValue().get(i).setFlagIcon(R.drawable.den_flag);

                        } else if (teams.getValue().get(i).getCountryShort().equals("FIN")) {
                            teams.getValue().get(i).setFlagIcon(R.drawable.fin_flag);

                        } else if (teams.getValue().get(i).getCountryShort().equals("GBR")) {
                            teams.getValue().get(i).setFlagIcon(R.drawable.gbr_flag);

                        } else if (teams.getValue().get(i).getCountryShort().equals("GER")) {
                            teams.getValue().get(i).setFlagIcon(R.drawable.ger_flag);

                        } else if (teams.getValue().get(i).getCountryShort().equals("ITA")) {
                            teams.getValue().get(i).setFlagIcon(R.drawable.ita_flag);

                        } else if (teams.getValue().get(i).getCountryShort().equals("KAZ")) {
                            teams.getValue().get(i).setFlagIcon(R.drawable.kaz_flag);

                        } else if (teams.getValue().get(i).getCountryShort().equals("NOR")) {
                            teams.getValue().get(i).setFlagIcon(R.drawable.nor_flag);

                        } else if (teams.getValue().get(i).getCountryShort().equals("RUS")) {
                            teams.getValue().get(i).setFlagIcon(R.drawable.rus_flag);

                        } else if (teams.getValue().get(i).getCountryShort().equals("SUI")) {
                            teams.getValue().get(i).setFlagIcon(R.drawable.sui_flag);

                        } else if (teams.getValue().get(i).getCountryShort().equals("SVK")) {
                            teams.getValue().get(i).setFlagIcon(R.drawable.svk_flag);
                        } else if (teams.getValue().get(i).getCountryShort().equals("SWE")) {
                            teams.getValue().get(i).setFlagIcon(R.drawable.swe_flag);

                        } else if (teams.getValue().get(i).getCountryShort().equals("USA")) {
                            teams.getValue().get(i).setFlagIcon(R.drawable.usa_flag);

                        }
                    }
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<ArrayList<Team>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }

}
