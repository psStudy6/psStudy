package week17.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 9465 스티커
 *
 */
public class BoJ9465 {

    /*
    0, 50, 30
    50, 40, 100
    100, 200, 120
    
     */
    private static long solution(int n, long[][] sticker) {
        long[][] dp = new long[n + 1][3];
        for (int i = 1; i <= n; i++) {
            // 안 뜯음 ) i-1열 스티커의 max 값
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
            // 위쪽 스티커 뜯음 ) i-1열 위쪽 스티커 제외 max + i열 위쪽 스티커
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + sticker[i][0];
            // 아래쪽 스티커 뜯음 ) i-1열 아래쪽 스티커 제외 max + i열 아래쪽 스티커
            dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]) + sticker[i][1];
        }
        return Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2]));
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(br.readLine());
        StringBuffer sb = new StringBuffer();
        while (t-- > 0) {
            int n = Integer.valueOf(br.readLine());
            long[][] sticker = new long[n+1][2];
            // 스티커 세팅
            for (int row = 0; row < 2; row++) {
                String[] line = br.readLine().split(" ");
                for (int i = 1; i <= n; i++) {
                    sticker[i][row] = Long.valueOf(line[i-1]);
                }
            }
            sb.append(solution(n, sticker)).append("\n");
        }
        System.out.println(sb);
    }
}
