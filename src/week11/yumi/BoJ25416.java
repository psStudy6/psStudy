package week11.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//위치 정보
class PosB {
	int x;
	int y;
	int cnt;
	
	public PosB(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

public class BoJ25416 {
	public static int[][] posArr = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static int[][] arr;
	public static boolean[][] visited;
	public static int n = 5;
	
	public int solution(int startX, int startY) {
		Queue<PosB> que = new LinkedList<>();
		// 주어진 시작점에서 시작
		que.offer(new PosB(startX, startY, 0));
	    visited[startX][startY] = true;
	    
		while (!que.isEmpty()){
			PosB pos = que.poll();
			int posX = pos.x;
			int posY = pos.y;
			// 1에 도착하면 최솟값 츨력
			if (arr[posX][posY] == 1) {
				return pos.cnt;
			}
			// 각 칸은 벽(-1)을 제외한 인접한 상하좌우 칸으로 이동 가능 
			for (int i = 0; i < posArr.length; i++) {
				int movePosX = posX + posArr[i][0];
				int movePosY = posY + posArr[i][1];
				// 범위 벗어날 시
				if (!isRange(movePosX, movePosY)) {
					continue;
				}
				// 방문 표시 및 que 추가
	            visited[movePosX][movePosY] = true;
				que.offer(new PosB(movePosX, movePosY, pos.cnt + 1));
			}
		}
		// 1에 도달할 방법 없을 시
		return -1;
	} 
	
	// 범위 체크
	public boolean isRange(int posX, int posY) {
		// 필드 외 영역 제외
		if (posX < 0 || posX >= n || posY < 0 || posY >= n) {
			return false;
		}
		// 벽 또는 방문한 곳일 경우 제외
		if (arr[posX][posY] == -1 || visited[posX][posY]){
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BoJ25416 boj = new BoJ25416();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[n][n];
		visited = new boolean[n][n];
		for (int x = 0; x < n; x++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int y = 0; y < n; y++) {
				arr[x][y] = Integer.parseInt(st.nextToken());
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int startX = Integer.parseInt(st.nextToken());
		int startY = Integer.parseInt(st.nextToken());
		
		System.out.println(boj.solution(startX, startY));
	}
}
