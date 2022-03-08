package io.npee.leetcode._00342_poweroffour;

import java.util.Scanner;

public class PowerOfFour {
    public static boolean isPowerOfFour(int n) {
        if ((n % 4 != 0 && n != 1) || (n <= 0)) return false;
        if (n == 1) return true;
        return isPowerOfFour(n / 4);
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
