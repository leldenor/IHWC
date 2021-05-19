package com.example.ihwc.ui.schedule;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.ihwc.R;
import com.example.ihwc.ui.teams.ServiceGenerator;
import com.example.ihwc.ui.teams.Team;
import com.example.ihwc.ui.teams.TeamApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class GameRepository {
    private static GameRepository instance;
    private final MutableLiveData<ArrayList<Game>> games;

    public GameRepository() {
        games=new MutableLiveData<>();
    }

    public static synchronized GameRepository getInstance(){
        if(instance==null){
            instance=new GameRepository();
        }
        return instance;
    }

    public void setGames() {
        TeamApi teamApi= ServiceGenerator.getTeamApi();
        Call<ArrayList<Game>> call=teamApi.getGames();
        call.enqueue(new Callback<ArrayList<Game>>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<ArrayList<Game>> call, Response<ArrayList<Game>> response) {
                if(response.isSuccessful()){
                    games.setValue(response.body());

                    /*for(int i=0;i<teams.getValue().size();i++) {
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
                    }*/
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<ArrayList<Game>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }

    public MutableLiveData<ArrayList<Game>> getGames() {
        return games;
    }
}
