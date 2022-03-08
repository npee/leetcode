package io.npee.leetcode._00014_longestcommonprefix;


public class Solution {
    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char criteria = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || criteria != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];

    }

    public static void main(String[] args) {
        String[] strs = new String[3];
        strs[0] = "abcdef";
        strs[1] = "abcde";
        strs[2] = "abc";
        System.out.println("longestCommonPrefix(strs) = " + longestCommonPrefix(strs));
    }
}
