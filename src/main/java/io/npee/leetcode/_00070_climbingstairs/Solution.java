package io.npee.leetcode._00070_climbingstairs;

class Solution {
    public int climbStairs(int n) {
        if (n < 2) {
            return 1;
        }
        int a = 1, b = 2;
        while (--n > 1) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}