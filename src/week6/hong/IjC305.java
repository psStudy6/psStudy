/**
 * 문제 제목 : 029. 연속된 자연수의 합
 * 강의 시청 : ✔️
 */

// 강의를 보기전 내 방식 -> ❌ (false)

// =============================================================== //

package main;

import java.util.Scanner;

public class IjC305 {

	public static void main(String[] args) {
		IjC305 T = new IjC305();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();

		System.out.print(T.soultion(n));
	}

	public int soultion(int n) {
		int answer = 0, sum = 0, lt = 0;
		int m=n/2+1;
		int[] arr = new int[m];

		for(int i=0; i<m; i++) arr[i] = i+1;
		for(int rt = 0; rt<m; rt++) {
			sum+= arr[rt];
			if(sum == n) answer++;
			while(sum >= n) {
				sum -= arr[lt++];
				if(sum == n) answer++;
			}
		}
		return answer;
	}
}
