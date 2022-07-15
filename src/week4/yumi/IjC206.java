package week4.yumi;

import java.util.Scanner;

/** 인프런 2-6 뒤집은 소수
 * 
 * 문제 : N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램
 * 		N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램
 * 
 * 핵심 : 숫자 뒤집기 = 10씩 끊기
 * 		소수 = 다른 수의 배수가 아님 = 수/2 이하의 수만 확인 해보면 됨
*/
public class IjC206 {
	
	public String solution(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			int revNum = reverseNum(arr[i]);
			// 1은 소수 아님
			if (revNum == 1) {
				continue;
			}
			if (isPrimeNum(revNum)) {
				sb.append(revNum).append(" ");
			}
		}
		return sb.toString();
	}
	
	// 숫자 뒤집기
	public int reverseNum(int num) {
		int revNum = 0;
		// 10으로 끊어서 뒤집기
		while (num > 0) {
			revNum = revNum*10 + num%10;
			num /= 10;
		}
		return revNum;
	}
	
	// 소수 여부
	public boolean isPrimeNum(int revNum) {
		int[] numArr = new int[revNum];
		for (int i = 2; i < numArr.length/2+1; i++) {
			if (revNum%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		IjC206 ijC = new IjC206();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] arr = new int[t];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(ijC.solution(arr));
	}
}
