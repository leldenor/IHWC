package com.example.ihwc.ui.teamInfo;

public class Player {
    public String name;
    public String position;
    public String country;
    public int number;
    public int gs;
    public int a;
    public int pts;

    public Player() {
    }

    public Player(String name, String position, String country, int number) {
        this.name = name;
        this.position = position;
        this.country = country;
        this.number = number;
    }

    public Player(String name, String position, String country, int number, int gs, int a, int pts) {
        this.name = name;
        this.position = position;
        this.country = country;
        this.number = number;
        this.gs = gs;
        this.a = a;
        this.pts = pts;
    }

    public void setGs(int gs) {
        this.gs = gs;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
