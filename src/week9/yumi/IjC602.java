package week9.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 인프런 6-2 버블 정렬
 * 
 * 문제 : N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램
 * 
 * 핵심 : 버블정렬
*/
public class IjC602 {
	public void bubbleSort(int arr[]) {
		int tmp;
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j+1]) {
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		IjC602 ijc = new IjC602();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		ijc.bubbleSort(arr);
		
		StringBuffer sb = new StringBuffer();
		for (int num : arr) {
			sb.append(num).append(" ");
		}
		System.out.println(sb);
	}
}
