package com.example.ihwc.ui.schedule;

import com.example.ihwc.ui.teams.Team;

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

    public void setFanCount1(int fanCount1) {
        this.fanCount1 = fanCount1;
    }

    public int getFanCount2() {
        return fanCount2;
    }

    public void setFanCount2(int fanCount2) {
        this.fanCount2 = fanCount2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public Game() {
    }



    public String getGameNo_time() {
        return gameNo_time;
    }

    public String getTeam1F() {
        return team1F;
    }

    public void setTeam1F(String team1F) {
        this.team1F = team1F;
    }

    public String getTeam2F() {
        return team2F;
    }

    public void setTeam2F(String team2F) {
        this.team2F = team2F;
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

    public void setScoreTeam1(String scoreTeam1) {
        this.scoreTeam1 = scoreTeam1;
    }

    public String getScoreTeam2() {
        return scoreTeam2;
    }

    public void setScoreTeam2(String scoreTeam2) {
        this.scoreTeam2 = scoreTeam2;
    }

    public String getTeam1C() {
        return team1C;
    }

    public void setTeam1C(String team1C) {
        this.team1C = team1C;
    }

    public String getTeam2C() {
        return team2C;
    }

    public void setTeam2C(String team2C) {
        this.team2C = team2C;
    }
}