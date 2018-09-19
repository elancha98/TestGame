package com.example.ernestolanchares.testgame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.content.res.AppCompatResources;
import android.view.MotionEvent;

import com.example.ernestolanchares.testgame.utils.Constants;
import com.example.ernestolanchares.testgame.utils.Interpolator;
import com.example.ernestolanchares.testgame.utils.RectUtils;

public class IntroState extends State {

    private static final long A_TIME = 3000;
    private static final long DESPLACEMENT_TIME = 1000;
    private static final long APPEAR_TIME = 5000;
    private static final long STILL_TIME = 2000;

    private static final double cutrada = 2.486774;

    private long animationStart;

    private Drawable punts;
    private Drawable letter;

    private Rect rectLetter;
    private Rect rectPunts;

    private int rectLeft, rectCenter;

    public IntroState(StateManager manager) {
        super(manager);

        reset();
    }

    @Override
    public void draw(Canvas canvas) {
        long elapsed = System.currentTimeMillis() - animationStart;
        //elapsed = 1;

        if (elapsed >= A_TIME + DESPLACEMENT_TIME + APPEAR_TIME + STILL_TIME) {
            canvas.drawColor(Color.rgb(11, 11, 11));
            return;
        }

        canvas.drawColor(Color.rgb(0xf2, 0xf2, 0xf2));

        if (elapsed > A_TIME && elapsed < A_TIME + DESPLACEMENT_TIME) {
            int l = (int) Interpolator.linearInterpolate(rectCenter, rectLeft, ((float) elapsed - A_TIME) / DESPLACEMENT_TIME);
            System.out.println(l);
            int w = rectLetter.width();
            rectLetter.left = l;
            rectLetter.right = l + w;
        } else if (elapsed > A_TIME && elapsed < A_TIME + DESPLACEMENT_TIME + APPEAR_TIME) {
            int w = rectPunts.width();
            int h = rectPunts.height();
            rectPunts.left = rectLetter.right;
            rectPunts.right = rectLetter.right + w;
            rectPunts.bottom = (int) (rectLetter.bottom + (cutrada * h) / punts.getIntrinsicHeight());
            rectPunts.top = rectPunts.bottom - h ;

            punts.setBounds(rectPunts);
            int a = (int) Interpolator.linearInterpolate(0, 255, ((float) elapsed - A_TIME - DESPLACEMENT_TIME) / APPEAR_TIME);
            punts.setAlpha(a);
            punts.draw(canvas);
        } else if (elapsed > A_TIME) {
            punts.setBounds(rectPunts);
            punts.draw(canvas);
        }

        letter.setBounds(rectLetter);

        //System.out.println(rectLetter.left + " " + rectLetter.right + " - " + rectLetter.top + " " + rectLetter.bottom);

        letter.draw(canvas);
    }

    @Override
    public void update() {
        if (animationStart < 0)
            animationStart = System.currentTimeMillis();
        // TODO wait for load
        // and make animation
    }

    @Override
    public void onTouchEvent(MotionEvent event) {}

    @Override
    public void reset() {
        animationStart = -1;

        letter = AppCompatResources.getDrawable(manager.getContext(), R.drawable.icon);
        punts = AppCompatResources.getDrawable(manager.getContext(), R.drawable.puntsfme);

        rectLetter = new Rect(0, 0, letter.getIntrinsicWidth(), letter.getIntrinsicHeight());
        rectPunts = new Rect(0, 0, punts.getIntrinsicWidth(), punts.getIntrinsicHeight());

        // letter = x | punts = y
        // x + y = 3*WH/4
        // x = 0.y

        // TODO arreglar esta cutrada
        RectUtils.scaleToWidth(rectLetter, Constants.SCREEN_WIDTH/8);
        RectUtils.scaleToWidth(rectPunts, 5*Constants.SCREEN_WIDTH/8);

        RectUtils.centerRect(rectLetter);
        rectCenter = rectLetter.left;
        rectLeft = Constants.SCREEN_WIDTH/8;
    }

    @Override
    public void destroy() {
        letter = null;
        punts = null;
    }
}
