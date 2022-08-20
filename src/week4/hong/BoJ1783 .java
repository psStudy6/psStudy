/**
 * 등록 번호 : 1783번  
 * 등록 제목 : 병든 나이트
 * 현재 상태 : 완료 ✔️
 */
package main;

import java.util.Scanner;

public class BoJ1783 {
	/**
	 *
	 * 문제 이해(?)
	 * - 1번. 2칸 위로, 1칸 오른쪽
	 * - 2번. 1칸 위로, 2칸 오른쪽
	 * - 3번. 1칸 아래로, 2칸 오른쪽
	 * - 4번. 2칸 아래로, 1칸 오른쪽
	 *
	 * - "다섯번 째 움직임 부터는 1번 조건부터 4번 조건" 실행(?) -> 이게 맞나?
	 */

	public static void main(String[] args) {
		BoJ1783 M = new  BoJ1783();
		Scanner in = new Scanner(System.in);

		int n = in.nextInt(); // 세로
		int m = in.nextInt(); // 가로

		in.close();
		System.out.println(M.solution(n, m));

	}

	public int solution(int n, int m) {
		int answer = 0;

		// CheckPoint1. 1줄에서는 이동 할 수 없다.
        if (n == 1) {
            answer = 1;
        }
        /** CheckPoint2. 2줄에서는 옆으로 이동 가능하다.
         *  case1. 2번
         *  case2. 3번
         */
        else if (n == 2) {
            answer = Math.min(4, (m + 1) / 2);
        }
        /** CheckPoint3. 3줄이상일 경우(?)
         *  case1. 1번
         *  case2. 2번
         *  case3. 3번
         *  case4. 4번
         */
        else {
        	/// CheckPoint3-1. 높이 7이상 올라가게 될 경우
            if (m < 7) {
                answer = Math.min(4, m);
            }
            // CheckPoint3-2. 5회 이상임으로 모든 조건을 수행하여야 하기 때문에 칸 소비가 많이(비효율적) 든다
            else {
                answer = m - 2;
            }
        }
		return answer;
	}
}
