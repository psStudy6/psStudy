package week6.soram;
import java.util.*;
import java.io.*;
/*나무 탈출
N개의 정점이 있는 트리 모양
1번 = 루트
자식x = 리프 노드
성원 WIN(총합 홀수) => return Yes
DFS 이용 : 모든 말(리프노드)들이 루트노드로 가는 경로비용의 총합 구하기

*/
public class BoJ15900 {
	
	static List<Integer>[] graph;//메소드에서도 사용하기 위해 정적 변수로 선언
	static int count = 0;
	static boolean[] visited = new boolean[500001];
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		graph = new ArrayList[n+1];
		
		
		
		for(int i=0;i<=n;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<n-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			graph[e].add(s);
			graph[s].add(e);
		}
		
		dfs(1,0);
		
		if(count%2 != 0) {
			System.out.println("Yes");
		}
		else System.out.println("No");
		
		
	}
	public static void dfs(int node,int depth) {
		if(node != 1 && graph[node].size() == 1) {
			if(depth % 2 ==1) count++;
			return;
		
	}
		for(Integer now : graph[node]) {
			if(!visited[node]) {
				visited[node]=true;
				dfs(now,depth+1);
				visited[node]=false;
			}
		}
	}


}


