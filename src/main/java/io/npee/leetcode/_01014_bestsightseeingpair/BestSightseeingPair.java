package io.npee.leetcode._01014_bestsightseeingpair;


public class BestSightseeingPair {
    public static int maxScoreSightseeingPair(int[] values) {
        int res = 0, l = 0;
        for (int r: values) {
            res = Math.max(res, l + r);
            l = Math.max(l, r) - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] values = {8,1,5,2,6};
//        int[] values = {1,2};
        int result = maxScoreSightseeingPair(values);
        System.out.println("result = " + result);
    }
}
