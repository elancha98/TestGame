package com.example.ernestolanchares.testgame.utils;

public class Interpolation {

    public static float linearInterpolate(float min, float max, float r) {
        return min + (min-max)*r;
    }

    public static float linearInterpolate(int min, int max, float r) {
        return linearInterpolate((float) min, (float) max, r);
    }
}
