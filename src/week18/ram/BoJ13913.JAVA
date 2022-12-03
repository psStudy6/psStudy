//package week18.ram;
import java.util.*;
import java.io.*;
/* 숨박꼭질 4
 * 
 */
public class Main {
    static int N, K;
    static boolean[] visited;
    static int[] route,time;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //수빈 위치
        K = Integer.parseInt(st.nextToken()); //동생 위치
        
        visited = new boolean[2*K+1];
        route = new int[2*K+1];//경로 저장
        time = new int[2*K+1];//시간 저장
        //System.out.println(visited[0]);//boolean array의 디폴트 값은 false
        
        bfs();
        /* 경로 찾기 */
        Stack<Integer> stst = new Stack<>();
        int next=route[K];
        stst.push(K);
        while(next!=N) {
        	stst.push(next);
        	next=route[next];
        }
        stst.push(N);
        sb.append(time[K]).append('\n');
        while(!stst.isEmpty()) {
        	sb.append(stst.pop()).append(' ');
        }
        System.out.println(sb);
        


	}
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
        
		q.add(N);
		visited[N]=true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			int next;
			int[] d = {1,-1,curr};
			
			for(int i=0;i<d.length;i++) {
				next=curr+d[i];
				if(next<=2*K&&next>=0) {
					if(!visited[next]) {
						q.offer(next);
						visited[next]=true;
						route[next]=curr; //나중에 루트 출력해야해서 저장중
						time[next]=time[curr]+1;
						if(next==K)return;
					}
					
				}
				
				
			}
			
		}
		
		
		
		
	}

}
