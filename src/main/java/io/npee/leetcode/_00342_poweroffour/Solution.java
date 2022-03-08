package io.npee.leetcode._00342_poweroffour;

import java.util.Scanner;

public class Solution {
    public static boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Input > ");
        int input = s.nextInt();
        while (input > 0) {
            System.out.println("Input: " + input);
            System.out.println("Output: " + isPowerOfFour(input));
            System.out.print("Input > ");
            input = s.nextInt();
        }
    }
}
