package com.project.desafio_sportheca.models;

import com.google.gson.annotations.SerializedName;

public class Object {

    @SerializedName("Player")
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "Object{" +
                "player=" + player +
                '}';
    }
}
