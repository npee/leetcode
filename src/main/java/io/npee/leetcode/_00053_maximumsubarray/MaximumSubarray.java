package io.npee.leetcode._00053_maximumsubarray;

public class MaximumSubarray {
    public static int maxSubArrayTimeLimitExceeded(int[] nums) {
        // 연속된 원소의 합이 가장 큰 부분 집합(배열)의 합을 반환
        // 204 / 209 Time Limit Exceeded
        int max, sum, res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i];
            max = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
            res = Math.max(res, max);
        }
        return res;
    }

    public static int maxSubArray(int[] nums) {
        // dp
        int sum = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            // 한 번 더했던 과정을 반복할 필요가 없으므로 2중 for문을 쓸 필요도 없다.
            res = Math.max(sum, res);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        // int[] nums = {-1};
        int result = maxSubArray(nums);
        System.out.println("result = " + result);
    }
}
