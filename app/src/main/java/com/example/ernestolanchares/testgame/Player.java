package com.example.ernestolanchares.testgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;

public class Player {
    private int id;
    private Card[] hand;

    public Player(int id) {
        this.id = id;
        hand = new Card[12];
    }

    public Card[] getHand() {
        return hand;
    }

    public void setHand(Card[] hand) {
        this.hand = hand;
    }

    public int getId() {
        return id;
    }
}
