/**
 * 등록 번호 : Samsang
 * 등록 제목 : Samsang
 * 현재 상태 : 미완료 ⚠️
 */

package main;

import java.util.Scanner;

public class Samsung {

	/**
	 * 1. 테스트 케이스 T 입력
	 * 2. 테스트 값 row, col, height 받기 -> rch 
	 * 3. height에 값 보다 작을 경우 땅이 가라 앉았음으로 가라앉지 않은 것들만 생성
	 *  ===== 
	 *  가라 앚은 경우의 데이터 여부 필요 없음? 
	 *  만약 복구 할 필요성이 없다면 제한범위 안에 들어가지 않는 0으로 표기하여
	 *  상하좌우 컨트롤하기 쉽도록 처리
	 *  =====
	 * 4. 상하좌우 붙어 있을 경우 하나의 영역으로 정의하여 출력한다.
	 * 5. 마지막 출력에 각각의 테스트 케이스 값 아래와 같이 출력 
	 *   EX) #테스트케이스. 몇개의 구역
	 */
	public static void main(String[] args) {
		Samsung M = new Samsung();
		Scanner in = new Scanner(System.in);
		int testCaseNumber = in.nextInt();

		/** CheckPoint1. 테스트 케이스 횟수 만큼 반복 */
		for(int c=0; c<testCaseNumber; c++) {	
			int rch = in.nextInt();	// 가로 세로 행 열 (row and col)
			int[][] arr = new int[rch][rch];
			
			for(int i = 0; i<rch; i++) {
				for(int j = 0; j<rch; j++) {
					
					// ==가능성 로직== //
					/** CheckPoint2. 만약 높이보다 작아서 가라 앉은 수면은  0으로 처리하기 */
					int temp = in.nextInt();
					if(temp < rch) temp = 0;
					arr[i][j] = temp;
					// ==가능성 로직== //

					// test 1-2
					System.out.print(arr[i][j] + "\t");
				} // col loop end
				//test 1-1
				System.out.println(); 
			} // row loop end
			System.out.println(M.solution(arr, rch, testCaseNumber));
		} // testCaseNumber loop end
		in.close();
	}
	
	public String solution(int[][] arr, int rch, int testCaseNumber){
		String answer = "";
		
		/**
		 *  CheckPoint3. 현재 기준 배열을 오픈케이스 하여 
		 *  상하좌우 0보다 크면은 1유지 상하좌우가 0일 경우 다른 숫자가 있는지 케이스 확인 
		 *  없다면 현재까지 올라간 카운트 종료 있다면 카운트 증가 후 오픈 케이스 진행
		 * ?. 메소드 하나 생성해서 boolean형태로 카운트 해야하나?
		 */
		
		
		
		
		if(k == testCaseNumber) {
			answer += "#" + testCaseNumber + " 데이터 값";			
		} else {
			answer += "#" + testCaseNumber + " 데이터 값\n";	
		}
		
		return answer;
	}
	
}
