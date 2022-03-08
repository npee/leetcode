package io.npee.leetcode._00771_jewelsandstones;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JewelsAndStones {
    // 771. Jewels And Stones
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
        // Input: jewels = "aA", stones = "aAAbbbb"
        // Output: 3
        Scanner s = new Scanner(System.in);
        System.out.print("Input(Jewels) > ");
        String jewels = s.nextLine();
        System.out.print("Input(Stones) > ");
        String stones = s.nextLine();

        System.out.println("Output: " + numJewelsInStones(jewels, stones));
    }
}
