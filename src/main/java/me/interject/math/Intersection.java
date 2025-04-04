package me.interject.math;

public class Intersection {
    public static boolean intersect(int a, int aBounding, int b, int bBounding) {
        int aMin = Math.abs(a - aBounding);
        int aMax = a + aBounding;
        int bMin = Math.abs(b - bBounding);
        int bMax = b + bBounding;

        return (bMin > aMin && bMin < aMax) || (aMin > bMin && aMin < bMax);
    }
}
