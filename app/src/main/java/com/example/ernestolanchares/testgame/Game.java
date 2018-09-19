package com.example.ernestolanchares.testgame;

public class Game {
    private Player[] players = new Player[4];
    int points0, points1;

    // TODO constructor


    public Player getPlayerById(int id) {
        if (id < 0 || id >= 4) {
            throw new IllegalArgumentException("Given player id " + id + " not in range 0..3");
        }
        return players[id];
    }
}
