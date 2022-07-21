package week5.yumi;

import java.util.Scanner;

/** 인프런 3-1 두 배열 합치기
 * 
 * 문제 : 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램
 * 
 * 핵심 : 한 배열의 길이를 넘어갈 경우 다른 배열의 값들은 항상 크다 
*/
public class IjC301 {
	
	public String solution(int n, int m, int[] arr, int[] arr2) {
		StringBuffer sb = new StringBuffer();
		int i = 0, j = 0;
		// 한 배열의 길이를 넘어갈 경우 다른 배열의 값들은 항상 크다 
		while (i < n && j < m) {
			if (arr[i] < arr2[j]) {
				sb.append(arr[i++]).append(" ");
			} else {
				sb.append(arr2[j++]).append(" ");
			}
		}
		while (i < n) {
			sb.append(arr[i++]).append(" ");
		}
		while (j < m) {
			sb.append(arr2[j++]).append(" ");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		IjC301 ijC = new IjC301();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		int[] arr2 = new int[m];
		for (int i = 0; i < m; i++) {
			arr2[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(ijC.solution(n, m, arr, arr2));
	}
}
