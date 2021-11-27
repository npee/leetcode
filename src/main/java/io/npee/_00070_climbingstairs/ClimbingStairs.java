package io.npee._00070_climbingstairs;

public class ClimbingStairs {
    public static int climbStairs(int n) {
        // 첫 번째 수 제외한 피보나치 아닌가? -> 시간 제한 걸림
        if (n < 2) {
            return 1;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    public static int climbStairsDp(int n) {
        if (n < 2) {
            return 1;
        }
        int a = 1, b = 2;
        while (--n > 1) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 4;
        int result = climbStairsDp(n);
        System.out.println("result = " + result);
    }
}
