package com.example.ihwc.main.teams;

public class Team {
    private int flagIcon;
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

    public Team() {
    }

    public Team(String country) {
        this.country = country;
    }

    public Team(int flagIcon, String country, String countryShort, String memberOfIIHF, int menRank, int womanRank, int malePlayers, int femalePlayers, int juniorPlayers, int referees, int inRinks, int outRinks) {
        this.flagIcon = flagIcon;
        this.country = country;
        this.countryShort = countryShort;
        this.memberOfIIHF = memberOfIIHF;
        this.menRank = menRank;
        this.womanRank = womanRank;
        this.malePlayers = malePlayers;
        this.femalePlayers = femalePlayers;
        this.juniorPlayers = juniorPlayers;
        this.referees = referees;
        this.inRinks = inRinks;
        this.outRinks = outRinks;
    }

    public Team(String country, String countryShort, String memberOfIIHF, int menRank, int womanRank, int malePlayers, int femalePlayers, int juniorPlayers, int referees, int inRinks, int outRinks) {
        this.country = country;
        this.countryShort = countryShort;
        this.memberOfIIHF = memberOfIIHF;
        this.menRank = menRank;
        this.womanRank = womanRank;
        this.malePlayers = malePlayers;
        this.femalePlayers = femalePlayers;
        this.juniorPlayers = juniorPlayers;
        this.referees = referees;
        this.inRinks = inRinks;
        this.outRinks = outRinks;
    }

    public int getFlagIcon() {
        return flagIcon;
    }

    public void setFlagIcon(int flagIcon) {
        this.flagIcon = flagIcon;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryShort() {
        return countryShort;
    }

    public void setCountryShort(String countryShort) {
        this.countryShort = countryShort;
    }

    public String getMemberOfIIHF() {
        return memberOfIIHF;
    }

    public void setMemberOfIIHF(String memberOfIIHF) {
        this.memberOfIIHF = memberOfIIHF;
    }

    public int getMenRank() {
        return menRank;
    }
    public String getMenRankString() {
        return menRank+"";
    }

    public void setMenRank(int menRank) {
        this.menRank = menRank;
    }

    public int getWomanRank() {
        return womanRank;
    }
    public String getWomanRankString() {
        return womanRank+"";
    }

    public void setWomanRank(int womanRank) {
        this.womanRank = womanRank;
    }

    public int getMalePlayers() {
        return malePlayers;
    }
    public String getMalePlayersString() {
        return malePlayers+"";
    }

    public void setMalePlayers(int malePlayers) {
        this.malePlayers = malePlayers;
    }

    public int getFemalePlayers() {
        return femalePlayers;
    }
    public String getFemalePlayersString() {
        return femalePlayers+"";
    }

    public void setFemalePlayers(int femalePlayers) {
        this.femalePlayers = femalePlayers;
    }

    public int getJuniorPlayers() {
        return juniorPlayers;
    }
    public String getJuniorPlayersString() {
        return juniorPlayers+"";
    }

    public void setJuniorPlayers(int juniorPlayers) {
        this.juniorPlayers = juniorPlayers;
    }

    public int getReferees() {
        return referees;
    }
    public String getRefereesString() {
        return referees+"";
    }

    public void setReferees(int referees) {
        this.referees = referees;
    }

    public int getInRinks() {
        return inRinks;
    }
    public String getInRinksString() {
        return inRinks+"";
    }

    public void setInRinks(int inRinks) {
        this.inRinks = inRinks;
    }

    public int getOutRinks() {
        return outRinks;
    }
    public String getOutRinksString() {
        return outRinks+"";
    }

    public void setOutRinks(int outRinks) {
        this.outRinks = outRinks;
    }


}
