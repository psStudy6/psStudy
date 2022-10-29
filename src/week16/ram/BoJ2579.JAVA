package week16.src;
import java.util.*;
import java.io.*;
/* 백준 계단오르기
 * 인프런 계단오르기를 구현해보고
 * 백준에도 비슷한 (더 구현된)문제가 있어서 풀어보기
 * 한 번에 +1 or +2임
 * 연속된 3개의 계단은 못올라감
 * 사실 이 조건이 없으면 모든 계단을 밟으면 된다
 * DP는 중복값이 나올때마다 이미 계산한 값이라면 계산하지 않고 값을 튀어나오는 방식을 차용
 * 배열을 이용해서!
 * 
 */
public class BoJ2579 {
	static int[] point;//각 층의 점수가 저장되어 있는 배열
	static int[] dp;//각 층에 도착하는 부분해를 저장하는 배열
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		point = new int[N+1];
		dp = new int[N+1];
		for(int i=1;i<=N;i++) {
			point[i]=Integer.parseInt(br.readLine());
		}
		System.out.println(solution(N));
		
	}
	
	static public int solution(int N) {
		dp[0]=0;
		dp[1]=point[1];
		if(N==1) return dp[1];
		//주어진 N이 1일 때 dp[2]가 없으므로 널포인트오류가 날 수 있으므로 조건문으로 리턴처리
		dp[2]=dp[1]+point[2];
		//점수가 음수인 경우는 없으니깐 무조건 이경우가 최대
		for(int i=3;i<=N;i++) {
			dp[i]=Math.max(point[i]+point[i-1]+dp[i-3], point[i]+dp[i-2]);
			//연속으로 3개의 계단을 못밞는 다는 조건을 충족하기 위한 점화식
		}
		
		return dp[N];
	}

}
