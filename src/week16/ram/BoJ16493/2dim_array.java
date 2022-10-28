package week16.src;
import java.util.*;
import java.io.*;

public class BoJ16493 {
	static int N,M;
	static int[] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] input = new int[M+1][2];
		dp = new int[N+1];
		
		for(int i=1;i<=M;i++) {
			st=new StringTokenizer(br.readLine());
			input[i][0]=Integer.parseInt(st.nextToken());
			input[i][1]= Integer.parseInt(st.nextToken());
			
			
		}
		
		for(int i=1;i<=M;i++) {
			int day = input[i][0];
			int page = input[i][1];
			for(int j=N;j>=day;j--) {//dp[날짜]=읽은 챕터수의 지금까지의 최대값을 넣는다.
				//System.out.println(dp[j-day]);
				//자바 배열의 초기값은 0이다.
				dp[j]=Math.max(dp[j], dp[j-day]+page);
			}
		}
		System.out.println(dp[N]);
		
	}

}
