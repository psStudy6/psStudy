package week19.woojin;

import java.util.LinkedList;
import java.util.Queue;

public class PrG81302 {
    static int[][] check = {{-1,0}, { 1,0}, {0,-1}, {0,1}};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < places.length; i++) {
            String[] temp = places[i];
            boolean check = false;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (temp[j].charAt(k) == 'P') {
                        if(bfs(j, k, temp)) {
                            check = true;
                        }
                    }
                }
            }
            answer[i] = check ? 0 : 1;
        }
        return answer;
    }

    static boolean bfs(int x, int y, String[] p) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                // 탐색 범위를 벗어나면 + 최초 출발점을 탐색에서 제외
                if ((nx < 0 || ny < 0 || nx >= 5 || ny >= 5) || (nx == x && ny == y)) {
                    continue;
                }

                // 맨해튼 거리 구하기
                int m = Math.abs(x - nx) + Math.abs(y - ny);

                // p가 맨해튼 거리 안에 있다면
                if (p[nx].charAt(ny) == 'P' && m <= 2) {
                    return true;
                    // O를 발견하면 O를 중심으로 다시 탐색
                } else if (p[nx].charAt(ny) == 'O' && m < 2) {
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return false;
    }
}
