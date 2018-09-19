package com.example.ernestolanchares.testgame.utils;

public class Interpolator {

    public static float linearInterpolate(float f1, float f2, float r) {
        return f1 + (f2 - f1)*r;
    }

    public static float linearInterpolate(int i1, int i2, float r) {
        return linearInterpolate((float) i1, (float) i2, r);
    }
}
