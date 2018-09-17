package com.example.ernestolanchares.testgame;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread {

    public static final int MAX_FPS = 30;
    public static final long TARGET_TIME = 1000/MAX_FPS;

    private SurfaceHolder holder;
    private GamePanel panel;
    private Canvas canvas;

    private double averageFPS;
    private boolean running;

    public MainThread(SurfaceHolder holder, GamePanel panel) {
        super();

        this.holder = holder;
        this.panel = panel;
    }

    @Override
    public void run() {
        long startTime;
        long timeMilis;
        long waitTime;
        int frameCount = 0;
        long totalTime = 0;

        while (running) {
            startTime = System.nanoTime();
            canvas = null;

            try {
                canvas = holder.lockCanvas();
                synchronized (holder) {
                    panel.update();
                    panel.draw(canvas);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (canvas != null) {
                    try {
                        holder.unlockCanvasAndPost(canvas);
                    } catch (Exception e) { e.printStackTrace(); }
                }
            }

            timeMilis = (System.nanoTime() - startTime) / 1000000;
            waitTime = TARGET_TIME - timeMilis;
            try {
                if (waitTime > 0)
                    this.sleep(waitTime);
            } catch (Exception e) { e.printStackTrace(); }

            totalTime += System.nanoTime() - startTime;
            frameCount++;

            if (frameCount == MAX_FPS) {
                averageFPS = 1000/((totalTime/frameCount)/1000000);
                frameCount = 0;
                totalTime = 0;
                System.out.println(averageFPS);
            }
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
