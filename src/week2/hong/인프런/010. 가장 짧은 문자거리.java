/**
 * 문제 제목 : 010. 가장 짧은 문자거리
 * 강의 시청 : ✔️
 */

// 강의를 보기전 내 방식 -> ✔️(Success)
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Main M = new Main();
		Scanner in = new Scanner(System.in);

		String str = in.next();
		char c = in.next().charAt(0);
		for (int x : M.solution(str, c)) {
			System.out.print(x + " ");
		}
		in.close();
	}

	public int[] solution(String str, char c) {
		int[] answer = new int[str.length()];
		int dex = 0;

		// Checkpoint1. 첫번째 문자(e)와 배열 위치 정의
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == c) {
				dex = 0;
				answer[i] = dex;
			} else {
				dex++;
				answer[i] = dex;
			}
		}

		// CheckPoint2. 첫번째 이후 문자(e)의 배열 위치 정의
		dex = 0;
		for (int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) == c) {
				dex = 0;
			} else {
				dex++;
				// CheckPoint3. 첫번째 문자(e)와 배열 위치가 더 가까운 것으로 변경
				answer[i] = Math.min(answer[i], dex);
			}
		}
		return answer;
	}
}

// 강의 내용
package defaultMain;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Main2 M = new Main2();
		Scanner kb = new Scanner(System.in);

		String str = kb.next();
		char c= kb.next().charAt(0);
		for(int x : M.solution(str, c) ) {
			System.out.print(x + " ");
		}
		kb.close();
	}

	public int[] solution(String str, char c) {
		int[] answer = new int[str.length()];
		int p = 1000;
		for(int i=0; i< str.length(); i++) {
			if(str.charAt(i) == c) {
				p=0;
				answer[i]=p;
			}
			else {
				p++;
				answer[i]=p;
			}
		}
		p = 1000;
		for(int i=str.length()-1; i>=0; i--) {
			if(str.charAt(i) == c) {
				p=0;
			}
			else {
				p++;
				answer[i]= Math.min(answer[i], p);
			}
		}

		return answer;
	}
}
