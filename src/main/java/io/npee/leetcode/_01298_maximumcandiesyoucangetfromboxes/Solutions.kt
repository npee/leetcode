package io.npee.leetcode._01298_maximumcandiesyoucangetfromboxes

fun maxCandies(status: IntArray, candies: IntArray, keys: Array<IntArray>, containedBoxes: Array<IntArray>, initialBoxes: IntArray): Int {
    // status 0: closed, 1: open
    // candies[i] is the number of candies in box i
    // keys[i] contains the indices of boxes that box i can open
    // containedBoxes[i] contains the indices of boxes that box i contains

    val n = status.size
    val canOpen = status.map { s -> s == 1 }.toMutableList()
    val hasBox = BooleanArray(n) { false }
    val used = BooleanArray(n) { false }

    val q: java.util.Queue<Int> = java.util.LinkedList()

    var result = 0
    for (box in initialBoxes) {
        hasBox[box] = true
        if (canOpen[box]) {
            q.offer(box)
            used[box] = true
            result += candies[box]
        }
    }

    while (q.isNotEmpty()) {
        val bigBox = q.poll()
        for (key in keys[bigBox]) {
            canOpen[key] = true
            if (!used[key] && hasBox[key]) {
                q.offer(key)
                used[key] = true
                result += candies[key]
            }
        }
        for (box in containedBoxes[bigBox]) {
            hasBox[box] = true
            if (!used[box] && canOpen[box]) {
                q.offer(box)
                used[box] = true
                result += candies[box]
            }
        }
    }

    return result
}