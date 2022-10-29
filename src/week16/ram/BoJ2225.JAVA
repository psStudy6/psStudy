package week16.src;
import java.util.*;
import java.io.*;
/* 합분해(골드 5)
 * 0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구해라
 * "0도 된다는 것을 기억하기"
 * 표를 만들어서 dp[a][b]는
 * a개의 수를 합해 b를 만드는 경우의 수를 입력
 */
public class BoJ2225 {
	static int N,K;
	static int[][] dp;
	private static final int MOD =1000000000; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[K+1][N+1];
		
		
		
		System.out.println(solution());
		
		
	}
	static public int solution() {
		
		Arrays.fill(dp[1], 1);
		
		for(int i=1;i<=K;i++) dp[i][0]=1;
		
		for(int i=2;i<=K;i++) {
			for(int j=1;j<=N;j++) {
				dp[i][j] = dp[i-1][j]+dp[i][j-1];
				dp[i][j] %= MOD;//덧셈에서 교환법칙이 성립
			}
		}
		
		
		return dp[K][N];
	}

}
