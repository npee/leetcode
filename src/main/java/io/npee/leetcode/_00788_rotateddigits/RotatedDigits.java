package io.npee.leetcode._00788_rotateddigits;

public class RotatedDigits {
    public static int rotatedDigits(int n) {
        // good number 조건 -> 각 숫자를 180도 회전했을 때 기존 수와 다른 새로운 수가 되는 숫자들의 조합
        // ex) 13, 44, 57 -> 유효하지 않은 수 -> no count
        // ex) 11, 111, 888, 101, 1010 -> 유효한 수이면서 같은 숫자 -> no count
        // ex) 52(25), 182(185), .. -> 유효한 수이면서 기존의 수와 다른 수가 됨 ->  count
        // 1. 1의자리에 유효하지 않은 수가 나올 때는 no count -> 저장
        // point -> 어떤 자리수이든 1의 경우의 수가 들어가면 이 수는 gn이 될 수 없다. -> 고려대상에서 제외됨
        // 2. 1의자리에 유효하지만 gn은 아니면 no count -> 저장
        // point -> 2의 경우에서 다른 자릿수가 gn이면 전체 수는 gn이 된다.
        // 3. 1의자리가 gn인 경우 count -> 저장
        // point -> 3의 경우에서 다른 자리의 숫자도 3의 경우이거나 2의 경우이면 전체 수는 gn이 된다.
        int res = 0;
        int[] nArray = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            if (i < 10) {
                if (i == 0 || i == 1 || i == 8) {
                    nArray[i] = 1;
                } else if (i == 2 || i == 5 || i == 6 || i == 9) {
                    nArray[i] = 2;
                    res++;
                } else {
                    nArray[i] = 0;
                }
            } else {
                if (nArray[i / 10] == 1 && nArray[i % 10] == 1) {
                    nArray[i] = 1;
                } else if (nArray[i / 10] >= 1 && nArray[i % 10] >= 1) {
                    nArray[i] = 2;
                    res++;
                } else {
                    nArray[i] = 0;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("Output: " + rotatedDigits(12));
    }
}
