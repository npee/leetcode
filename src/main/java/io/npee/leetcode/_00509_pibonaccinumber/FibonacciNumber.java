package io.npee.leetcode._00509_pibonaccinumber;

public class FibonacciNumber {
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0, b = 1;
        while (n-- > 1) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static int fib3(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    static int[] DP_CACHE = new int[31];
    public static int fib4(int n) {
        if (n <= 1) {
            return n;
        } else if (DP_CACHE[n] != 0) {
            return DP_CACHE[n];
        } else {
            return DP_CACHE[n] = fib4(n - 1) + fib4(n - 2);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int result = fib4(n);
        System.out.println("result = " + result);
    }
}
