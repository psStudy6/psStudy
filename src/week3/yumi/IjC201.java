package week3.yumi;

import java.util.Scanner;

/** 인프런 2-1 큰 수 출력하기
 * 
 * 문제 간단 설명 : N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력 (첫 번째 수는 무조건 출력한다)
*/
public class IjC201 {
	private static String solution(int n, String[] strArr) {
		StringBuilder sb = new StringBuilder();
		sb.append(strArr[0]);
		for (int i = 1; i < strArr.length; i++) {
			if (Integer.parseInt(strArr[i-1]) < Integer.parseInt(strArr[i])) {
				sb.append(" ").append(Integer.parseInt(strArr[i]));
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String[] strArr = sc.nextLine().split(" ");
		System.out.println(solution(n, strArr));
	}
}
