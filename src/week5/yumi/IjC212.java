package week5.yumi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 인프런 2-12 멘토링
 * 
 * 문제 : 만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면, A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 합니다.
 * 		M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지 인지 출력하는 프로그램
 * 
 * 핵심 : -
*/
public class IjC212 {
	
	// 방법 2 : arr 사용 182ms 27MB
	public int solution(int n, int t, int[][] arr) {
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				int cnt = 0;
				// 테스트
				for (int k = 0; k < t; k++) {
					int pi = 0, pj = 0;
					// 등수 확인
					for (int s = 0; s < n; s++) {
						if (arr[k][s] == i) pi = s;
						if (arr[k][s] == j) pj = s;
					}
					// 등수 비교
					if (pi < pj) cnt++;
				}
				// 모든 시험에서 등수가 높았을 때
				if (cnt == t) {
					answer++;
				}
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		IjC212 ijC = new IjC212();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = sc.nextInt();
		int[][] arr = new int[t][n];
		for (int i = 0; i < t; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.println(ijC.solution(n, t, arr));
	}
	
	// 방법 1 : list 사용 183ms 27MB
	public int solution1(int n, int t, List<List<Integer>> list) {
		int cnt = 0;
		for (int student = 1; student <= n; student++) {
			for (int otStudent = 1; otStudent <= n; otStudent++) {
				if (student == otStudent) {
					continue;
				}
				boolean flag = true;
				for (int test = 0; test < t; test++) {
					List<Integer> li = list.get(test);
					if (li.indexOf(student) > li.indexOf(otStudent)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static void main1(String[] args) {
		IjC212 ijC = new IjC212();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = sc.nextInt();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < t; i++) {
			List<Integer> tmp = new ArrayList<Integer>();
			for (int j = 0; j < n; j++) {
				tmp.add(sc.nextInt());
			}
			list.add(tmp);
		}
		sc.close();
		System.out.println(ijC.solution1(n, t, list));
	}
}
