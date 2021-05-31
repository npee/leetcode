package io.npee.romanToInteger;

import java.util.LinkedList;
import java.util.Queue;

public class RomanToInteger {
    public static void main(String[] args) {
        int res = 0;
        String roman = "III";
        Queue<Character> queue = new LinkedList<>();
        roman.chars().forEach(c -> queue.offer((char) c));
        // 예외: IV(4), IX(9), XL(40), XC(90), CD(400), CM(900), ...
        while (!queue.isEmpty()) {
            switch (queue.poll()) {
                case 'M':
                    res += 1000;
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'C':
                    if (queue.peek() == null || queue.peek() != 'M' || queue.peek() != 'D') {
                        res += 100;
                    } else {
                        res -= 100;
                    }
                    break;
                case 'X':
                    if (queue.peek() == null || queue.peek() != 'C' || queue.peek() != 'L') {
                        res += 10;
                    } else {
                        res -= 10;
                    }
                    break;
                case 'I':
                    if (queue.peek() == null || queue.peek() == 'I') {
                        res += 1;
                    } else {
                        res -= 1;
                    }
                    break;
            }

            if (queue.isEmpty()) {
                System.out.println(res);
            }
        }
    }
}
