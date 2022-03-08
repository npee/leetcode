package io.npee.leetcode._00198_houserobber;

public class HouseRobber {
    static int[] memo;
    public static int rob(int[] nums) {
        // rob1
        // return rob1(nums, nums.length - 1);

        // rob2
        /*
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return rob2(nums, nums.length - 1);
         */
        // rob3
        // return rob3(nums);
        // rob4
        return rob4(nums);
    }

    private static int rob1(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        return Math.max(rob1(nums, i - 2) + nums[i], rob1(nums, i - 1));
    }

    // recursive + memorization (top-down)
    private static int rob2(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] >= 0) {
            return memo[i];
        }
        int result = Math.max(rob2(nums, i - 2) + nums[i], rob2(nums, i - 1));
        memo[i] = result;
        return result;
    }

    // iterate + memorization (bottom-up)
    private static int rob3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] memo = new int[nums.length];
        memo[0] = nums[0];
        for (int i = 2; i < nums.length; i++) {
            int curr = nums[i];
            memo[i] = Math.max(memo[i - 1], memo[i - 2] + curr);
        }
        return memo[nums.length - 1];
    }

    // iterative + 2 variables (bottom-up)
    private static int rob4(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // a - b - curr
        int a = 0, b = 0;
        for (int curr : nums) {
            int res = Math.max(b, a + curr);
            a = b;
            b = res;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int result = rob(nums);
        System.out.println("result = " + result);
    }
}
