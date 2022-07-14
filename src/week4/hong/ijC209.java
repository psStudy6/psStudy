/**
 * 문제 제목 : 020. 등수구하기
 * 강의 시청 : ✔️
 */

// 강의를 보기전 내 방식 -> ❌ (false)

// =============================================================== //

// 강의내용1
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Main T = new Main();
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

	public int solution(int n, int[][] arr) {
		int answer = Integer.MIN_VALUE;
		int sum1, sum2;	// 변수 선언

		// 가로 혹은 세로의 합을 구해주는 역할
		for(int i=0; i<n; i++) {
			sum1=sum2=0; // 초기화
			for(int j=0; j<n; j++) {
				sum1 += arr[i][j];
				sum2 += arr[j][i];
			}
			// 1번쩨 더 큰값으로 교체해주는 역할
			answer = Math.max(answer, sum1);
			answer = Math.max(answer, sum2);
		}
		sum1=sum2=0; // 초기화
		// 대각선의 합을 구해주는 역할
		for(int i=0; i<n; i++) {
			sum1 += arr[i][i];
			sum2 += arr[i][n-i-1];
		}
		// 2번쩨 더 큰값으로 교체해주는 역할
		answer = Math.max(answer, sum1);
		answer = Math.max(answer, sum2);
		return answer;
	}
}
