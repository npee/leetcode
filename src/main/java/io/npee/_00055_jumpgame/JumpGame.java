package io.npee._00055_jumpgame;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        // 조건:
        // 1. 첫 인덱스에서 시작한다.
        // 2. 값 범위 내에서 다음 인덱스까지 점프 가능하다.
        // 3. 점프 도중 마지막 인덱스를 만나면 true 를 반환한다. -> 마지막 점프를 잘하면 된다.
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) return false;
            max = Math.max(i + nums[i], max);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        // int[] nums = {3,2,1,0,4};
        boolean result = canJump(nums);
        System.out.println("result = " + result);
    }
}
