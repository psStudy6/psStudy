package week10.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    Site : BOJ 백준 사이트
    title : 퇴사
    number : 14501
    subject : greedy
    difficulty : silver 3
 */

public class BoJ14501 {
    static int n;
    static int[] T,P;
    static int max = 0;

    public static void getMaxP(int index, int p){
        max = Math.max(max, p);
        if(index == n+1)
            return;
        if(index + T[index] <= n+1)
            getMaxP(index + T[index], p+P[index]);
        getMaxP(index + 1, p);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        T = new int[n+1];
        P = new int[n+1];

        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            T[i] = Integer.parseInt(input[0]);
            P[i] = Integer.parseInt(input[1]);
        }
        getMaxP(1,0);
        System.out.println(max);
    }

    /**
     * DP 방식
     * Overlapping Subproblem : 작은 문제를 해결하는 방법으로 큰 문제를 해결할 수 있냐?
     *  - ex) n-1일 째의 최대값을 구하는 방법 = n일 째의 최대값을 구하는 방법
     * Optimal Substructure : 이전에 사용한 값이 재사용되는가?
     *  - ex) 이전의 어떤 날짜서의 최대 + 다른 상담 결과 = 현재 다른 어떤 날에서의 최대
     * DP[i] = i번째 일까지 상담 했을 때 얻는 최대 이익 -> i+1일 째에 발생 (7일째 1일짜리 상담 -> 8일째에 최대 발생)
     * 1 : 0
     * 2 : 0
     * 3 : 0
     * 4 : 10(1일째 정산 금액) vs 10(3일째 정산 금액) = 10
     * 5 : 10(4일 까지의 최대금액) vs 10(4일 까지의 최대 금액) + 20(4일째 정산금액) = 30
     * 6 : 30(5일 까지의 최대 금액)
     * 7 : 20(2일째 정산 금액) vs 15(5일째 정산 금액) + 30(6일 까지의 최대 금액) = 45
     * 8 : 45(7일 까지의 정산 금액)
     *
     * 4일 : 정산 금액끼리의 비교(다른 날을 선택해서 변경된 값과 해당 날의 선택해서 받는 이득을 비교)
     * 	- ex) 1일째를 선택하냐 vs 3일째를 선택하냐
     * 	- ex) 2일째 정산 금액 vs 6일까지의 최대 금액과 5일째 정산 금액
     * 	Math.max(dp[n] + denefit, dp[next])
     * 5일 : 그날 일은 다음날에 정산
     * 	- ex) 4일까지의 최대금액 vs 4일까지의 금액 + 4일째 정산금액
     * 	Math.max(dp[n+1], dp[n]
     */
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int[] dp = new int[n+2];
//        int[] T = new int[n+1];
//        int[] P = new int[n+1];
//        for (int i = 1; i <= n; i++) {
//            String[] Input = br.readLine().split(" ");
//            T[i] = Integer.parseInt(Input[0]);
//            P[i] = Integer.parseInt(Input[1]);
//        }
//
//        for (int i = 1; i <= n; i++) {
//            int next = i + T[i];
//            if(next <= n+1)
//                dp[next] = Math.max(dp[i] + P[i], dp[next]);
//            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
//        }
//        System.out.println(dp[n+1]);
//        br.close();
//    }
}
