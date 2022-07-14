/**
 * 문제 제목 : 021. 봉우리
 * 강의 시청 : ✔️
 */

// 강의를 보기전 내 방식 -> ❌ (false)

// =============================================================== //
package main;

import java.util.Scanner;

public class IjC210 {

	public static void main(String[] args) {
		IjC210 T = new IjC210();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();

		int[][] arr = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = kb.nextInt();
			}
		}
		System.out.println(T.solution(n, arr));
	}

	// 클래스 전역 변수로 선언
	int[] dx = {-1, 0, 1, 0};
	int[] dy = {0, 1, 0, -1};

	public int solution(int n, int[][] arr) {
		int answer = 0;

		// 봉우리인지 참조하기 위한 로직
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				boolean flag = true;

				for(int k=0; k<4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];

					// 조건. 12시 3시 6시 9시
					// 주석 주분이 안되는 이유는 먼저 들어지 않고 결과값이 출력 된 상태에서 출력을 하기 때문에 outof~에러가 발생
					if( nx>=0 && nx<n && ny>=0 && ny<n && arr[nx][ny]>= arr[i][j]) {
					// if(arr[nx][ny]>= arr[i][j] && nx>=0 && nx<n && ny>=0 && ny<n) {
						// 첫번째 값이 조건에 해당되지 않는다면 바로 false처리하기
						flag = false;
						break;
					}
				}
				if(flag) answer++;
			}
		}


		return answer;
	}

}
