package io.npee._01567_maximumlengthofsubarraywithpositiveproduct;

public class MaximumLengthOfSubarrayWithPositiveProduct {
    public static int getMaxLen(int[] nums) {
        // subarray의 길이만 알면 된다.
        int negativeCount = 0, max = 0;
        int firstNegativePos = -1, zeroPos = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negativeCount++;
                if (firstNegativePos == -1) {
                    firstNegativePos = i;
                }
            }
            if (nums[i] == 0) {
                negativeCount = 0; // 음수 카운터 리셋
                firstNegativePos = -1; // 첫 음수 인덱스 리셋
                zeroPos = i;
            } else {
                if (negativeCount % 2 == 0) {
                    // 음수 카운트가 짝수면 양수이므로 최근 0이 있던 지점부터 인덱스를 계산한다.
                    max = Math.max(i - zeroPos, max);
                } else {
                    // 음수 카운트가 홀수면 음수이므로 첫 음수가 나왔던 자리부터 인덱스를 계산한다.
                    // -> 가장 먼저 나온 음수를 빼고 계산하여 양수를 맞춘다.
                    max = Math.max(i - firstNegativePos, max);
                }
            }
        }
        System.out.println("firstNegativePos = " + firstNegativePos);
        System.out.println("negativeCount = " + negativeCount);
        return max;
    }

    public static void main(String[] args) {
        // int[] nums = {1,2,3,5,-6,4,0,10};
        // int[] nums = {-1,2};
        // int[] nums = {-1,-2,-3,0,1};
        int[] nums = {1, -2, -3, -4, 5};
        int result = getMaxLen(nums);
        System.out.println("result = " + result);
    }
}
