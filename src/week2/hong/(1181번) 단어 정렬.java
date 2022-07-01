/**
 * 등록 번호 : 1181번  
 * 등록 제목 : 단어 정렬
 * 현재 상태 : 완료 ✔️
 */

// 📄 상태에 대한 중요 상태 설명
// CheckPoint   - 포인트 구간에 대한 설명
// (수정)       - 현재 부족한 로직 수정
// 확인         - Test하기 위한 중간 consle 데이터 점검(System.out.println("필요한 데이터 출력")

import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Main M = new Main();
		Scanner in = new Scanner(System.in);
		
		//CheckPoint1. 몇개가 들어올지 모르는 예wp
		int C = in.nextInt();
		String[] X = new String[C];
		
		in.nextLine();
		
		for(int i=0; i<C; i++) {
			X[i] = in.nextLine();
		}
		in.close();
		
		System.out.println(M.solution(X, C));
	}
	
	public String solution(String[] X, int C) {
		String answer = "";

		// CheckPoint2. 데이터 가져와서 Comparator로 정렬
		Arrays.sort(X, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				// CheckPoint3. 같은 길이를 보여하고 있을 때는 사전의 순으로 정렬
				if(o1.length() == o2.length() ) { return o1.compareTo(o2); }
				else { return o1.length() - o2.length(); }
			}
		});
		
		answer += X[0];
		
		for(int j=1; j<C; j++) {
			if(!X[j].equals(X[j-1])) {
				answer +=  "\n" + X[j];
			}
		}
		
		return answer;
	}
}
