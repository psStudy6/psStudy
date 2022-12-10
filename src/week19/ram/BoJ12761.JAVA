import java.io.*;
import java.util.*;

public class BoJ12761 {
    
    // 전역 변수 설정
	static int[] list;
	static int[] answer;
	static int cnt;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		list = new int[M + 1];
		answer = new int[100001];

		bfs(A, B, N, M, list, answer);

	}

	private static void bfs(int A, int B, int N, int M, int[] list, int[] answer) {

		Queue<Integer> q = new LinkedList<>();

		q.add(N);

		int[] move = { 1, -1, -A, A, -B, B};
		int[] jump = {A, B};
		cnt = 0;
		
		while (!q.isEmpty()) {

			int size = q.size();

			for (int k = 0; k < size; k++) {

				int now = q.poll();
                
                // 6방향 탐색
				for (int i = 0; i < 6; i++) {

					int next = now + move[i];

					if (next < 0 || next >= 100001) {
						continue;
					}

					if (answer[next] != 0) {
						continue;
					}
					
					if (next == M) {
						System.out.println(cnt + 1);
						return;
					}
					answer[next] = answer[now] + 1;
					q.add(next);

				}
				
                // 나머지 2방향 탐색
				for (int i = 0; i < 2; i++) {

					int next = now * jump[i];

					if (next < 0 || next >= 100001) {
						continue;
					}

					if (answer[next] != 0) {
						continue;
					}
					
					if (next == M) {
						System.out.println(cnt + 1);
						return;
					}
					answer[next] = answer[now] + 1;
					q.add(next);

				}


			}
			cnt++;

		}

	}

}
