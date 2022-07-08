package week3.yumi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/** 인프런 2-4 피보나치 수열
 * 
 * 문제 : 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
 * 		피보나치 수열의 총 항의 수가 주어질 때 피보나치 수열을 츌력
*/
public class IjC204 {
	// 방법 1 : list 사용 
	public static String solution(int n) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		for (int i = 2; i < n; i++) {
			list.add(list.get(i-2) + list.get(i-1));
		}
		Iterator<Integer> it = list.iterator();
		StringBuilder sb = new StringBuilder();
		while (it.hasNext()) {
			sb.append(it.next()).append(" ");
		}
		return sb.toString();
	}
	
	// 방법 2 : 배열 사용
	public static String solution2(int n) {
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[n];
		arr[0] = 1;
		arr[1] = 1;
		for (int i = 2; i < n; i++) {
			arr[i] = arr[i-2] + arr[i-1];
		}
		for (int i : arr) {
			sb.append(i).append(" ");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(solution(n));
	}
}
