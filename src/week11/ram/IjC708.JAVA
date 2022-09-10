package week11.ram;
/* 송아지 찾기(BFS : 상태트리탐색)
 * BFS(레벨탐색)은 이진트리를 포함한 상태 트리에서
 * 주로 최단거리 알고리즘에 사용된다.
 */
import java.util.*;
import java.io.*;
public class IjC708 {
	static int answer=0;
	static int[] dis= {1,-1,5};
	static int[] ch;
	static Queue<Integer> Q = new LinkedList<>();
	static int bfs(int s,int e) {
		ch = new int[10001];
		//좌표 최대 범위만큼 배열으 크기를 잡는다
		//0번 인덱스는 사용하지 않음
		ch[s]=1;
		//출발 지점 s에 대해 방문함을 체크
		Q.offer(s);
		//방문
		int L = 0;
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i=0;i<len;i++) {
				int x = Q.poll();
				for(int j=0;j<3;j++) {
					int nx=x+dis[j];
					if(nx==e) {
						/* 답은 반드시 존재하므로(문제조건)
						 * 무조건 여기서 리턴된다
						 * L은 x의 레벨값이므로 nx의 레벨값은
						 * L+1
						 */
						return L+1;
						
					}
					if(nx>=1&&nx<=10000&&ch[nx]==0) {
						//좌표 범위 제한
						ch[nx]=1;
						Q.offer(nx);
					}
				}
			}
			L++;
		}
		//무조건 중간에 리턴되지만 반환형이 int이므로
		//문법에러 방지를 위해 임의의 수 리턴
		return 0;
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int e = sc.nextInt();
		System.out.println(bfs(s,e));
	}
	

}
