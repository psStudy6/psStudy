package week12.hong;

/**
 * 등록 번호 : 1325번
 * 등록 제목 : 효율적인 해킹
 * 현재 상태 : 성공 ✔️
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1325 {
	public static List<Integer>[] list;
	public static int[] cnt;
	public static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[n+1];

		for(int i=0;i<=N;i++){
			list[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int O = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			list[O].add(T);

		}

		cnt = new int[N+1];
		for(int i=1;i<=N;i++){ bfs(i); }

		ArrayList<Integer> ans = new ArrayList<>();
		int max_value = 0;
		for(int i=1;i<=N;i++){
			if(cnt[i] > max_value){
				max_value = cnt[i];
				ans.clear();
				ans.add(i);
			} else if (cnt[i] == max_value){
				ans.add(i);
			}
		}

		for(int O:ans){ System.out.print(O+" "); }
	}

	public static void bfs(int start){
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		visited[start] = true;
		q.offer(start);

		while (!q.isEmpty()) {
			int x = q.poll();
			for (int num : list[x]) {
				if (!visited[num]) {
					cnt[num]++;
					visited[num] = true;
					q.offer(num);
				}
			}
		}
	}
}
