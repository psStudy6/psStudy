package week10.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    Site : BOJ 백준 사이트
    title : 스타트와 링크
    number : 14889
    subject : 완전 탐색, back tracking
    difficulty : silver 2
 */

public class BoJ14889 {
    static int[][] map;
    static boolean[] visit;
    static int n;
    static int result = Integer.MAX_VALUE;

    static void solution(int idx, int count) {
        // 인원이 다 정해지면 각 팀의 능력 측정 시작
        if (count == n / 2) {
            int sAbility = 0;
            int lAbility = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    // 둘이 같은 팀인 경우 둘의 능력치를 각팀에 더함
                    if (visit[i] && visit[j])
                        sAbility += map[i][j] + map[j][i];
                    else if (!visit[i] && !visit[j])
                        lAbility += map[i][j] + map[j][i];
                }
            }
            result = Math.min(result, Math.abs(sAbility - lAbility));
            return;
        }

        // 모든 경우의 수를 check 하기 위해 반복
        for (int i = idx; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                solution(i + 1, count + 1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        solution(0, 0);
        System.out.println(result);
        br.close();
    }
}
