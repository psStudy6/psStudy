package week7.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** 백준 2667 단지 번호 붙이기
 * 실버1
 * 
 * 문제 : 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 
 * 		철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 
 * 		여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 
 * 		대각선상에 집이 있는 경우는 연결된 것이 아니다. 
 * 		<그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 
 * 		지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램
 * 
 * 핵심 : dfs로 가구를 상하좌우 체크하면서 연결된 가구 확인
*/
public class BoJ2667 {
	static int[][] pos = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 우하좌상
	static int[][] arr;
	static boolean[][] visit;
	
	public int dfs(int y, int x, int cnt) {
		// 오른쪽 - 아래 - 왼쪽 - 위 순으로 검색
		for (int p = 0; p < pos.length; p++) {
			int px = x + pos[p][1];
			int py = y + pos[p][0];
			// 범위 확인
			if(px < 0 || px >= arr.length || py < 0 || py >= arr.length) {
				continue;
			}
			// 방문한 곳은 검색 안 함
			if (visit[py][px] == true) {
				continue;
			}
			visit[py][px] = true; // 방문 체크
			// 0은 검색 안 함
			if (arr[py][px] == 0) {
				continue;
			}
			// 가구수
			cnt = dfs(py, px, cnt) + 1;
		}
		return cnt;
	}
	
	public List<Integer> solution() {
		List<Integer> list = new ArrayList<Integer>();
		
		for (int y = 0; y < arr.length; y++) {
			for (int x = 0; x < arr.length; x++) {
				// 방문한 곳은 검색 안 함
				if (visit[y][x] == true) {
					continue;
				}
				visit[y][x] = true; // 방문 체크
				// 0은 검색 안 함
				if (arr[y][x] == 0) {
					continue;
				}
				// 단지를 찾으면 가구수 저장
				list.add(dfs(y, x, 1));
			}
		}
		return list;
	}
	
	public static void main(String[] args) throws IOException {
		BoJ2667 boj = new BoJ2667();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visit = new boolean[n][n];
		
		for (int i = 0; i < arr.length; i++) {
			String str = br.readLine();
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}
		StringBuffer sb = new StringBuffer();
		List<Integer> list = boj.solution();
		Collections.sort(list);
		sb.append(list.size()).append("\n");
		for (Integer cnt : list) {
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
