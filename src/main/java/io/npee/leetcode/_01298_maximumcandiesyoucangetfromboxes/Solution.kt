package io.npee.leetcode._01298_maximumcandiesyoucangetfromboxes

fun main() {
    val result1 = maxCandies(
        status = intArrayOf(1, 0, 1, 0),
        candies = intArrayOf(7, 5, 4, 100),
        keys = arrayOf(intArrayOf(), intArrayOf(), intArrayOf(1), intArrayOf()),
        containedBoxes = arrayOf(intArrayOf(1, 2), intArrayOf(3), intArrayOf(), intArrayOf()),
        initialBoxes = intArrayOf(0)
    )

    println("Result1: $result1") // Expected: 16
}