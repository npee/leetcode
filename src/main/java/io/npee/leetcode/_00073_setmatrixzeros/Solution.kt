package io.npee.leetcode._00073_setmatrixzeros

class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val m = matrix.size
        val n = matrix[0].size
        val zeroX = BooleanArray(m)
        val zeroY = BooleanArray(n)

        for (x in 0 until m) {
            for (y in 0 until n) {
                if (matrix[x][y] == 0) {
                    zeroX[x] = true
                    zeroY[y] = true
                }
            }
        }

        for (x in 0 until m) {
            for (y in 0 until n) {
                if (zeroX[x] || zeroY[y]) {
                    matrix[x][y] = 0
                }
            }
        }
    }
}