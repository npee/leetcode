package io.npee._00045_jumpgame2;

public class JumpGameII {
    public static int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int max = 0;
        int level = 0, i = 0;
        while (i <= max) {
            int furthest = max;
            for (; i <= max; i++) {
                furthest = Math.max(furthest, nums[i] + i);
                if (furthest >= nums.length - 1) {
                    return level + 1;
                }
            }
            level++;
            max = furthest;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,1,1};
        int result = jump(nums);
        System.out.println("result = " + result);
    }
}
