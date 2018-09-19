package com.example.ernestolanchares.testgame.utils;

import android.graphics.Bitmap;
import android.graphics.Rect;

public class RectUtils {

    public static void scalateRect(Rect rect, Bitmap bm) {
        float whRatio = ((float) bm.getWidth()) / bm.getHeight();
        if (rect.width() > rect.height())
            rect.right = (int) (rect.left + rect.height() * whRatio);
        else
            rect.top = (int) (rect.bottom - rect.width() * whRatio);
    }

    public static void scaleToWidth(Rect rect, int desiredWidth) {
        float hwRatio = ((float) rect.height()) / rect.width();
        rect.set(rect.left, rect.top, rect.left + desiredWidth, (int) (rect.top + hwRatio*desiredWidth));
    }

    public static void centerRect(Rect rect) {
        centerVertically(rect);
        centerHorizontally(rect);
    }

    public static void centerVertically(Rect rect) {
        int width = rect.width();
        rect.left = (Constants.SCREEN_WIDTH - width)/2;
        rect.right = (Constants.SCREEN_WIDTH + width)/2;
    }

    public static void centerHorizontally(Rect rect) {
        int height = rect.height();
        rect.top = (Constants.SCREEN_HEIGHT - height)/2;
        rect.bottom = (Constants.SCREEN_HEIGHT + height)/2;
    }
}
