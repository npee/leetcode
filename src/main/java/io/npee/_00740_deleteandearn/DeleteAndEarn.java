package io.npee._00740_deleteandearn;

public class DeleteAndEarn {

    public static int deleteAndEarn(int[] nums) {
        // 시작: 특정 원소를 인덱스로 가지는 배열에서 인덱스에 해당하는 원소를 합한 결과를 값으로 저장하는 버킷으로 표현한다.
        // 1. i번째 값을 취한다는 것은 i-1번째 값은 버려졌다는 의미이다.
        // 2. i번째 값을 버렸다는 것은 i-1번째 값을 버렸을 수도 있고 i-1번째 값을 취했을 수도 있으며 결국 둘 중 큰 값을 선택했을 것이다.
        int[] bucket = new int[10001]; // 0은 없음
        for (int num : nums) {
            bucket[num] += num; // 버킷 초기화
        }
        int take = 0, skip = 0; //
        for (int value : bucket) {
            int takeRes = skip + value;
            int skipRes = Math.max(take, skip);
            take = takeRes;
            skip = skipRes;
        }

        return Math.max(take, skip);
    }

    public static void main(String[] args) {
        int[] nums = {3,4,2};
        int result = deleteAndEarn(nums);
        System.out.println("result = " + result);
    }
}
