package week7.ram;
import java.util.*;
import java.io.*;
public class BoJ1260 {
/* DFS와 BFS
 * 각각 방법으로 출력
 * 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고
 * 더이상 방문할 수 있는 점이 없는 경우 종료한다.
 * 정점 번호는 1번부터 N번까지이다.
 */
	public static void dfs(ArrayList<ArrayList<Integer>> arr,boolean[] check,int v) {
		if(check[v] == true)return;//방문한 적이 있으면 메소드 종료
		
		check[v]=true;//방문한 적 없는 정점이라면 방문처리
		System.out.print(v+" ");//방문했기 때문에 정점 출력
		
		/* 바깥쪽 ArrayList의 index인 정점과 연결된 정점을 탐색 */
		for(int i=0;i<arr.get(v).size();i++) {
			if(!check[arr.get(v).get(i)])//연결된 정점이 방문한 적 없다면
				dfs(arr,check,arr.get(v).get(i));//재귀호출로 깊이 우선 탐색 실행
		}
	}
	public static void bfs(ArrayList<ArrayList<Integer>> arr,boolean[] check,int v) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(v);
		check[v] = true;//방문처리를 한다.
		
		while(!q.isEmpty()) {//큐가 빌 때까지 반복
			v=q.poll();
			System.out.print(v+" ");
			
			//바깥쪽 ArrayList의 인덱스인 정점과 연결된 정점을 탐색해 모두 큐에 삽입
			for(int i=0;i<arr.get(v).size();i++) {
				if(!check[arr.get(v).get(i)]) {//방문하지않았던 정점이라면
					q.add(arr.get(v).get(i));
					check[arr.get(v).get(i)] = true;//해당 정점을 방문 처리한다.
					
				}
			}
			
		}
	}
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());//정점의 개수
		int M = Integer.parseInt(st.nextToken());//간선의 개수
		int V = Integer.parseInt(st.nextToken());//탐색을 시작할 정점의 번호
		
		/* 2차원 ArrayList 인접리스트 구현 */
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		
		//각 정점 방문 여부를 판단 할 배열
		boolean check[] = new boolean[N+1];
		
		/* ArrayList 객체 안에 요소로써 ArrayList 객체를 생성
		 * 인덱스와 들어갈 요소의 수를 일치시키기 위해 0~N까지 선언하는 것
		 */
		for(int i=0;i<=N;i++) {
			arr.add(new ArrayList<Integer>());
		}
		
		/* 정점의 연결 정보를 입력 
		 * get 함수 : Object 의 index를 참소하여 해당 data를 가져온다.
		 */
		for(int i=0;i<M;i++) { //M번(간선의 개수)만큼 for문 돌림,간선의 개수 = 연결횟수와 같다
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			arr.get(v1).add(v2);
			arr.get(v2).add(v1);
		}
		//System.out.println(arr);
		/* 이동 경우의 수가 다수 존재할 경우 작은 정점부터 이동해야 하므로 인접 리스트를 오름차순 정렬 
		 * 2차원 배열 내부를 정렬하는 것
		 */
		for(int i=1;i<=N;i++) {
			Collections.sort(arr.get(i));
		}
		//System.out.println(arr);
		dfs(arr,check,V);
		Arrays.fill(check,false); //방문여부 배열을 BFS때문에 다시 false로 초기호
		System.out.println();
		bfs(arr,check,V);
	}

}
