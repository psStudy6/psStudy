package week19.yumi;

import java.util.LinkedList;
import java.util.Queue;

class Position {
    int row;
    int col;
    int distance;
    Position(int row, int col, int distance){
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}

public class PrG81302_v2 {

    static final int[][] arr = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    static int n;

    public int[] solution(String[][] places) {
        int n = places.length;
        int[] answer = new int[n];

        // 강의실별 탐색
        for (int roomIdx = 0; roomIdx < places.length; roomIdx++) {
            // 강의실 상태 세팅
            char[][] roomStatus = new char[5][5];
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    roomStatus[row] = places[roomIdx][row].toCharArray();
                }
            }
            answer[roomIdx] = search(roomStatus);
        }
        return answer;
    }

    // bfs
    int search(char[][] roomStatus){
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                // 파티션은 무조건 통과
                // 빈책상은 경우의 수가 많으므로 탐색 안 함
                if(roomStatus[row][col] != 'P') {
                    continue;
                }
                if (checkRoom(roomStatus, row, col)) {
                    return 0;
                }
            }
        }
        return 1;
    }

    private static boolean checkRoom(char[][] roomStatus, int row, int col) {
        boolean[][] visited = new boolean[n][n];
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(row, col,0));
        visited[row][col] = true;

        while(!queue.isEmpty()){
            Position cur = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int posX = cur.row + arr[dir][0];
                int posY = cur.col + arr[dir][1];
                int distance = cur.distance + 1;

                if(distance > 2) {
                    continue;
                }
                if(posX < 0 || posX > 4 || posY < 0 || posY > 4) {
                    continue;
                }
                if(visited[posX][posY]) {
                    continue;
                }
                //
                if(roomStatus[posX][posY] == 'P') {
                    return false;
                }
                // 빈책상일 경우
                if(roomStatus[posX][posY] == 'O'){
                    visited[posX][posY] = true;
                    queue.add(new Position(posX, posY, distance));
                }
            }
        }
        return true;
    }
}
