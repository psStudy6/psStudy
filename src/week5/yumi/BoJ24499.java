package week5.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 백준 24499 blobyum
 * 실버4
 * 
 * 문제 : N개의 애플파이를 만들었으며, 이를 원 모양으로 책상에 배치해 놓았다.
 * 		각 애플파이는 하나의 양의 정수로 표현되며, 이는 맛있는 정도를 의미한다. (수가 클수록 더 맛있는 애플파이이다.)
 * 		블롭은 N개의 애플파이 중 K개를 먹으려고 한다. 연속으로 배치되어 있는 K개의 애플파이를 먹으려 한다.
 * 		블롭이 먹을 애플파이의 맛의 합의 최댓값
 * 
 * 핵심 : sliding window 문제
 * 		i부터 K개의 합을 구함 
 * 		i=0 : arr[0]+arr[1]+..+arr[i+k-1] 
 * 		i=1 : 		 arr[1]+..+arr[(i-1)+k-1]+arr[i+k-1]
 * 		1칸씩 구간을 이동하며 맨앞, 맨뒤를 제외한 구간은 공통된 값임
 * 		i부터 K개의 합 = i-1부터 K개의 합 - 맨앞(i-1) + 맨뒤(i+k-1)
*/
public class BoJ24499 {
	
	public int solution(int n, int k, int[] arr) {
		int max = 0, preSum = 0, sum = 0, idx = 0;
		// 최초 1회 합계 구함
		// i=0 ~ k 개의 합
		for (int i = 0; i < k; i++) {
			preSum += arr[i];
			max = preSum;
		}
		for (int i = 1; i < n; i++) {
			idx = i+k-1; // 맨뒤
			if(i+k > n) {
				idx-=n; // 인덱스 넘어갈 시 처리
			}
			// i부터 K개의 합 = i-1부터 K개의 합 - 맨앞(i-1) + 맨뒤(i+k-1)
			sum = preSum - arr[i-1] + arr[idx];
			preSum = sum;
			if (max < sum) {
				max = sum;
			}
		}
		return max;
	}
	
	public static void main(String[] args) throws IOException {
		BoJ24499 boJ = new BoJ24499();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(boJ.solution(n, k, arr));
	}
}
