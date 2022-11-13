package week17;
import java.util.*;
import java.io.*;
/* 스티커
 * 그리디로 풀기에는 반례가 있어서 DP
 * 대각선으로 MAX를 확인해서 5번 컬럼에서 큰 값이 결과값
 */
public class BoJ9465 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());//테스트케이스 개수
		
		for(int i=0;i<T;i++) {
			int n=Integer.parseInt(br.readLine());//n의 개수
			
			int[][] stickers = new int[2][n+1];
			int[][] dp = new int[2][n+1];
			for(int j=0;j<2;j++) {
				String[] inputs = br.readLine().split(" ");
				for(int k=1;k<=n;k++) {
					stickers[j][k]=Integer.parseInt(inputs[k-1]);
				}
			}
			/* 첫번째 컬럼은 자기 자신이 최대이므로 자기자신으로 초기화 */
			dp[0][1]=stickers[0][1];
			dp[1][1]=stickers[1][1];
			
			for(int j=2;j<=n;j++) {
				dp[0][j]=Math.max(dp[1][j-1],dp[1][j-2] )+stickers[0][j];
				dp[1][j]=Math.max(dp[0][j-1], dp[0][j-2])+stickers[1][j];
			}
			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}
	}

}
