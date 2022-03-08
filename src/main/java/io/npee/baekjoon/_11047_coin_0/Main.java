package io.npee.baekjoon._11047_coin_0;


import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("동전 = " + coin0());
	}

	public static int coin0() {

		Scanner s = new Scanner(System.in);

		int N = s.nextInt();
		int K = s.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = s.nextInt();
		}
		System.out.println("N = " + N);
		System.out.println("K = " + K);
		for (int i : A) {
			System.out.println("i = " + i);
		}

		int res = 0;

		for (int i = N - 1; i >= 0; i--) {
			res += K / A[i]; // 동전 개수
			K %= A[i];
			if (K == 0 || K / A[0] == 0) {
				return res;
			}
		}

		return res;
	}
}

