package week4.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 인프런 2-9 격자판 최대합
 * 
 * 문제 : N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.
 * 
 * 방법 : 대각선 왼-오 ) 행 = 열
 * 		대각선 오-왼 ) n-행-1 == 열
*/
public class IjC209 {
	public int solution(int[][] arr) {
		int len = arr.length;
		int maxSum = 0, sumZ = 0, sumZ2 = 0;
		
		for (int i = 0; i < len; i++) {
			int sumX = 0, sumY = 0;
			for (int j = 0; j < len; j++) {
				sumX += arr[i][j]; // 열
				sumY += arr[j][i]; // 행
				// 대각선 왼-오
				if (i==j) {
					sumZ += arr[i][j];
				}
				// 대각선 오-왼
				if (len-i-1 == j) {
					sumZ2 += arr[i][j];
				}
			}
			// 행, 열 최대값
			maxSum = Math.max(maxSum, Math.max(sumX, sumY));
		}
		// 행, 열, 대각선 최대값
		maxSum = Math.max(maxSum, Math.max(sumZ, sumZ2));
		return maxSum;
	}
	
	public static void main(String[] args) throws IOException {
		IjC209 ijC = new IjC209();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		
		for (int i = 0; i < arr.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		System.out.println(ijC.solution(arr));
	}
}
