package io.npee.leetcode._00001_twosum;

import java.util.Arrays;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int i, j;
        int[] res = new int[2];
        int size = nums.length;
        for (i = 0; i < size; ++i) {
            for (j = i + 1; j < size; ++j) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = {2, 7, 11, 15};
        int target = 9;
        System.out.println("SUM: " + Arrays.toString(twoSum(input, target)));
    }
}
