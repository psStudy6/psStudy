package week12.hong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 등록 번호 : 2606번
 * 등록 제목 : 바이러스
 * 현재 상태 : 성공 ✔️
 */

public class Boj26 {
	static boolean[] check;
	static int[][] arr;
	static int cnt = 0;
	static int N, L;
	static Queue<Integer> qu = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
    
		N = Integer.parseInt(br.readLine());
		L = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		check = new boolean[N+1];
		
		for(int i = 0 ; i < L ; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] =  1;	
		}
			dfs(1);
			System.out.println(cnt-1);
		}
	public static void dfs(int start) {
		check[start] = true;
		cnt++;
		for(int i = 0 ; i <= N ; i++) {
			if(arr[start][i] == 1 && !check[i])
				dfs(i);
		}
	}
}
