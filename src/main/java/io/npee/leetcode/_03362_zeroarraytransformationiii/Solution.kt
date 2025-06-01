package io.npee.leetcode._03362_zeroarraytransformationiii

import java.util.*


class Solution {
    fun maxRemoval(nums: IntArray, queries: Array<IntArray>): Int {

        queries.sortBy { it[0] }
        val heap = PriorityQueue<Int>(reverseOrder())
        val deltaArray = IntArray(nums.size + 1)
        var operations = 0
        var j = 0


        for (i in nums.indices) {
            operations += deltaArray[i]

            while (j < queries.size && queries[j][0] == i) {
                heap.offer(queries[j][1])
                j++
            }

            println("heap: $heap")

            while (operations < nums[i] && heap.isNotEmpty() && heap.peek() >= i) {
                operations++
                val end = heap.poll()
                if (end + 1 < deltaArray.size) {
                    deltaArray[end + 1]--
                }
            }

            if (operations < nums[i]) {
                return -1
            }
        }

        return heap.size
    }
}

fun main() {
    val nums = intArrayOf(1, 1, 1, 1)
    val queries = arrayOf(intArrayOf(1, 3), intArrayOf(0, 2), intArrayOf(1, 3), intArrayOf(1, 2))
    val solution = Solution()
    val result = solution.maxRemoval(nums, queries)
    println("Result: $result")
}