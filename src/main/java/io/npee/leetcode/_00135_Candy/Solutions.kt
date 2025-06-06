package io.npee.leetcode._00135_Candy

fun candy(ratings: IntArray): Int {

    var result = 0
    val n = ratings.size
    val l2r = IntArray(n) { 1 }
    val r2l = IntArray(n) { 1 }
    for (i in 1 until n) {
        if (ratings[i] > ratings[i - 1]) {
            l2r[i] = l2r[i - 1] + 1
        }
    }
    for (i in n - 2  downTo 0) {
        if (ratings[i] > ratings[i + 1]) {
            r2l[i] = r2l[i + 1] + 1
        }
    }

    for (i in 0 until n) {
        result += maxOf(l2r[i], r2l[i])
    }

    return result
}