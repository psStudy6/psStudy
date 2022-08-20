package week8.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/** 인프런 5-3 크레인 인형뽑기(카카오)
 * 
 * 문제 : 게임 화면은 "N x N" 크기의 정사각 격자이며 위쪽에는 크레인이 있습니다.  
 * 		 각 격자 칸에는 다양한 인형이 들어 있으며 인형이 없는 칸은 빈칸입니다. 
 * 		 모든 인형은 격자 한 칸을 차지하며 격자의 가장 아래 칸부터 차곡차곡 쌓여 있습니다. 
 * 		 가장 위에 있는 인형을 집어 올릴 수 있습니다. 
 * 		 집어 올린 인형은 바구니의 가장 아래 칸부터 인형이 순서대로 쌓이게 됩니다. 
 * 		 만약 같은 모양의 인형 두 개가 바구니에 연속해서 쌓이게 되면 두 인형은 터뜨려지면서 바구니에서 사라지게 됩니다
 * 		 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수 return
 * 
 * 핵심 : stack 사용, 같은 인형일 때 터트리기
*/
public class IjC503 {
	// 방법1 : 함수분리 - 방법2랑 똑같음
	public int solution(int[][] board, int[] moves) {
		int cnt = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < moves.length; i++) {
			int doll = getDoll(board, moves[i]);
			if (doll == 0) {
				continue;
			}
			// 같은 인형일 때 터트리기  cnt += 2
			if (!stack.isEmpty() && stack.peek() == doll) {
				stack.pop();
				cnt += 2;
			} else {
				stack.push(doll);
			}
		}
		return cnt;
	}
	
	// 인형 뽑기
	public int getDoll(int[][] board, int move) {
		// 해당 열 검색
		for (int i = 0; i < board.length; i++) {
			int doll = board[i][move];
			if (doll == 0) {
				continue;
			}
			// 인형이 있을 시 0으로 초기화
			board[i][move] = 0;
			return doll;
		}
		return 0;
	}
	
	
	// 방법2 : 함수분리X
	public int solution2(int board[][], int[] moves) {
		int cnt = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int move : moves) {
			for (int i = 0; i < board.length; i++) {
				if (board[i][move] == 0) {
					continue;
				}
				int doll = board[i][move];
				board[i][move] = 0;
				if (!stack.isEmpty() && doll == stack.peek()) {
					cnt += 2;
					stack.pop();
				}
				else {
					stack.push(doll);
				}
				break;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		IjC503 ijC = new IjC503();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n+1];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n+1; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int moveCount = Integer.parseInt(br.readLine());
		int[] moves = new int[moveCount];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < moveCount; i++) {
			moves[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(ijC.solution(board, moves));
		//System.out.println(ijC.solution2(board, moves));
		br.close();
	}
}
