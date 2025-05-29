package io.npee.leetcode._03068_findthemaximumsumofnodevalues

fun main() {

    val nums = intArrayOf(24, 78, 1, 97, 44)
    val k = 6
    val edges = arrayOf(
        intArrayOf(0, 2),
        intArrayOf(1, 2),
        intArrayOf(4, 2),
        intArrayOf(3, 4)
    )
    val result1 = maximumValueSum1(nums, k, edges)
    val result2 = maximumValueSum2(nums, k, edges)
    val result3 = maximumValueSum3(nums, k, edges)
    val result4 = maximumValueSum4(nums, k, edges)
    println("Result1: $result1")
    println("Result2: $result2")
    println("Result3: $result3")
    println("Result4: $result4")
    // 모든 솔루션에서 edges 를 안쓴다..?
}