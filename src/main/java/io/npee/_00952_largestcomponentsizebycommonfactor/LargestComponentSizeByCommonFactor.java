package io.npee._00952_largestcomponentsizebycommonfactor;

import java.util.HashMap;
import java.util.Map;

public class LargestComponentSizeByCommonFactor {
    static int[] temp;

    public static int largestComponentSize(int[] nums) {
        // 주어진 배열의 값 중 가장 큰 수를 용적으로 하고, 각 인덱스에 자기자신을 데이터로 하여 새 배열 초기화
        int max = 0;
        for (int i : nums) {
            max = Math.max(i, max);
        }
        temp = new int[max + 1]; // 0은 없음
        for (int i = 1; i < max + 1; i++) {
            temp[i] = i;
        }

        for (int i : nums) {
            for (int j = (int) Math.sqrt(i); j >= 2; j--) { // 자기 자신의 반 만큼만 조사(a / b 에서 b가 a의 반을 넘을 경우 이미 몫이 2 미만이다.)
                if (i % j == 0) { // j 가 i 의 약수이면
                    System.out.print("add " + i + ", " + j + "\n");
                    union(i, j);
                    System.out.print("add " + i + ", (" + i + " / " + j + ")\n");
                    union(i, i / j);
                }
            }
        }


        int res = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i : nums) {
            System.out.println("====== get(" + i + ") ======");
            int j = find(i);
            System.out.println("====== j = " + j + " =======");
            if (!hashMap.containsKey(j)) {
                hashMap.put(j, 1);
            } else {
                hashMap.put(j, hashMap.get(j) + 1);
                System.out.println(j + " " + hashMap.get(j));
            }
            res = Math.max(res, hashMap.get(j));
        }

        System.out.println("res = " + res);

        return 0;
    }

    static int find(int x) {
        if (temp[x] == x) { // 재귀 중지 조건
            System.out.println("get - 재귀 중지 x = " + x + ", temp[x] = " + temp[x]);
            return x;
        } else {
            System.out.println("get - 재귀     x = " + x + ", temp[x] = " + temp[x]);
            return temp[x] = find(temp[x]); // 경로 압축 및 재귀 호출
        }
        // return temp[x] == x ? x : (temp[x] = get(temp[x]));
    }

    static void union(int x, int y) {

        int getX = find(x);
        System.out.println("add - get(" + x + ") = " + getX);
        int getY = find(y);
        System.out.println("add - get(" + y + ") = " + getY);
        System.out.println("temp[" + getX + "] <- " + temp[getY]);
        // 최종적으로 y 가 x의 약수이면 x 인덱스의 데이터는 y 인덱스의 데이터로 덮어씌워진다
        temp[getX] = temp[getY];
    }

    public static void main(String[] args) {
        // int[] nums = {4,6,15,35};
        // int[] nums = {20,50,9,63};
        int[] nums = {2,3,6,7,4,12,21,39};

        int result = largestComponentSize(nums);
        System.out.println("result = " + result);
    }
}
