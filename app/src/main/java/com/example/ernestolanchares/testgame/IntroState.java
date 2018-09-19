package com.example.ernestolanchares.testgame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.content.res.AppCompatResources;
import android.view.MotionEvent;

public class IntroState extends State {

    private static final long A_TIME = 3000;
    private static final long APPEAR_TIME = 1000;

    private Drawable punts;
    private Drawable letter;

    public IntroState(StateManager manager) {
        super(manager);

        reset();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.rgb(0xf2, 0xf2, 0xf2));


    }

    @Override
    public void update() {
        // TODO wait for load
        // and make animation
    }

    @Override
    public void onTouchEvent(MotionEvent event) {}

    @Override
    public void reset() {
        letter = AppCompatResources.getDrawable(manager.getContext(), R.drawable.android);
    }

    @Override
    public void destroy() {
        letter = null;
        punts = null;
    }
}
