package io.npee.leetcode._00035_searchinsertposition;


public class SearchInsertPosition {
    // runtime complexity : equal or less then O(log n) -> binary search
    public static int searchInsert(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int m = (l + h) / 2;
            if (nums[m] == target) return m;
            else if (nums[m] > target) h = m - 1;
            else l = m + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 0;
        int result = searchInsert(nums, target);
        System.out.println("result = " + result);
    }
}
