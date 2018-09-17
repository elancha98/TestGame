package com.example.ernestolanchares.testgame;

import android.graphics.Canvas;
import android.view.MotionEvent;

public abstract class State {

    protected StateManager manager;

    public State(StateManager manager) {
        this.manager = manager;
    }

    public abstract void draw(Canvas canvas);
    public abstract void update();
    public abstract void onTouchEvent(MotionEvent event);

    public abstract void reset();
    public abstract void destroy();
}
