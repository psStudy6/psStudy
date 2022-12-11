package week19.yumi;

import java.util.Arrays;

/**
 * 프로그래머스 81302 거리두기 확인하기
 */
public class PrG81302 {

    static int n;

    public static void main(String[] args) {
        PrG81302 prg = new PrG81302();
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}
                , {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}
                , {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}
                , {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}
                , {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] arr = prg.solution(places);
        System.out.println(Arrays.toString(arr));
    }

    public int[] solution(String[][] places) {
        n = places.length;
        int[] answer = new int[n];
        // 대기실별 탐색
        for (int roomIdx = 0; roomIdx < n; roomIdx++) {
            char[][] roomStatus = new char[n][n];
            for (int row = 0; row < n; row++) {
                roomStatus[row] = places[roomIdx][row].toCharArray();
            }
            answer[roomIdx] = checkRoom(roomStatus);
        }
        return answer;
    }

    private int checkRoom(char[][] roomStatus) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (roomStatus[row][col] != 'P') {
                    continue;
                }
                if (!isSafe(roomStatus, row, col)) {
                    return 0;
                }
            }
        }
        return 1;
    }

    private boolean isSafe(char[][] roomStatus, int row, int col) {
        // 맨해튼 거리 1인 경우
        if (!checkDistance1(roomStatus, row, col)) {
            return false;
        }
        // 맨해튼 거리 2인 경우
        if (!checkDistance2(roomStatus, row, col)) {
            return false;
        }
        // 대각선
        if (!checkDiagonal(roomStatus, row, col)) {
            return false;
        }
        return true;
    }

    // 맨해튼 거리 1인 경우
    private boolean checkDistance1(char[][] roomStatus, int row, int col) {
        int[][] distance = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        for (int i = 0; i < distance.length; i++) {
            int posX = row + distance[i][0];
            int posY = col + distance[i][1];

            if (!isRange(posX, posY)) {
                continue;
            }
            // 맨해튼 거리가 1인 경우는 항상 안 됨
            if (roomStatus[posX][posY] == 'P') {
                return false;
            }
        }
        return true;
    }

    // 맨해튼 거리 2인 경우
    private boolean checkDistance2(char[][] roomStatus, int row, int col) {
        int[][] distance = {{0, 2}, {-2, 0}, {0, -2}, {2, 0}};
        for (int i = 0; i < distance.length; i++) {
            int posX = row + distance[i][0];
            int posY = col + distance[i][1];

            if (!isRange(posX, posY)) {
                continue;
            }
            // 파티션, 빈책상 둘다 가능 - 2칸에 파티션, 빈책상일 경우 3칸 부터 사람 가능(맨해튼 거리 3이상)
            if (roomStatus[posX][posY] != 'P') {
                continue;
            }
            // P O P인 경우 항상 안 됨. (P X P)만 가능
            // 2칸 차이 (1, 1) -> (1, 3) => 1칸 차이 ((1 + 1)/2, (1 + 3)/2) = (1, 2)
            if (roomStatus[(row + posX) / 2][(col + posY) / 2] != 'X') {
                return false;
            }
        }
        return true;
    }

    // 대각선
    private boolean checkDiagonal(char[][] roomStatus, int row, int col) {
        int[][] distance = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
        for (int i = 0; i < distance.length; i++) {
            int posX = row + distance[i][0];
            int posY = col + distance[i][1];

            if (!isRange(posX, posY)) {
                continue;
            }
            // 파티션, 빈책상 둘다 가능
            if (roomStatus[posX][posY] != 'P') {
                continue;
            }
            // P X -> 대각선, 파티션 구분 가능
            // O P -> 대각선, 빈테이블 구분 불가
            if(roomStatus[row][posY] == 'O' || roomStatus[posX][col] == 'O') {
                return false;
            }
        }
        return true;
    }

    private boolean isRange(int posX, int posY) {
        return posX >= 0 && posX < n && posY >= 0 && posY < n;
    }
}
