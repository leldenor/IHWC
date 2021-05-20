package com.example.ihwc.main.schedule;

public class Game {
    private String gameNo_time;
    private String status;
    private String scoreTeam1;
    private String scoreTeam2;
    private String team1C;
    private String team2C;
    private String team1F;
    private String team2F;
    private String round;
    private String date;
    private int fanCount1;
    private int fanCount2;

    public int getFanCount1() {
        return fanCount1;
    }


    public int getFanCount2() {
        return fanCount2;
    }


    public String getDate() {
        return date;
    }


    public String getRound() {
        return round;
    }


    public Game() {
    }



    public String getGameNo_time() {
        return gameNo_time;
    }

    public String getTeam1F() {
        return team1F;
    }
    

    public String getTeam2F() {
        return team2F;
    }


    public void setGameNo_time(String gameNo_time) {
        this.gameNo_time = gameNo_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getScoreTeam1() {
        return scoreTeam1;
    }


    public String getScoreTeam2() {
        return scoreTeam2;
    }


    public String getTeam1C() {
        return team1C;
    }


    public String getTeam2C() {
        return team2C;
    }


}