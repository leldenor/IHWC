package com.example.ihwc.login;

import com.example.ihwc.game.GuessGame;

import java.util.List;

public class User {

    public String email;
    public String username;
    public List<GuessGame> games;

    public User() {
    }

    public User(String email, String username) {
        this.email = email;
        this.username=username;
    }

    public User(String email, String username, List<GuessGame> games) {
        this.email = email;
        this.username = username;
        this.games = games;
    }

    public User(List<GuessGame> games) {
        this.games = games;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

