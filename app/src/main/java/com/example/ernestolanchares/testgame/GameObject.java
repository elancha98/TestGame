package com.example.ernestolanchares.testgame;

import android.graphics.Canvas;
import android.view.MotionEvent;

public interface GameObject {
    public void update();
    public void draw(Canvas canvas);
    public void onTouchEvent(MotionEvent event);
}
