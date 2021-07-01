package io.npee._00089_graycode;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<Integer> grayCode(int n) {
        Integer[] arr = new Integer[1 << n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i ^ (i >> 1);
        }
        return Arrays.asList(arr);
    }

    public static void main(String[] args) {
        System.out.println("Output: " + grayCode(3));
    }
}
