package week17.yumi;

import java.util.Scanner;

/**
 * 백준 9655 돌 게임
 *
 * 문제 : 탁자 위에 돌 N개가 있다.
 *       상근이와 창영이는 턴을 번갈아가면서 돌을 가져가며, 돌은 1개 또는 3개 가져갈 수 있다.
 *       마지막 돌을 가져가는 사람이 게임을 이기게 된다.
 *       이기는 사람을 구하는 프로그램을 작성하시오. 게임은 상근이가 먼저 시작한다.
 */
/*
dp[1] s
dp[2] c
dp[3] s
dp[4] c
dp[5] s
dp[6] c
*/
public class BoJ9655 {

    public static String solution1(int N) {
        if (N % 2 == 0) {
            return "CY";
        }
        return "SK";
    }

    public static String solution2(int N) {
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;
        for (int i = 4; i <= N; i++) {
            dp[i] = Math.min(dp[i-1], dp[i-3]) + 1;
        }
        if (dp[N] % 2 == 0) {
            return "CY";
        }
        return "SK";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(solution1(N));
    }
}
