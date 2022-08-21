package week9.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 인프런 6-1 선택정렬
 * 
 * 문제 : N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램
 * 
 * 핵심 : 선택정렬
*/
public class IjC601 {
	public void selectionSort(int arr[]) {
		int min;
		for (int i = 0; i < arr.length - 1; i++) {
			min = i;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
			swap(arr, min, i);
		}
	}
	
	public void swap(int[] arr, int min, int i) {
		int tmp = arr[i];
		arr[i] = arr[min];
		arr[min] = tmp;
	}
	
	public static void main(String[] args) throws IOException {
		IjC601 ijc = new IjC601();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		ijc.selectionSort(arr);
		
		StringBuffer sb = new StringBuffer();
		for (int num : arr) {
			sb.append(num).append(" ");
		}
		System.out.println(sb);
	}
}
