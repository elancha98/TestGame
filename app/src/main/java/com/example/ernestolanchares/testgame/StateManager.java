package com.example.ernestolanchares.testgame;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;

public class StateManager {
    public enum GameState {
        INTRO, MENU, GAMEPLAY;

        public State generateState(StateManager manager) {
            switch (this) {
                case INTRO:
                    return new IntroState(manager);
            }
            throw new UnsupportedOperationException(this.name() + " game class not implemented yet.");
        }
    }

    private State[] states;
    private int activeState = -1;

    private Context context;

    public StateManager(Context context) {
        this.context = context;

        states = new State[GameState.values().length];
        changeState(GameState.INTRO);
    }

    public void update() {
        states[activeState].update();
    }

    public void draw(Canvas canvas) {
        states[activeState].draw(canvas);
    }

    public void onTouchEvent(MotionEvent event) {
        states[activeState].onTouchEvent(event);
    }

    public void changeState(GameState state) {
        if (activeState == state.ordinal()) {
            states[activeState].reset();
            return;
        }

        if (activeState > 0)
            states[activeState].destroy();

        activeState = state.ordinal();
        if (states[activeState] == null)
            states[activeState] = state.generateState(this);
    }

    public Context getContext() {
        return context;
    }
}
