package com.example.susmitharajan.musicplayeroriginal;

/**
 * Created by susmitharajan on 31/03/18.
 */

public class Tracks_DataModel {
    int image;
    String name, team;

    public Tracks_DataModel(int image, String name, String team) {
        this.image = image;
        this.name = name;
        this.team = team;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }
}
