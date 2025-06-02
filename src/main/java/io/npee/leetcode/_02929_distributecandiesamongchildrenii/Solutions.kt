package io.npee.leetcode._02929_distributecandiesamongchildrenii

fun distributeCandies1(n: Int, limit: Int): Long {

    var result: Long = 0
    for (i in 0 .. minOf(limit, n)) {
        if (n - i > 2 * limit) {
            continue
        }
        result += minOf(n - i, limit) - maxOf(0, n - i - limit) + 1
    }
    return result
}

fun distributeCandies2(n: Int, limit: Int): Long {
    fun twoOfComb(x: Long): Long {
        if (x < 0) return 0
        return x * (x - 1) / 2
    }

    /**
     * total: n + 2 Comb 2
     * invalid case 1: 3 * (n + 2 - (limit + 1) Comb 2)
     * invalid case 2: 3 * (n + 2 - 2 * (limit + 1) Comb 2)
     * invalid case 3: n + 2 - 3 * (limit + 1) Comb 2
     */
    val total = twoOfComb(n + 2L)
    return total - 3 * twoOfComb(n - limit + 1L) - 3 * twoOfComb(n + (-2 * (limit + 1L))) - twoOfComb(n + (-3 * (limit + 1L)))
}