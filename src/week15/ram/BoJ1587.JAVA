//package breaktime;
import java.util.*;
import java.io.*;
/* 숨바꼭질
 * 
 * 
 */
public class BoJ1697 {
	static int N,K;
	static int[] check = new int[100001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		if(N==K) {
			System.out.println(0);
		}else {
			bfs(N);
		}
	}
	static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		check[n]=1;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			for(int i=0;i<3;i++) {
				int next;
				
				if(i==0) {
					next = tmp + 1;
				} else if(i==1) {
					next = tmp - 1;
				} else {
					next = tmp * 2;
				}
				if(next == K) {
					System.out.println(check[tmp]);
					return;
				}
				if(next>=0&&next<check.length&&check[next]==0) {
					q.add(next);
					check[next]=check[tmp]+1;
				}
				
			}
		}
		
		
	}

}
