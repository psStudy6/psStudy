package breaktime;
import java.util.*;
import java.io.*;
/* 달팽이는 올라가고 싶다.
 * A:UP,B:DOWN,V:day
 * 시간이 엄청 빡빡하기 때문에 bfs,dfs로 풀 생각하지 않고
 * 수학적으로 풀어야하는 문제이다.
 */
public class BoJ2869 {
	static int A,B,V;
	static int day=0;
	static int up;
	Queue<Integer> q = new LinkedList<>();
	/*
	static void bfs() {
		while(day<V) {
			day+=A;
			day-=B;
			ans++;
			//System.out.println(day);
		}
		if(day==V) ans-=1;
		
	}
	static void dfs(int day) {
		
		day+=up;
		ans++;
		if(day>=V) {
			if(day==V) {
				ans--;
				return;
			}
			return;
		}
		dfs(day);
		
		
	}
	*/
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		up=A-B;
		day= (V-B)/up;
		if((V-B)%up!=0) day++;
		System.out.println(day);
	}

}
