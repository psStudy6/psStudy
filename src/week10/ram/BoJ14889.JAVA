package week10.ram;
import java.util.*;
import java.io.*;

public class BoJ14889 {
    static int n;
    static int[][] map;
    static boolean[] visited;
    static int diffTeamStat = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        n = Integer.parseInt(s);
        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            s = br.readLine();
            StringTokenizer st = new StringTokenizer(s, " ");

            for (int j = 1; j < n + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // input end

        backTracking(0, 1);
        System.out.println(diffTeamStat);
    }

    static void backTracking(int d, int index) {

        // depth가 n / 2가 되면 팀 순서쌍을 만든 것으로 판단
        // 이 시점의 팀스탯을 계산하고 return한다.
        if (d == n / 2) {
            teamStat();
            return;
        }

        // visited[]를 통해 재귀적으로 팀 순서쌍을 만들어준다.
        // 1,2 = 2,1 이기 때문에 반복문을 index부터 시작해서 돌려준다.
        // visited[]가 같은 값인 것들이 한 팀을 이룬다.
        for (int i = index; i < n + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backTracking(d + 1, i + 1);
                visited[i] = false;
            }
        }

    }

    static void teamStat() {

        List<Integer> startTeam = new ArrayList<Integer>(); // start 팀 순서쌍
        List<Integer> linkTeam = new ArrayList<Integer>(); // linkTeam 순서쌍

        for (int i = 1; i < n + 1; i++) {
            if (visited[i]) {
                startTeam.add(i);
            } else {
                linkTeam.add(i);
            }
        }

        int startTeamStat = 0;
        int linkTeamStat = 0;

        // map[i][j] + map[j][i] 계산
        for (int i = 0; i < startTeam.size(); i++) {
            for (int j = i + 1; j < startTeam.size(); j++) {
                startTeamStat += map[startTeam.get(i)][startTeam.get(j)];
                startTeamStat += map[startTeam.get(j)][startTeam.get(i)];

                linkTeamStat += map[linkTeam.get(i)][linkTeam.get(j)];
                linkTeamStat += map[linkTeam.get(j)][linkTeam.get(i)];
            }
        }

        diffTeamStat = Math.min(Math.abs(startTeamStat - linkTeamStat), diffTeamStat);
     }



}
