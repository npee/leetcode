package io.npee.leetcode._00238_productofarrayexceptself;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int allProducts = 1;
        boolean hasZero = false;
        boolean hasZeros = false;
        for (int num : nums) {
            if (num == 0) {
                if (hasZero) {
                    hasZeros = true;
                    break;
                }
                hasZero = true;
                continue;
            }
            allProducts *= num;
        }

        for (int i = 0; i < nums.length; i++) {
            if (hasZeros) {
                return new int[nums.length];
            }
            if (nums[i] == 0) {
                nums[i] = allProducts;
            } else if (hasZero) {
                nums[i] = 0;
            } else {
                nums[i] = allProducts / nums[i];
            }
        }

        // 같은 숫자 고려해야함. 특히 0이 2개 이상일 때 문제
        // 2개 이상이면 모든 칸이 0이겠구나

        return nums;
    }

    public static int[] productExceptSelf2(int[] nums) {
        // 인덱스 기준 왼쪽 수들의 곱과 오른쪽 수들의 곱의 결과를 다시 곱하여 저장
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1; // O(1) extra space complexity
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        // int[] nums = {1,2,3,4};
        int[] nums = {0, 0};
        // int[] nums = {-1,1,0,-3,3};
        int[] result = productExceptSelf(nums);
        // Output: [24,12,8,6]
        for (int i : result) {
            System.out.println("i = " + i);
        }
    }
}
