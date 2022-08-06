package week7.ram;
import java.util.*;
import java.io.*;
/* 트리의 부모 찾기
 * 루트가 없는 트리가 주어진다. 이때 트리의 루트를 1이라고 정했을 때 각 노드의 부모를 구하는 프로그램을 작성
 * 
 */
public class BoJ11725 {
	static ArrayList<Integer>[] graph;
	static int[] parents;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //노드의 개수
		
		
		/* 인접리스트 */
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();//이중 어레이리스트
		int[] parents = new int[N+1];
		for(int i=0;i<=N+1;i++) list.add(new ArrayList<Integer>());
		
		/* 연결 설정 */
		
		for(int i=1;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		/* bfs 알고리즘 */
		int start = 1;
		bfs(start,list,parents,N);
		
		/* 결과출력 */
		for(int i=2;i<parents.length;i++) System.out.println(parents[i]);

	
	
	

}

private static void bfs(int start,ArrayList<ArrayList<Integer>> list,int[] parents,int n) {
	LinkedList<Integer> queue = new LinkedList<Integer>();
	queue.offer(start);
	parents[start]=1;
	
	while(!queue.isEmpty()) {
		int parent = queue.poll();
		
		for(int item : list.get(parent)) {
			if(parents[item] == 0) {
				parents[item] = parent;
				queue.offer(item);
			}
		}
	}
}
}

