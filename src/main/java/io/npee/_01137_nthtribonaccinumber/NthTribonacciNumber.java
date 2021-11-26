package io.npee._01137_nthtribonaccinumber;

public class NthTribonacciNumber {
    public static int tribonacci(int n) {
        if (n == 0) return 0;
        else if (n <= 2) return 1;

        int a = 0, b = 1, c = 1;
        while (n-- > 2) {
            int sum = a + b + c;
            a = b;
            b = c;
            c = sum;
        }

        return c;
    }

    public static int tribonacci2(int n) {
        if (n == 0) return 0;
        else if (n <= 2) return 1;
        else {
            return tribonacci2(n - 1) + tribonacci2(n - 2) + tribonacci2(n - 3);
        }
    }

    public static int tribonacci3(int n) {
        if (n == 0) return 0;
        else if (n <= 2) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }

    static int[] DP_CACHE = new int[37];
    public static int tribonacci4(int n) {
        DP_CACHE[0] = 0;
        DP_CACHE[1] = 1;
        DP_CACHE[2] = 1;
        if (n <= 2 || DP_CACHE[n] != 0) {
            return DP_CACHE[n];
        } else {
            return DP_CACHE[n] = tribonacci3(n - 1) + tribonacci3(n - 2) + tribonacci3(n - 3);
        }
    }

    public static int tribonacci5(int n) {
        int[] dp = {0, 1, 1};
        for (int i = 3; i <= n; i++) {
            dp[i % 3] = dp[0] + dp[1] + dp[2];
        }
        return dp[n % 3];
    }

    public static void main(String[] args) {
        int n = 5;
        int result = tribonacci5(n);
        System.out.println("result = " + result);
    }
}
