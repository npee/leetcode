package io.npee._00918_maximumsumcircularsubarray;

public class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int minSum = 0;
        int maxSum = 0;
        int minRes = nums[0];
        int maxRes = nums[0];
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            maxSum = Math.max(maxSum + nums[i], nums[i]);
            maxRes = Math.max(maxSum, maxRes);
            minSum = Math.min(minSum + nums[i], nums[i]);
            minRes = Math.min(minSum, minRes);
            total += nums[i];
        }
        if (maxRes > 0) {
            return Math.max(maxRes, total - minRes);
        } else {
            return maxRes;
        }
    }
}