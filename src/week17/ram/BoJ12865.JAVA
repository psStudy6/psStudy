package week17;
import java.util.*;
import java.io.*;
public class BoJ12865 {
	static int N,K;
	static int[] w;//weight
	static int[] v;//value
	static Integer[][] DP;
	//DP는 하향식과 상향식이 있다.
	//상향식으로 구현해볼 예정
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//물품의 갯수
		K = Integer.parseInt(st.nextToken());//버틸 수 있는 무게,Max값
		
		w=new int[N+1];
		v=new int[N+1];
		
		
		
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			w[i]=Integer.parseInt(st.nextToken());
			v[i]=Integer.parseInt(st.nextToken());
		}
		
		System.out.println(bottomUp1());
		DP=new Integer[N][K+1];
		System.out.println(knapsack(N-1,K,DP));
	}
	static public int bottomUp1() {
		int[][] dp = new int[N+1][K+1];
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=K;j++) {
				//i번째 무게를 더 담을 수 없는 경우
				if(w[i]>j) {
					dp[i][j]=dp[i-1][j];
				}
				//if번째 무게를 더 담을 수 있는 경우
				else {
					dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
				}
			}
		}
		
		return dp[N][K];
	}
	static public int bottomUp2(){
		/* bottomUp1()을 개선시킨 버전
		 * dp배열을 1차원으로 쓰기때문에 메모리와 속도를 개선시킬 수 있다.
		 */
		int[] dp = new int[K+1];
		for(int i=1;i<=N;i++) {
			/* K부터 탐색하여 담을 수 있는 무게 한계치가 넘지 않을 때까지 반복 
			 * 배낭 용량이 큰 것부터 조사함으로써
			 */
			for(int j=K;j-w[i]>=0;j--) {
				dp[j]=Math.max(dp[j], dp[j-w[i]]+v[i]);
				System.out.println("j:"+j+",j-w[i]:"+(j-w[i])+",dp[j-w[i]]:"+dp[j-w[i]]);
				System.out.println("\tdp[j]:"+dp[j]);
			}
			System.out.println("\n");
		}
		return dp[K];
	}
	static int knapsack(int i,int k,Integer[][] dp) {
		/* 하향식 방법으로 재귀함수를 이용하여 풀이
		 * 
		 */
		//i가 0미만, 즉 범위 밖이 된다면
		if(i<0)
			return 0;
		
		//탐색하지 않은 위치라면?
		if(DP[i][k]==null) {
			//현재 물건(i)를 추가로 못담는 경우(이전 i값 탐색)
			if(w[i]>k) {
				DP[i][k]=knapsack(i-1,k,DP);
			}
			//현재 물건 (i)를 담을 수 있는 경우
			else {
				//이전 i값과 이전 i값에 대한 k-w[i]의 값+현재 가치(v[i])중 큰 값을 저장
				DP[i][k]=Math.max(knapsack(i-1,k,DP), knapsack(i-1,k-w[i],DP)+v[i]);
			}
		}
		return dp[i][k];
	}

}
