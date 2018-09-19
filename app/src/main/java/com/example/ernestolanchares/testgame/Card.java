package com.example.ernestolanchares.testgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;

public class Card implements GameObject {

    public enum Suit {
        GOLD, CUPS, SWORDS, STICKS, BUTI
    }

    private Suit suit;
    private int value;

    private Rect rect;
    private Bitmap image;

    public Card(Suit suit, int value, Bitmap image) {
        if (suit == Suit.BUTI)
            throw new IllegalArgumentException("BUTI cannot be a card suit");

        this.suit = suit;
        this.value = value;

        this.image = image;
        // TODO load bitmap and initialize rect;
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, null, rect, new Paint());
    }

    @Override
    public void onTouchEvent(MotionEvent event) {

    }

    public void update(Point point) {
        //l, t, r, b
        rect.set(point.x - rect.width()/2, point.y - rect.height()/2, point.x + rect.width()/2, point.y + rect.height()/2);
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public int getCardPoints() {
        if (value > 9) return value - 9;
        if (value == 1) return 4;
        if (value == 9) return 5;
        return 0;
    }
}
