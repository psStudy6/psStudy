package week17;
import java.util.*;
import java.io.*;
/* 이친수(pinary number,쌍곡선 수?)
 * 0으로 시작하지 않는다.
 * 1이 두번 연속 나타나지 않는다.
 * N 자리 이친수의 개수를 구하라
 * dp도 Top-down은 재귀함수
 * Bottom-Up은 반복문
 */
public class BoJ2193 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long dp[] = new long[N+1]; //dp[N]은 N자리 이친수
		System.out.println(bottomup(N,dp));
		System.out.println(recursive(N,dp));
		
	}
	
	public static long bottomup(int N,long dp[]) {//반복문 방식으로,128ms/14340kb
		dp[0]=0;
		dp[1]=1;
		for(int i=2;i<=N;i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		return dp[N];
	}
	
	public static long recursive(int N,long dp[]) { //재귀함수(Top-down) 방식으로,128ms/14526kb
		if(N==0) return 0;
		if(N==1) return 1;
		if(dp[N]>0) return dp[N];
		dp[N]=recursive(N-1,dp)+recursive(N-2,dp);
		return dp[N];
		
		
	}

}
