package com.example.ernestolanchares.testgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class Card implements GameObject {

    public enum Family {
        OROS, COPAS, ESPADAS, BASTOS, BUTIFARRA
    }

    private Family family;
    private int number;

    private Rect rect;
    private Bitmap image;

    public Card(Family family, int number, Bitmap image) {
        if (family == Family.BUTIFARRA)
            throw new IllegalArgumentException("BUTIFARRA cannot be a card family");

        this.family = family;
        this.number = number;

        this.image = image;
        //TODO load bitmap and initialize rect;
    }


    @Override
    public void update() {

    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, null, rect, new Paint());
    }

    public void update(Point point) {
        //l, t, r, b
        rect.set(point.x - rect.width()/2, point.y - rect.height()/2, point.x + rect.width()/2, point.y + rect.height()/2);
    }

    public Family getPalo() {
        return family;
    }

    public void setPalo(Family family) {
        this.family = family;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
