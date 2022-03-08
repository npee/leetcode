package io.npee.leetcode._00213_houserobber2;

public class HouseRobberII  {
    public static int rob(int[] nums) {
        // return rob(nums, nums.length - 1);
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob2(nums, 0, nums.length - 2), rob2(nums, 1, nums.length - 1));
    }

    public static int rob2(int[] nums, int start, int end) {
        if (start > end) return 0;
        int a = 0, b = 0;
        for (int i = start; i <= end; i++) {
            int res = Math.max(b, a + nums[i]);
            a = b;
            b = res;
        }
        return b;
    }

    public static int rob(int[] nums, int i) {
        if (i < 0) return 0;
        return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
    }

    public static void main(String[] args) {
        // int[] nums = {1,2,3,1};
        // int[] nums = {2,3,2};
        int[] nums = {1};

        int result = rob(nums);
        System.out.println("result = " + result);
    }
}
