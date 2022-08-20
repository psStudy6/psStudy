package week4.yumi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/** 인프런 2-8 등수구하기
 * 
 * 문제 : N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램
 * 		즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등
 * 
 * 핵심 : indexOf 사용
*/
public class IjC208 {
	
	// 방법 1 : list 2개, indexOf 사용
	public String solution(List<Integer> scoreli) {
		StringBuffer sb = new StringBuffer();
		List<Integer> li = new ArrayList<Integer>();
		// 리스트 복사
		li.addAll(scoreli);
		// 점수 내림차순으로 정렬
		Collections.sort(scoreli, Collections.reverseOrder());
		
		for (int i = 0; i < li.size(); i++) {
			// 학생의 점수가 몇 번째 순위인지 확인
			// indexOf() = 값이 있는 첫 번째 인덱스 가져옴 
			sb.append(scoreli.indexOf(li.get(i))+1).append(" ");
		}
		return sb.toString();
	}
	
	public static void main1(String[] args) {
		IjC208 ijC = new IjC208();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> scoreli = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			scoreli.add(sc.nextInt());
		}
		sc.close();
		System.out.println(ijC.solution(scoreli));
	}
	
	
	
	// 방법 2 이중 for문
	public String solution(int[] arr) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			int cnt = 1;
			// 등수 구하기
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] > arr[i]) {
					cnt++;
				}
			}
			sb.append(cnt).append(" ");
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		IjC208 ijC = new IjC208();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(ijC.solution(arr));
	}
}
