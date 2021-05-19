package com.example.ihwc.game;

public class GuessGame {
    public String gameId;
    public int gScoreTeam1;
    public int gScoreTeam2;

    public GuessGame() {
    }

    public GuessGame(String gameId) {
        this.gameId = gameId;
    }

    public GuessGame(String gameId, int gScoreTeam1, int gScoreTeam2) {
        this.gameId = gameId;
        this.gScoreTeam1 = gScoreTeam1;
        this.gScoreTeam2 = gScoreTeam2;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public int getgScoreTeam1() {
        return gScoreTeam1;
    }

    public void setgScoreTeam1(int gScoreTeam1) {
        this.gScoreTeam1 = gScoreTeam1;
    }

    public int getgScoreTeam2() {
        return gScoreTeam2;
    }

    public void setgScoreTeam2(int gScoreTeam2) {
        this.gScoreTeam2 = gScoreTeam2;
    }
}