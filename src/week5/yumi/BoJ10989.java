package week5.yumi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

/** 백준 10989 수 정렬하기 3
 * 브론즈 1
 * 
 * 문제 : N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램
 * 
 * 핵심 : Arrays.sort() 
 * 			정렬방식  - DualPivotQuicksort
 * 			시간복잡도 - 평균 : O(nlog(n)) / 최악 : O(n^2)
 * 		
 * 		Collections.sort()
 * 			정렬방식  - TimeSort (삽입정렬과 합병정렬을 결합한 정렬)
 * 			시간복잡도 - 평균, 최악 : O(nlog(n))
 * 
 * 		출처: https://laugh4mile.tistory.com/175
 * 			https://d2.naver.com/helloworld/0315536
*/
public class BoJ10989 {
	
	public String solution(int[] arr) {
		StringBuffer sb = new StringBuffer();
		// Collections.sort() 사용 시 시간 초과
		Arrays.sort(arr);
		for(int num : arr) {
		    sb.append(num).append("\n");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		BoJ10989 boJ = new BoJ10989();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
    	int[] arr = new int[n];        
    	for(int i=0; i<n; i++) {
    	    arr[i] = Integer.parseInt(br.readLine());
		}
    	br.close();
		System.out.println(boJ.solution(arr));
	}
}
