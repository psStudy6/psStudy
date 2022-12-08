package week19.yumi;

import java.util.*;

/**
 * 프로그래머스 84021 퍼즐 조각 채우기
 */
class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) {
            return this.y - o.y;
        }
        return this.x - o.x;
    }
}

public class PrG84021 {

    static final int[][] direct = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    static int boardSize;
    static List<List<Point>> blocks = new ArrayList<>();

    public static void main(String[] args) {
        PrG84021 prg = new PrG84021();
        int[][] game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
        int[][] table = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};
        System.out.println(prg.solution(game_board, table));
    }

    public int solution(int[][] game_board, int[][] table) {
        int count = 0;
        boardSize = game_board[0].length;
        // 탐색
        for (int x = 0; x < boardSize; x++) {
            for (int y = 0; y < boardSize; y++) {
                // 테이블 퍼즐 조각 탐색
                if (table[x][y] == 1) {
                    blocks.add(search(table, new Point(x, y), 0));
                }
            }
        }
        for (int x = 0; x < boardSize; x++) {
            for (int y = 0; y < boardSize; y++) {
                if (game_board[x][y] == 0) {
                    // 게임 보드 빈공간 탐색 후 퍼즐 조각 매칭
                    count += match(search(game_board, new Point(x, y), 1));
                }
            }
        }
        return count;
    }

    private ArrayList<Point> search(int[][] board, Point basePoint, int skipType) {
        Queue<Point> queue = new LinkedList<>();
        ArrayList<Point> block = new ArrayList<>();

        // 블록의 기준점
        board[basePoint.x][basePoint.y] = skipType; // 방문
        queue.add(basePoint);
        block.add(new Point(0, 0));

        // 블록 탐색 bfs
        while (!queue.isEmpty()) {
            Point next = queue.poll();
            // 4방향
            for (int i = 0; i < direct.length; i++) {
                int posX = next.x + direct[i][0];
                int posY = next.y + direct[i][1];
                if (!isRange(posX, posY) || board[posX][posY] == skipType) {
                    continue;
                }
                board[posX][posY] = skipType; // 방문
                // 블록의 다음 칸
                queue.add(new Point(posX, posY));
                // 0, 0 기준 블록 칸 위치
                block.add(new Point(posX - basePoint.x, posY - basePoint.y));
            }
        }
        // x-y 기준 정렬
        Collections.sort(block);
        return block;
    }

    private boolean isRange(int posX, int posY) {
        return posX >= 0 && posX < boardSize && posY >= 0 && posY < boardSize;
    }

    private int match(List<Point> emptySpace) {
        for (List<Point> block : blocks) {
            // Point 개수 일치 여부
            if (emptySpace.size() != block.size()) {
                continue;
            }
            // 90도 회전하며 탐색
            if (rotate(emptySpace, block)) {
                // 이미 채운 블록 제외
                blocks.remove(block);
                return block.size(); // 채운 Point 개수
            }
        }
        return 0;
    }

    private boolean rotate(List<Point> emptySpace, List<Point> block) {
        for (int turn = 0; turn < 4; turn++) {
            // 매칭
            if (isCorrect(emptySpace, block)) {
                return true;
            }
            // 90도 회전 (x, y) -> (y, -x)
            for (int idx = 0; idx < block.size(); idx++) {
                int tmpX = block.get(idx).x;
                block.get(idx).x = block.get(idx).y;
                block.get(idx).y = -tmpX;
            }
            Collections.sort(block);
            // (0, 0) 기준으로 Point 세팅
            int baseX = block.get(0).x;
            int baseY = block.get(0).y;
            for (int idx = 0; idx < block.size(); idx++) {
                block.get(idx).x -= baseX;
                block.get(idx).y -= baseY;
            }
        }
        return false;
    }

    private static boolean isCorrect(List<Point> emptySpace, List<Point> block) {
        // Point 모두 일치 확인
        for (int idx = 0; idx < emptySpace.size(); idx++) {
            Point emptyPoint = emptySpace.get(idx);
            Point blockPoint = block.get(idx);
            if (emptyPoint.x != blockPoint.x || emptyPoint.y != blockPoint.y) {
                return false;
            }
        }
        return true;
    }
}
