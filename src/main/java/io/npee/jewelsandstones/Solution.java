package io.npee.jewelsandstones;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int numJewelsInStones(String jewels, String stones) {
        int output = 0;
        Set<Character> jewelType = new HashSet<>();
        for (char jewel : jewels.toCharArray()) {
            jewelType.add(jewel);
        }
        for (char stone : stones.toCharArray()) {
            output += jewelType.contains(stone) ? 1: 0;
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println("Output: " + numJewelsInStones("abB", "aabbbBaba"));
    }
}
