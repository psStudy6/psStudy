package week9.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/** 인프런 6-3 삽입 정렬
 * 
 * 문제 : N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램
 * 
 * 핵심 : 삽입정렬
*/
public class IjC603 {
	public void insertionSort(int arr[]) {
		int j, tmp;
		for (int i = 1; i < arr.length; i++) {
			tmp = arr[i];
			j = i;
			while (j > 0 && arr[j-1] > tmp) {
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = tmp;
		}
	}
	
	public static void main(String[] args) throws IOException {
		IjC603 ijc = new IjC603();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		ijc.insertionSort(arr);
		
		StringBuffer sb = new StringBuffer();
		for (int num : arr) {
			sb.append(num).append(" ");
		}
		System.out.println(sb);
	}
}
