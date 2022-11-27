import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long dp[] = new long[n+1];
        dp[0] = 0;  // 0 자리 0
        dp[1] = 1;  // 1 자리 1 (0은 못옴)
        // n자리의 이친수는 0 일때 n-1, 1일 때 n-2이므로 dp[n] = dp[n-1]+dp[n-2];
        for (int i = 2; i < n+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]);
        br.close();
    }
}
