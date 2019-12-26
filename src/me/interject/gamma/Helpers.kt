package me.interject.gamma

/**
 * Created by mshau on 02.09.2016.
 */

/* TODO: add helpful methods */
/* EVERYTHING IN THIS CLASS HAS TO BE STATIC!!! */
object Helpers {
    /* ensures that a color value is in range */
    /* TODO: implement as Unsigned */
    fun RGB(value: Int): Int = value % 255

    /* computes the equivalent of some number to match the given aspect ratio */
    fun aspectRatio(ratio: Pair<Int, Int>, num: Int): Pair<Int, Int> = Pair<Int, Int>(num, num * (ratio.first / ratio.second))
}