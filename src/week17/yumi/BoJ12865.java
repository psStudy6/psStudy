package week17.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 12865 평범한 배낭
 */
public class BoJ12865 {

    public static int[][] dp;
    public static int[] W;
    public static int[] V;

    // 물품의 수, 버틸 수 있는 무게
    public static void solution(int N, int K) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                // 무게 초과
                if(W[i] > j) {
                    dp[i][j] = dp[i - 1][j]; // 이전 값 누적
                } else { // 더 담을 경우
                    // 이전 값, 이전값-현재 물품 무게 + 가치
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 물품의 수
        int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게
        W = new int[N + 1];
        V = new int[N + 1];
        dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        solution(N, K);
        System.out.println(dp[N][K]);
    }
}
