package io.npee._00053_maximumsubarray;

public class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            res = Math.max(sum, res);
        }

        return res;
    }
}
