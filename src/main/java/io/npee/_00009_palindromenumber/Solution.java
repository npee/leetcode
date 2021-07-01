package io.npee._00009_palindromenumber;

import java.util.Scanner;

public class Solution {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;

        int reverse = 0;
        int copy = x;

        while (copy > 0) {
            int digit = copy % 10;
            reverse = reverse * 10 + digit;
            copy /= 10;
        }

        return reverse == x;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("input -> ");
        int input = s.nextInt();
        System.out.println(input + " is palindrome? " + isPalindrome(input));
    }
}
