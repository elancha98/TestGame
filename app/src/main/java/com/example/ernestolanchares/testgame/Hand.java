package com.example.ernestolanchares.testgame;

import android.graphics.Canvas;
import android.view.MotionEvent;

import static com.example.ernestolanchares.testgame.Card.Suit.*;

public class Hand {
    private Card.Suit trump;
    private int points, multiplier;
    private Game game;

    public Hand(Game game, Card.Suit trump, int multiplier) {
        points = 0;
        this.game = game;
        this.trump = trump;
        this.multiplier = multiplier;
    }

    public Card.Suit getTrump() {
        return trump;
    }

    public Game getGame() {
        return game;
    }
}
