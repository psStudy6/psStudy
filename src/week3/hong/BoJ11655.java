
/**
 * 등록 번호 : 11655번  
 * 등록 제목 : ROT13
 * 현재 상태 : 완료 ✔️
 */

package main;

import java.util.Scanner;

public class BoJ11655 {
	public static void main(String[] args) {
		BoJ11655 M = new BoJ11655();
		Scanner in = new Scanner(System.in);
		
		// CheckPoint1. 문자로 된 개행 받기
		String X = in.nextLine();
		in.close();
		System.out.println(M.solution(X));
	}
	
	public String solution(String X) {
		char[] arr = X.toCharArray();
		String answer = "";
		
		for(int i=0; i<X.length(); i++) {
			System.out.print(arr[i] + "/ ");
			System.out.println((int)arr[i]);
			
			int tempCnt = 0;
			// CheckPoint1-1. 대문자와 소문자 그외 나머지 어떻게 구분할 것인지? - 대문자 : 64 ~ 90
			// 대문자 : 64 ~ 90
			if( (int)arr[i] >= 65 && (int)arr[i] <= 90 ) {
				// CheckPoint2-1.
				if( ((int)arr[i] +13) > 90 ) {
					tempCnt = ((int)arr[i] + 13) - 90;
					// System.out.println("tempCnt : " + tempCnt); - Test : 기존 데이터와 차이값
					answer += (char)(64 + tempCnt);
				}
				else {
					answer += (char)((int)arr[i] + 13);
				}
			}
			// CheckPoint1-2. 대문자와 소문자 그외 나머지 어떻게 구분할 것인지? - 소문자 : 97 ~ 122
			else if( (int)arr[i] >= 97 && (int)arr[i] <=122 ) {
				// CheckPoint2.
				if( ((int)arr[i] +13) > 122 ) {
					tempCnt = ((int)arr[i] +13) - 122;
					// System.out.println("tempCnt : " + tempCnt); - Test : 기존 데이터와 차이값
					answer += (char)(96 + tempCnt);
				}
				else {
					answer += (char)((int)arr[i] + 13);
				}
			}
			// CheckPoint1-2. 대문자와 소문자 그외 나머지 어떻게 구분할 것인지? - 그외 : 정규식을 이용한  그대로 반환 [이유 : 숫자는 char로 인식하여 해당 데이터를 잘못 인지 할 수 있기 때문에 ]
			else {
				// 32는 space이기 때문에 그대로 반환 해주면 된다.
				if((int)arr[i] == 32) {
					answer += " ";
				} 
				// 숫자인 경우 해당 숫자는 그대로 반환 해주면 된다.
				else {
					answer += arr[i];
				}
			}
		}
		return answer;
	}
}
