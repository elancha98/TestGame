package com.example.ernestolanchares.testgame;

import android.graphics.Canvas;
import android.view.MotionEvent;

public class Mano implements GameObject {

    private Card[] cards;
    private int numberOfCards;

    public Mano(Card[] cards) {
        if (cards.length != 12)
            throw new IllegalArgumentException("The number of cards of a Mano must be 12");
        reset(cards);
    }

    // TODO revisar si es necesario
    public void reset(Card[] cards) {
        if (cards.length != 12)
            throw new IllegalArgumentException("The number of cards of a Mano, must be 12");
        this.cards = cards;
        numberOfCards = 12;


    }

    @Override
    public void update() {}

    @Override
    public void draw(Canvas canvas) {

    }

    @Override
    public void onTouchEvent(MotionEvent event) {
        // TODO move card
    }

    private void moveCardsDown() {
        // TODO set all ys
    }

    public void elevateCard(int index) {
        // TODO
    }

    public Card getCard(int i) {
        return cards[i];
    }
}
