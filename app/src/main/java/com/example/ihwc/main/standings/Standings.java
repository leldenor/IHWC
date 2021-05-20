package com.example.ihwc.main.standings;

public class Standings {
    private int ranking;
    private String team;
    private int games;
    private int points;
    private String flag;

    public Standings() {
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String  flag) {
        this.flag = flag;
    }

    public String getRanking() {
        return ranking+"";
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getGames() {
        return games+"";
    }

    public void setGames(int games) {
        this.games = games;
    }

    public String getPoints() {
        return points+"";
    }

    public void setPoints(int points) {
        this.points = points;
    }

}
