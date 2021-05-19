package com.example.ihwc.ui.teams;

import android.util.Log;

import com.example.ihwc.R;

import java.util.ArrayList;

public class TeamResponse {
    private String country;
    private String countryShort;
    private String memberOfIIHF;
    private int menRank;
    private int womanRank;
    private int malePlayers;
    private int femalePlayers;
    private int juniorPlayers;
    private int referees;
    private int inRinks;
    private int outRinks;
    private ArrayList<Team> teams;

    public Team getTeam(){
        return new Team(country);
    }

    public ArrayList<Team> getTeams()
    {/*
        for(int i=0;i<teams.size();i++) {
            if (teams.get(i).getCountryShort().equals("LAT")) {
                teams.get(i).setFlagIcon(R.drawable.lat_flag);
            } else if (teams.get(i).getCountryShort().equals("BLR")) {
                teams.get(i).setFlagIcon(R.drawable.blr_flag);
            } else if (teams.get(i).getCountryShort().equals("CAN")) {
                teams.get(i).setFlagIcon(R.drawable.can_flag);
            } else if (teams.get(i).getCountryShort().equals("CZE")) {
                teams.get(i).setFlagIcon(R.drawable.cze_flag);
            } else if (teams.get(i).getCountryShort().equals("DEN")) {
                teams.get(i).setFlagIcon(R.drawable.den_flag);
            } else if (teams.get(i).getCountryShort().equals("FIN")) {
                teams.get(i).setFlagIcon(R.drawable.fin_flag);
            } else if (teams.get(i).getCountryShort().equals("GBR")) {
                teams.get(i).setFlagIcon(R.drawable.gbr_flag);
            } else if (teams.get(i).getCountryShort().equals("GER")) {
                teams.get(i).setFlagIcon(R.drawable.ger_flag);
            } else if (teams.get(i).getCountryShort().equals("ITA")) {
                teams.get(i).setFlagIcon(R.drawable.ita_flag);
            } else if (teams.get(i).getCountryShort().equals("KAZ")) {
                teams.get(i).setFlagIcon(R.drawable.kaz_flag);
            } else if (teams.get(i).getCountryShort().equals("NOR")) {
                teams.get(i).setFlagIcon(R.drawable.nor_flag);
            } else if (teams.get(i).getCountryShort().equals("RUS")) {
                teams.get(i).setFlagIcon(R.drawable.rus_flag);
            } else if (teams.get(i).getCountryShort().equals("SUI")) {
                teams.get(i).setFlagIcon(R.drawable.sui_flag);
            } else if (teams.get(i).getCountryShort().equals("SVK")) {
                teams.get(i).setFlagIcon(R.drawable.svk_flag);
            } else if (teams.get(i).getCountryShort().equals("SWE")) {
                teams.get(i).setFlagIcon(R.drawable.swe_flag);
            } else if (teams.get(i).getCountryShort().equals("USA")) {
                teams.get(i).setFlagIcon(R.drawable.usa_flag);
            }
        }*/
        teams=new ArrayList<>();
        teams.add(new Team(country,countryShort,memberOfIIHF,menRank,womanRank,malePlayers,femalePlayers,juniorPlayers,referees,inRinks,outRinks));
        return teams;
    }
}
