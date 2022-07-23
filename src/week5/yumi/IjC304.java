package week5.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 인프런 3-4 연속 부분수열
 * 
 * 문제 : N개의 수로 이루어진 수열이 주어집니다.
 * 		이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을
*/
public class IjC304 {
	
	// 방법
	public int solution2(int n, int m, int[] arr) {
		int cnt = 0, lt = 0, sum = 0;
		for (int rt = 0; rt < n; rt++) {
			sum += arr[rt];
			if (sum == m) {
				cnt++;
			}
			// M 보다 클 때 왼쪽 인덱스를 1개 씩 증가시킴
			while (sum >= m) {
				sum -= arr[lt++];
				if (sum == m) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	// 오답 - 테스트 케이스 찾아야 함
	public int solution(int n, int m, int[] arr) {
		int cnt = 0, stIdx = 0, endIdx = 0, sum = 0;

		while (endIdx < n) {
			if (sum == m) {
				sum = sum - arr[stIdx++] + arr[endIdx++];
				cnt++;
			}
			else if (sum < m) {
				sum += arr[endIdx++];
			}
			else {
				sum -= arr[stIdx++];
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		IjC304 ijC = new IjC304();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(ijC.solution(n, m, arr));
	}
}
