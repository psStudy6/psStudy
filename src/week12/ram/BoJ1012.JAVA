package week12.ram;
import java.util.*;
import java.io.*;
/* 키우는 것 : 유기농 배추
 * 해충퇴치 : 배추흰지렁이 
 */
public class BoJ1012 {

	static int M, N, K;
	static int[][] cabbage;
	static boolean[][] visit;
	static int count;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };

	static void dfs(int x, int y) {
		visit[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];

			if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
				if (!visit[cx][cy] && cabbage[cx][cy] == 1) {
					dfs(cx, cy);
				}
			}

		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			count = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			cabbage = new int[M][N];
			visit = new boolean[M][N];

			K = Integer.parseInt(st.nextToken());
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());
				cabbage[p1][p2] = 1;
			}

			for (int x = 0; x < M; x++) {
				for (int y = 0; y < N; y++) {
					if (cabbage[x][y] == 1 && !visit[x][y]) {
						dfs(x, y);
						count++;
					}
				}
			}

			System.out.println(count);
		}

	}

}
