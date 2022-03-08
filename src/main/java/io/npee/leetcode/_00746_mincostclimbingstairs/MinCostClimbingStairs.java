package io.npee.leetcode._00746_mincostclimbingstairs;

public class MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int a = cost[0];
        int b = cost[1];
        if (n <= 2) {
            return Math.min(a, b);
        }
        while(--n > 2) {
            int sum = cost[n] + Math.max(a, b);
            a = b;
            b = sum;
        }
        return Math.min(a, b);
    }

    public static void main(String[] args) {
        int[] cost = {10,15,20};
        int result = minCostClimbingStairs(cost);
        System.out.println("result = " + result);
    }
}
