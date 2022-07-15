package week4.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

/** 백준 2477 참외밭
 * 
 * 문제 : 동쪽은 1, 서쪽은 2, 남쪽은 3, 북쪽은 4로 나타낸다.
 * 		1m2의 넓이에 자라는 참외의 개수와, 참외밭을 이루는 육각형의 임의의 한 꼭짓점에서 출발하여 반시계방향으로 둘레를 돌면서 지나는 변의 방향과 길이가 순서대로 주어진다. 
 * 		이 참외밭에서 자라는 참외의 수를 구하는 프로그램
 * 
 * 풀이 : 육각형 = 큰 사각형에 작은 사각형이 빠진 형태
 * 		작은 사각형의 가로 길이 = 큰 사각형의 세로 길의 양옆 가로 길이의 차
*/
public class BoJ2477 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		int arr[] = new int[6];
		int maxX = 0, maxY = 0;
		int maxXIdx = -1, maxYIdx = -1;
		int answer = 0;
		
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			arr[i] = len;
			
			// 가로 쵀댓값
			if (dir == 1 || dir == 2) {
				maxX = Math.max(maxX, len);
				if (maxX == len) {
					maxXIdx = i;
				}
				continue;
			}
			// 세로 쵀댓값
			maxY = Math.max(maxY, len);
			if (maxY == len) {
				maxYIdx = i;
			}
		}
		// 가장 넓은 가로의 양 옆 세로
		int preX = arr[maxXIdx==0? 5 : maxXIdx-1];
		int aftX = arr[maxXIdx==5? 0 : maxXIdx+1];
		// 가장 넓은 세로의 양 옆 가로
		int preY = arr[maxYIdx==0? 5 : maxYIdx-1];
		int aftY = arr[maxYIdx==5? 0 : maxYIdx+1];
		
		// 큰사각형 넓이(가장 긴 가로 * 가장 긴 세로)
		answer += maxX * maxY;
		// 작은 사각형 넓이 빼기(가장 긴 세로의 양 옆 가로 길의 차 * 가장 긴 가로의 양 옆 세로 길의 차)
		answer -= Math.abs(preX-aftX) * Math.abs(preY-aftY);
		// 넓이 * 참외개수
		System.out.println(answer*t);
	}
}
