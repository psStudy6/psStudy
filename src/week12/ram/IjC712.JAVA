package week12.ram;
import java.util.*;
public class IjC712 {
	static int n,m,answer=0;
	static int[][] graph;
	static int[] ch;
	public void DFS(int v) {
		if(v==n) answer++;
		else {
			//1번 노드부터 n번 노드까지
			for(int i=1;i<=n;i++) {
				//graph[v][i]==1 : 현재 노드(v)에서 갈 수 있는 노드(i)들
				//ch[i]==0 : 가야할 i 노드는 방문 된 적 없어야함
				if(graph[v][i]==1&&ch[i]==0) {
					ch[i]=1;
					DFS(i);
					//윗줄 DFS(i)가 pop된 후 복귀(백트래킹) 하는 시점에서 다시 체크 풀어줌
					//->DFS(i) 가 전에 했던 일을 후에 반대로 하면 취소됨
					ch[i]=0;
				}
			}
		}
		
	}
	public static void main(String[] args) {
		IjC712 T = new IjC712();
		Scanner kb = new Scanner(System.in);
		n=kb.nextInt();
		m=kb.nextInt();
		graph=new int[n+1][n+1];
		ch=new int[n+1];
		for(int i=0;i<m;i++) {
			int a=kb.nextInt();
			int b=kb.nextInt();
			//단방향 그래프 : a->b
			graph[a][b]=1;
		
		}
		ch[1]=1;
		T.DFS(1);
		System.out.println(answer);
	
	}

}
