package week5.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 인프런 2-11 임시반장 정하기
 * 
 * 문제 : 1학년부터 5학년까지 지내오면서 한번이라도 같은 반이었던 사람이 가장 많은 학생을 임시 반장으로 정하려 한다.
 * 		각 학생들이 1학년부터 5학년까지 속했던 반이 주어질 때, 임시 반장을 정하는 프로그램
 * 
 * 핵심 : -
*/
public class IjC211 {
	
	public int solution(int n, int[][] arr) {
		int maxCnt = 0;
		int maxIdx = 0; 
		
		for (int student = 0; student < n; student++) {
			int cnt = 0;
			// 한 번이라도 같은 반이었던 친구
			for (int otStudent = 0; otStudent < n; otStudent++) {
				for (int grade = 0; grade < 5; grade++) {
					if (student == otStudent) {
						continue;
					}
					// 겹쳤으므로 break
					if (arr[student][grade] == arr[otStudent][grade]) {
						cnt++;
						break;
					}
				}
			}
			if (maxCnt < cnt) {
				maxCnt = cnt;
				maxIdx = student;
			}
		}
		return maxIdx + 1;
	}
	
	
	public static void main(String[] args) throws IOException {
		IjC211 ijC = new IjC211();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][5];
		
		for (int i = 0; i < arr.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		System.out.println(ijC.solution(n, arr));
	}
}
