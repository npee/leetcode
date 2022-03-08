package io.npee.leetcode._00152_maximumproductsubarray;

public class MaximumProductSubarray {
    public static int maxProductWrongAnswer(int[] nums) {
        // 음수를 곱해서 양수가 될 수 있음을 고려하자
        int prod = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prod = Math.max(prod * nums[i], nums[i]);
            max = Math.max(prod, max);
        }
        return max;
    }

    public static int maxProduct(int[] nums) {
        // 결과가 음수일 경우? 길이가 1인 배열에 유일한 원소가 음수인 경우
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);

            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        // int[] nums = {2,3,-2,4};
        // int[] nums = {-2,0,-1};
        int[] nums = {-2,3,-4};
        int result = maxProduct(nums);
        System.out.println("result = " + result);
    }
}
