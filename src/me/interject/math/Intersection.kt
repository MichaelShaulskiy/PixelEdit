package me.interject.math

/**
 * Created by michaelshaulskiy on 11.09.16.
 */
fun intersect(a: Int, aBounding: Int, b: Int, bBounding: Int): Boolean {
    val aMin = Math.abs(a - aBounding)
    val aMax = a + aBounding
    val bMin = Math.abs(b - bBounding)
    val bMax = b + bBounding

    return (bMin > aMin && bMin < aMax || aMin > bMin && aMin < bMax)
}