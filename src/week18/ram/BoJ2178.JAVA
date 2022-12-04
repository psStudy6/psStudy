package week18.ram;
import java.util.*;
import java.io.*;
//16772KB	188ms
class point{
	int x;
	int y;
	point(int x,int y){
		this.x = x;
		this.y = y;
	}
	
}
public class BoJ2178 {
	static int N,M;
	static int[][] miroh;
	static int[][] visited;
	static int[][] d = {{1,0},{0,1},{-1,0},{0,-1}};

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N=Integer.parseInt(input[0]);
		M=Integer.parseInt(input[1]);
		
		miroh = new int[N][M];
		visited = new int[N][M];
		
		for(int i=0;i<N;i++) {
			input = br.readLine().split("");
			for(int j=0;j<M;j++) {
				miroh[i][j]=Integer.parseInt(input[j]);
			}
		}
		System.out.println(bfs(0,0));
		

	}
	static int bfs(int cx,int cy) {
		
		Queue<point> q = new LinkedList<>();
		q.offer(new point(cx,cy));
		
		visited[0][0]=1;
		while(!q.isEmpty()) {
			point p = q.poll();
			cx = p.x;
			cy = p.y;
			for(int i=0;i<4;i++) {
				int mx = cx+d[i][0];
				int my = cy+d[i][1];
				
				if(mx>=0&&mx<N&&my>=0&&my<M) {
					if(visited[mx][my]==0&&miroh[mx][my]==1) {
						
						visited[mx][my]=visited[cx][cy]+1;
						q.add(new point(mx,my));
						
					}
				}
			}
		}
		return visited[N-1][M-1];
	
		
	}

}
