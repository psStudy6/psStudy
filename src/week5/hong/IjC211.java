/**
 * 문제 제목 : 022. 임시반장 정하기
 * 강의 시청 : ✔️
 */

// 강의를 보기전 내 방식 -> ❌ (false)

// =============================================================== //

// 강의내용1
package main;

import java.util.Scanner;

public class IjC211 {

	public static void main(String[] args) {
		IjC211 T = new IjC211();
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int[][] arr = new int[n+1][6];

		// 학생 번호
		for(int i=1; i<=n; i++) {
			// 학년
			for(int j=1; j<=5; j++) {
				arr[i][j] = kb.nextInt();
			}
		}
		System.out.println(T.solution(n, arr));

	}

	public int solution(int n, int[][] arr) {
		int answer = 0, max = Integer.MIN_VALUE;

		for(int i=1; i<=n; i++) {
			int cnt = 0;
			for(int j=1; j<=n; j++) {
				for(int k=1; k<=5; k++) {
					if(arr[i][k] == arr[j][k]) {
						cnt++;
						break;
					}

				}
			}
			if(cnt > max) {
				max = cnt;
				answer = i;
			}
		}
		return answer;
	}

}
