package week12.ram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* 효율적인 해킹
 * 정답률 19퍼센트인데는 이유가 있다...
 * 시간초과...
 * 주의 : A과 B를 신뢰하는 경우 B다음 A로 이동할 수 있는 것
 * 그렇다고 A에서 B로 이동 가능한 것은 아니다.
 * 단방향 그래프
 * 2차원 인접리스트의 경우 양방향 그래프가 아니므로 불필요한 메모리를 차지한다.
 * 메모리를 염두하여 1차원 배열로 문제를 접근
 */
public class BoJ1325 {
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	static int[] computer;
	static int N,M,max=0;
	//static int = Integer.MIN_VALUE;
	//0이 아니라 이렇게 하는 이유 아시는 분?
	
	static void dfs(int sizak) {
		visited[sizak]=true;
		
		
		for(int next:arr[sizak]) {
			if(visited[next]==false) {
				computer[next]++;
				System.out.println(next+" "+computer[next]);
				dfs(next);
				
				//System.out.println(next);
				//System.out.println(count);
			}
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st=new StringTokenizer(br.readLine());
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		computer = new int[N+1];
		arr = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=0;i<=N;i++) {
			arr[i]=new ArrayList();
		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			//a가 b를 신뢰하면 b에서 a로 해킹방향이 가능하단 얘기
			//1차원 배열 arr의 index는 컴퓨터 번호를 뜻한다.
		}
		for(int i=1;i<=N;i++) {
			visited = new boolean[N+1];
			dfs(i);
			//System.out.println(computer[i]);
		}
		for(int i=1;i<=N;i++) {
			max=Math.max(max, computer[i]);
			//System.out.println(computer[i]);
		}
		
		/* 이전 for문으로 찾은 값을 토대로 해킹최대컴퓨터를 모두 찾아냄 
		 * 해킹최대컴퓨터가 여러 대일 수도 있다는 것을 염두
		 */
		for(int i=1;i<=N;i++) {
			if(computer[i]==max) {
				sb.append(i).append(" ");
				//bw.write(i+" ");
			}
		}
		
		//bw.flush();
		//bw.close();
		System.out.println(sb.toString().trim());
	}

}
