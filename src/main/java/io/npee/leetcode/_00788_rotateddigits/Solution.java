package io.npee.leetcode._00788_rotateddigits;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public static int rotatedDigits(int N) {
        char[] chars = Integer.toString(N).toCharArray();
        int res = 0;
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(0, 1, 8));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(0, 1, 8, 2, 5, 6, 9));
        HashSet<Integer> digits = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            int digit = chars[i] - '0';
            for (int j = 0; j < digit; j++) {
                if (set2.contains(j)) {
                    res += (int) Math.pow(7, chars.length - i - 1);
                }
                if (set1.containsAll(digits) && set1.contains(j)) {
                    res -= (int) Math.pow(3, chars.length - i - 1);
                }
            }
            digits.add(digit);
            if (!set2.contains(digit)) {
                return res;
            }

        }

        return res + (!set1.containsAll(digits) ? 1 : 0);
    }

    public static void main(String[] args) {
        System.out.println("Output: " + rotatedDigits(12));
    }
}
