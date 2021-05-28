package io.npee;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        String xStr = String.valueOf(x);
        for (int pos = 0; pos < xStr.length() / 2; pos++) {
            if (xStr.charAt(pos) != xStr.charAt(xStr.length() - 1 - pos)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Is Palindrome?: " + isPalindrome(123321));
    }
}
