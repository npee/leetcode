package io.npee.leetcode._03373_maximizethenumberoftargetnodesafterconnectingtreesii

fun main() {
    // edges1 = [[0,1],[0,2],[2,3],[2,4]]
    // edges2 = [[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]]
    val edges1 = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, 2),
        intArrayOf(2, 3),
        intArrayOf(2, 4)
    )
    val edges2 = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, 2),
        intArrayOf(0, 3),
        intArrayOf(2, 7),
        intArrayOf(1, 4),
        intArrayOf(4, 5),
        intArrayOf(4, 6)
    )
    maxTargetNodes1(edges1, edges2).forEachIndexed { index, value ->
        println("Result[$index]: $value")
    }
}