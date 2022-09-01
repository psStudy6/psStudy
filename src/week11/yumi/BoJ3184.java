package week11.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/** 백준 3184 양
 * 실버1
 * 
 * 문제 : 마당은 행과 열로 이루어진 직사각형 모양이다. 
 * 		글자 '.' (점)은 빈 필드를 의미하며, 글자 '#'는 울타리를, 'o'는 양, 'v'는 늑대를 의미한다.
 * 		한 칸에서 수평, 수직만으로 이동하며 울타리를 지나지 않고 다른 칸으로 이동할 수 있다면, 두 칸은 같은 영역 안에 속해 있다고 한다. 
 * 		영역 안의 양의 수가 늑대의 수보다 많다면 이기고, 늑대를 우리에서 쫓아낸다. 
 * 		그렇지 않다면 늑대가 그 지역 안의 모든 양을 먹는다.
 * 		아침이 도달했을 때 살아남은 양과 늑대의 수를 출력하는 프로그램을 작성
 * 
 * 핵심 : 방문한 적이 없고 늑대 또는 양이 있는 필드만 깊이 우선 탐색함
 * 		양 > 늑대 : 양
 * 		양 <= 늑대 : 늑대
*/
public class BoJ3184 {
	
	public static int[][] postArr = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
	public static char[][] arr;
	public static boolean[][] visited;
	public static int m, n, oCnt, vCnt;
	
	public String solution() {
		int o = 0, v = 0;
		for (int x = 0; x < m; x++) {
			for (int y = 0; y < n; y++) {
				oCnt = 0;
				vCnt = 0;
				// 방문한 적이 없고 늑대 또는 양이 있는 필드만 탐색함
				if (visited[x][y] || (arr[x][y] != 'o' && arr[x][y] != 'v') ) {
					continue;	
				}
				// 깊이 탐색
				dfs(x, y);
				// 양 > 늑대 : 양
				// 양 <= 늑대 : 늑대
 				if (oCnt > vCnt) {
					o += oCnt;
				} else {
					v += vCnt;
				}
			}
		}
		return o + " " + v;
	}
	
	public void dfs(int posX, int posY) {
		// 방문 체크
		visited[posX][posY] = true;
		// 양 또는 늑대일 경우 수 증가
		if(arr[posX][posY] == 'o') {
			oCnt++;
		} else if (arr[posX][posY] == 'v') {
			vCnt++;
		}
		// 필드의 우하좌상 순으로 탐색 
		for (int i = 0; i < postArr.length; i++) {
			int moveX = posX + postArr[i][0];
			int moveY = posY + postArr[i][1];
			// 범위가 아닐 시 탐색 안 함
			if (!isRange(moveX, moveY)) {
				continue;
			}
			dfs(moveX, moveY);
		}
	}
	
	public boolean isRange(int posX, int posY) {
		// 범위가 아닌 경우 리턴
		if (posX < 0 || posX >= m || posY < 0 || posY >= n) {
			return false;
		}
		// 울타리이거나 이미 탐색한 경우 리턴
		if (arr[posX][posY] == '#' || visited[posX][posY]) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BoJ3184 boj = new BoJ3184();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new char[m][n];
		visited = new boolean[m][n];
		// 세팅
		for (int i = 0; i < m; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		// 출력
		System.out.println(boj.solution());
	}
}
