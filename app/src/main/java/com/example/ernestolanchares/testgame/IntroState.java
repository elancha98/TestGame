package com.example.ernestolanchares.testgame;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.example.ernestolanchares.testgame.utils.Constants;
import com.example.ernestolanchares.testgame.utils.Utils;

public class IntroState extends State {

    Bitmap img;
    private Rect rect;

    public IntroState(StateManager manager) {
        super(manager);

        reset();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.rgb(0xf2, 0xf2, 0xf2));

        canvas.drawBitmap(img, null, rect, new Paint());
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
        img = BitmapFactory.decodeResource(manager.getContext().getResources(), R.drawable.icono);

        rect = new Rect(0, 0, Constants.SCREEN_WIDTH/2, Constants.SCREEN_HEIGHT/2);
        Utils.scalateRect(rect, img);
        Utils.centerRect(rect);
    }

    @Override
    public void destroy() {
        img = null;
    }
}
