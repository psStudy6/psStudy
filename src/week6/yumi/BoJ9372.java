package week6.yumi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** 백준 9372 상근이의 여행
 * 실버4
 * 
 * 문제 : 가장 적은 종류의 비행기를 타고 모든 국가들을 여행할 수 있도록 도와주자.
 * 		상근이가 한 국가에서 다른 국가로 이동할 때 다른 국가를 거쳐 가도(심지어 이미 방문한 국가라도) 된다.
*/
public class BoJ9372 {
	static int[][] plane;
	static boolean[] visit;
	static int country, airplane, result;

	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		visit[1] = true;
		while (!queue.isEmpty()) {
			result++;
			int value = queue.poll();
			for (int i = 1; i <= country; i++) {
				if (plane[value][i] != 0 && !visit[i]) {
					visit[i] = true;
					queue.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			country = Integer.parseInt(st.nextToken());
			airplane = Integer.parseInt(st.nextToken());
			result = 0;
			plane = new int[country + 1][country + 1];
			visit = new boolean[country + 1];

			for (int i = 0; i < airplane; i++) {
				st = new StringTokenizer(br.readLine());
				int fromAir = Integer.parseInt(st.nextToken());
				int toAir = Integer.parseInt(st.nextToken());

				plane[fromAir][toAir] = 1;
				plane[toAir][fromAir] = 1;
			}
			bfs();
			bw.write(result - 1 + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
