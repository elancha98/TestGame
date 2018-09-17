package com.example.ernestolanchares.testgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.ernestolanchares.testgame.utils.Utils;

public class Animation {

    private Bitmap[] frames;
    private int frameIndex;

    private boolean playing;
    private float frameTime;
    private long lastTime;

    public Animation (Bitmap[] frames, long timeMilis) {
        this.frames = frames;
        frameIndex = 0;

        frameTime = ((float) timeMilis) / frames.length;
    }

    public void update() {
        if (!playing)
            return;

        if (System.currentTimeMillis() - lastTime > frameTime) {
            frameIndex ++;
            frameIndex = frameIndex == frames.length ? 0 : frameIndex;
        }
    }

    public void play() {
        playing = true;
    }

    public void pause() {
        playing = false;
    }

    public void stop() {
        frameIndex = 0;
        playing = false;
    }

    public void draw(Canvas canvas, Rect rect) {
        Utils.scalateRect(rect, frames[frameIndex]);
        canvas.drawBitmap(frames[frameIndex], null, rect, new Paint());
    }

    public boolean isPlaying() {
        return playing;
    }
}
