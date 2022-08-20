/**
 * 문제 제목 : 029. 최대 길이 연속부분수열(복합적 문제)
 * 강의 시청 : ✔️
 */

// 강의를 보기전 내 방식 -> ❌ (false)

// =============================================================== //
package main;

import java.util.Scanner;

public class IjC306 {

	public static void main(String[] args) {
		IjC306 T = new IjC306();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int k = kb.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		System.out.print(T.soultion(n, k, arr));
	}

	public int soultion(int n, int k, int[] arr) {
		int answer = 0, cnt = 0, lt = 0;
		for(int rt = 0; rt<n; rt++) {
			if(arr[rt] ==0) cnt++;
			while(cnt>k) {
				if(arr[lt] == 0) cnt--;
				lt++;
			}
			answer = Math.max(answer, rt-lt+1);
		}
		return answer;
	}

}
