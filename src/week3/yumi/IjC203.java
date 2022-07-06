package week3.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/** 인프런 2-3 가위 바위 보
 * 
 * 문제 간단 설명 : 두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력
 * 				A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력
 * 				1:가위, 2:바위, 3:보
 * 
 * 핵심 : Map에 이기는 조건 정의 후 값 비교 / A가 이기는 조건 
*/
public class IjC203 {
	// 방법 1 : Map 사용
	static String solution(String[] aArr, String[] bArr) {
		StringBuffer sb = new StringBuffer();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		// key : value = value가 이김
		map.put(1, 2);
		map.put(2, 3);
		map.put(3, 1);
		
		for (int i = 0; i < aArr.length; i++) {
			int a = Integer.parseInt(aArr[i]);
			int b = Integer.parseInt(bArr[i]);
			// 비김
			if (a == b) {
				sb.append("D");
			} 
			// B 승리
			else if (map.get(a) == b) {
				sb.append("B");
			}
			// A 승리
			else {
				sb.append("A");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	// 방법 2 : A가 이기는 조건 기재
	static String solution(int[] aArr, int[] bArr) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < aArr.length; i++) {
			// 비김
			if (aArr[i] == bArr[i]) sb.append("D");
			// A 승리
			else if (aArr[i]==1 && bArr[i]==3) sb.append("A");
			else if (aArr[i]==2 && bArr[i]==1) sb.append("A");
			else if (aArr[i]==3 && bArr[i]==2) sb.append("A");
			// B 승리
			else sb.append("B");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] aArr = br.readLine().split(" ");
		String[] bArr = br.readLine().split(" ");
		System.out.println(solution(aArr, bArr));
	}
}
