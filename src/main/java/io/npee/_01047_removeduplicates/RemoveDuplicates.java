package io.npee._01047_removeduplicates;

public class RemoveDuplicates {
    public static String removeDuplicates(String s) {

        if (s.length() == 1) return s;
        int ptr = 0;
        char[] chars = s.toCharArray();
        for (int idx = 0; idx < chars.length; ++ptr, ++idx) {
            chars[ptr] = chars[idx];
            if (ptr > 0 && chars[ptr - 1] == chars[ptr]) {
                ptr -= 2;
            }
        }
        return new String(chars, 0, ptr);
    }

    public static void main(String[] args) {
        // String s = "ibfjcaffccadidiaidchakchchcahabhibdcejkdkfbaeeaecdjhajbkfebebfea";
        String s = "awzzxxwy";
        System.out.println(removeDuplicates(s));
    }
}
