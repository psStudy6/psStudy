package week13.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/** 백준 1026 보물
 * 실버4
 * 
 * 문제 : 길이가 N인 정수 배열 A와 B가 있다. 다음과 같이 함수 S를 정의하자.
 * 		S = A[0] × B[0] + ... + A[N-1] × B[N-1]
 * 		S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자. 단, B에 있는 수는 재배열하면 안 된다.
 * 		S의 최솟값을 출력하는 프로그램을 작성
 * 
 * 핵심 : PriorityQueue 이용하여 최댓값 가져옴.
 * 		- 사실 b배열 정렬하면 안된다고 하지만 정렬해도 문제 없음
*/
public class BoJ1026 {
	
	public int solution(int[] aArr, PriorityQueue<Integer> bPQ) {
		Arrays.sort(aArr);
		int sum = 0;
		for (int i = 0; i < aArr.length; i++) {
			int bNum = bPQ.poll();
			// a최솟값 * b최대값
			sum += aArr[i] * bNum; 
		}
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		BoJ1026 boj = new BoJ1026();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] aArr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			aArr[i] = Integer.parseInt(st.nextToken());
		}
		PriorityQueue<Integer> bPQ = new PriorityQueue<>(Collections.reverseOrder());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			bPQ.add(num);
		}
		System.out.println(boj.solution(aArr, bPQ));
	}
}
