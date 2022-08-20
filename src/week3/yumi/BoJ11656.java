package week3.yumi;

import java.util.Arrays;
import java.util.Scanner;

/** 백준 11656 접미사 배열
 * 실버4
 * 
 * 문제 : 접미사 배열은 문자열 S의 모든 접미사를 사전순으로 정렬해 놓은 배열이다
 * 		문자열 S가 주어졌을 때, 모든 접미사를 사전순으로 정렬한 다음 출력
 * 
 * 핵심 : substring(), Arrays.sort()
*/
public class BoJ11656 {
	// 방법 1 : 배열 사용
	public String solution(String str) {
		StringBuffer sb = new StringBuffer();
		String[] arr = new String[str.length()];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.substring(i);
		}
		Arrays.sort(arr);
		
		for (String sffix : arr) {
			sb.append(sffix).append("\n");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		BoJ11656 boJ = new BoJ11656();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		System.out.println(boJ.solution(str));
	}
}
