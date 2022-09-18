package week12.hong;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

/**
 * 등록 번호 : 2468번
 * 등록 제목 : 안전영역
 * 현재 상태 : 성공 ✔
 *
 * input
 * 5
 * 6 8 ✔  6 ✔
 * ✔ ✔ ✔ ✔ 6
 * 6 7 ✔ ✔ ✔
 * 7 ✔ ✔ ✔ 6
 * 8 9 ✔ ✔ 7
 *
 * out
 * 5
 */

public class BoJ2468 {
    static int arr[][];
    static boolean visited[][];
    static int N;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int result[];

    public static void dfs(int y, int x, int depth) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];

            if (xx < 0 || xx >= N || yy < 0 || yy >= N) continue;
            if (arr[yy][xx] > depth && !visited[yy][xx]) {
                dfs(yy, xx, depth);
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        int max_len = 0;

        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (max_len < arr[i][j]) max_len = arr[i][j];
            }
        }

        result = new int[max_len];

        for (int k = 0; k <= max_len; k++) {
            visited = new boolean[N][N];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[i][j] > k && !visited[i][j]) {
                        result[k]++;
                        dfs(i, j, k);
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < result.length; i++) {
            if (answer < result[i]) answer = result[i];
        }
        System.out.println(answer);
        br.close();
    }
}
