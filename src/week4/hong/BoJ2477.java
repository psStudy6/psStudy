/**
 * 등록 번호 : 2477번  
 * 등록 제목 : 참외밭
 * 현재 상태 : 완료 ✔️
 */
package main;

import java.util.Scanner;

public class BoJ2477 {
	/**
	 * 문제 이해
	 * (Big가로 * Big세로) - (Small가로 * Small세로) * 7 = 결과 값
	 * 하지만 현재 육각형이라는 특수 케이스가 존재
	 * case1. 오른쪽 동쪽
	 * case2. 왼쪽 서쪽
	 * case3. 아래 남쪽
	 * case4. 위 북쪽
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		int lh = 0, lw = 0, sh = 999, sw = 999;
		int[][] arr = new int[6][2];

		for (int i = 0; i < 6; i++) {
			int dir = in.nextInt();	// 동서남북
			int len = in.nextInt();	// 길이

			arr[i][0] = dir;
			arr[i][1] = len;

			if (dir == 1 || dir == 2) {
				if (lw < len)
					lw = len;
			}

			if (dir == 3 || dir == 4) {
				if (lh < len)
					lh = len;
			}
		}

		for (int i = 0; i < 7; i++) {
			// 꺽이는 지점
			int t = arr[i % 6][0] * 10 + arr[(i + 1) % 6][0];
			switch (t) {
			case 24:
			case 32:
			case 13:
			case 41:
				sw = arr[i % 6][1];
				sh = arr[(i + 1) % 6][1];
			}
		}

		System.out.println((lw * lh - sw * sh) * k);
	}
}
