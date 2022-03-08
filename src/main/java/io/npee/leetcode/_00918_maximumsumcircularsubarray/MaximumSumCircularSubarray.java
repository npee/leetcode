package io.npee.leetcode._00918_maximumsumcircularsubarray;

public class MaximumSumCircularSubarray {
    public static int maxSubarraySumCircular(int[] nums) {
        // 순환 배열의 부분 배열의 합이 가장 큰 경우 = max
        // 가장 작은 경우 = min
        // 1. 비순환 상에서 최대값이 있는 겨웅
        // -> max
        // 2. 양쪽 끝으로 나뉘는 경우
        // -> max = total - min
        // 2가지 경우 중 큰 값 채용 -> Math.max(max, total - min)
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

    public static void main(String[] args) {
        // int[] nums = {1,-2,3,-2};
        // int[] nums = {3,-1,2,-1};
        // int[] nums = {3,-2,2,-3};
        int[] nums = {-3,-2,-2,-3};

        int result = maxSubarraySumCircular(nums);
        System.out.println("result = " + result);
    }
}
