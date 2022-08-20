/**
 * 문제 제목 : 023. 멘토링
 * 강의 시청 : ✔️
 */

// 강의를 보기전 내 방식 -> ❌ (false)

// =============================================================== //
package main;

import java.util.Scanner;

public class IjC212 {

	public static void main(String[] args) {
		IjC212 T = new IjC212();
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int m = kb.nextInt();

		int[][] arr = new int[m][n];

		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = kb.nextInt();
			}
		}
		System.out.println(T.solution(n, m, arr));
	}

	public int solution(int n, int m, int[][] arr) {
		int answer = 0;

		for(int i=1; i<=n; i++) {

			for(int j=1; j<=n; j++) {

				int cnt = 0;

				for(int k=0; k<m; k++) {
					int pi = 0, pj = 0;

					for(int s=0; s<n; s++) {
						if(arr[k][s] == i) pi = s;
						if(arr[k][s] == j) pj = s;
					}

					if(pi < pj) cnt++;
				}
				if(cnt == m) {
					answer++;
				}
			}
		}
		return answer;
	}

}
