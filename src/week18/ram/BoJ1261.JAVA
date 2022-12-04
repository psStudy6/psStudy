package week18.ram;
import java.util.*;
import java.io.*;
/* 알고스팟
 * (0,0)->종점까지 1인 벽을 몇개 부숴야하는지 구하자
 * BfS/DFS vs 다익스트라
 * BFS/DFS:모든 노드간 가중치가 같고, 얼마나 적은 수의 노드를 거쳤는가
 * 다익스트라:노드간의 가중치가 상이하고 연결정보가 따로주어지고,얼마나 적은 가중치의 합으로 목적지에 도달하였는가
 * 가중치가 0 OR 1이므로 다익스트라 문제로 풀어야한다.
 * 우선순위 큐로도 풀 수 있다.
 * 벽을 최대한 적게 뚫어야한다.
 * 덱으로 품
 */

public class BoJ1261 {
	static class point {
		int x;
		int y;
		public point(int x,int y) {
			this.x=x;
			this.y=y;
		}
	}
		
	static int[][] miroh;
	static int[][] dis;
	static boolean[][] visited;
	static int[] dx= {1,0,0,-1};
	static int[] dy= {0,1,-1,0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		miroh = new int[N][M];
		dis = new int [N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			for(int j=0;j<M;j++) {
				miroh[i][j]=input.charAt(j)-'0';
				//System.out.println(miroh[i][j]);
			}
			
		}
		
		System.out.println(bfs(M,N));
	}
	static int bfs(int M,int N) {
		Deque<point> deque = new LinkedList<>();
		deque.addLast(new point(0,0));
		visited[0][0]=true;
		while(!deque.isEmpty()) {
			point node = deque.pollFirst();//우선순위를 뒤로할지 앞으로할지는 꺼내는 위치를 First인지 Last인지 따라 달라진다.
			int x=node.x;
			int y=node.y;
			for(int i=0;i<4;i++) {//하나의 노드 기준으로 상하좌우 하나씩 체크
				//상하좌우 비교하기위해 변수 선언
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				//방문하지 않고 좌표의 범위안에 있으면 진행
				if(nx>=0&&ny>=0&&nx<N&&ny<M&&!visited[nx][ny]) {
					//0이면 벽이 없어 바로 갈 수 있으므로, 경로의 우선순위로 큐의 뒤에다 놓는다
					//큐를 앞에서 꺼내도록 설정했으므로
					if(miroh[nx][ny]==0) {
						dis[nx][ny]=dis[x][y];//벽을 안뚫는 경우 누적'만' 한다.
						deque.addFirst(new point(nx,ny));
					}
					else if(miroh[nx][ny]==1){//1이면 벽을 부수고 가야한다. 경로의 후순위로 큐의 앞에다가 둔다
						dis[nx][ny]=dis[x][y]+1;//벽을 뚫는 경우 누적 +1
						deque.addLast(new point(nx,ny));
					}
					visited[nx][ny]=true;
				}
				else {
					continue;
				}
				
			}
		}
		
		return dis[N-1][M-1];
	
	}
}
