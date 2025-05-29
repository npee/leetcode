package io.npee.leetcode._03068_findthemaximumsumofnodevalues

/**
 * Top-Down DP - Memoization
 */

fun maximumValueSum1(nums: IntArray, k: Int, edges: Array<IntArray>): Long {

    val memo = Array(nums.size) { LongArray(2) { -1L } }

    fun maxSumOfNodes(index: Int, isEven: Int, nums: IntArray, k: Int, memo: Array<LongArray>): Long {
        if (index == nums.size) {
            return if (isEven == 1) 0 else Long.MIN_VALUE
        }
        if (memo[index][isEven] != -1L) {
            return memo[index][isEven]
        }
        val noXorDone = nums[index] + maxSumOfNodes(index + 1, isEven, nums, k, memo)
        val xorDone = (nums[index] xor k) + maxSumOfNodes(index + 1, isEven xor 1, nums, k, memo)

        memo[index][isEven] = maxOf(xorDone, noXorDone)
        return memo[index][isEven]
    }

    return maxSumOfNodes(0, 1, nums, k, memo)
}

/**
 * Bottom-Up DP - Tabulation
 */
fun maximumValueSum2(nums: IntArray, k: Int, edges: Array<IntArray>): Long {
    val n = nums.size
    val dp = Array(n + 1) { LongArray(2) { Long.MIN_VALUE } }
    dp[n][1] = 0
    dp[n][0] = Long.MAX_VALUE

    for (i in n - 1 downTo 0) {
        for (isEven in 0..1) {
            val performOperation = dp[i + 1][isEven xor 1] + (nums[i] xor k)
            val skipPerformOperation = dp[i + 1][isEven] + nums[i]
            dp[i][isEven] = maxOf(performOperation, skipPerformOperation)
        }
    }
    return dp[0][1]
}

/**
 * Greedy - Sorting-Based
 */
fun maximumValueSum3(nums: IntArray, k: Int, edges: Array<IntArray>): Long {
    val n = nums.size
    val netChange = IntArray(n)
    var nodeSum = 0

    for (i in 0 until n) {
        netChange[i] = (nums[i] xor k) - nums[i]
        nodeSum += nums[i]
    }

    netChange.sortDescending()

    for (i in 0 until n step 2) {
        if (i + 1 == n) {
            break
        }

        val pairSum = netChange[i] + netChange[i + 1]
        if (pairSum > 0) {
            nodeSum += pairSum
        }
    }
    return nodeSum.toLong()
}

/**
 * Greedy - Local Max and Min
 */
fun maximumValueSum4(nums: IntArray, k: Int, edges: Array<IntArray>): Long {
    var sum = 0
    var count = 0
    var positiveMinimum = (1 shl 30)
    var negativeMaximum = -1 * (1 shl 30)

    for (v in nums) {
        val operationNodeValue = v xor k
        sum += v
        val netChange = operationNodeValue - v
        if (netChange > 0) {
            positiveMinimum = minOf(positiveMinimum, netChange)
            sum += netChange
            count++
        } else {
            negativeMaximum = maxOf(negativeMaximum, netChange)
        }
    }

    if (count % 2 == 0) {
        return sum.toLong()
    }

    return maxOf(sum - positiveMinimum, sum + negativeMaximum).toLong()
}

