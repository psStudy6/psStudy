package week3.yumi;

import java.util.Scanner;

/** 인프런 2-2 보이는 학생
 * 
 * 문제 간단 설명 : 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에서 보이는 학생수 
*/
public class IjC202 {
	static int solution(int[] hArr) {
		int bs = hArr[0];
		int cnt = 1;
		
		for (int i = 1; i < hArr.length; i++) {
			if (bs >= hArr[i]) {
				continue;
			}
			bs = hArr[i];
			cnt++;
		}
		return cnt;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] hArr = new int[n];
		int i = 0;
		while (sc.hasNextInt()) {
			hArr[i] = sc.nextInt();
			i++;
		}
		System.out.println(solution(hArr));
	}
}
