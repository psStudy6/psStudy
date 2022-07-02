// 방식1. NoSuchElement 발생 코드 Eclipse에서 진행시 문제없이 진행됨.
package main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
			Main M = new Main();
			Scanner in = new Scanner(System.in);

			int N = in.nextInt();
			System.out.println(M.solution(N));

	}

	public int solution(int N) {
		Scanner in = new Scanner(System.in);

		// CheckPoint1. 들어가는 데이터 숫자 만큼 데이터 입력
		String[] arr = new String[N];

		for(int r=0; r<N; r ++) {
			arr[r] = in.next();
		}

		// 문제 요점. 해당 이중문자(aa, bb, cc..)등이 자리 매김하고 있다면 해당 다른 문자에서 사용하게 된다면 중복처리 된다.
		// 하지만 이중 문자가 아니라면 비슷한 문자로 취급하여 중복이 되지 않는다.
		int answer = 0;

		// test
		for(int j=0; j<N; j++) {
			for(int k=j+1; k<N; k++) {
				boolean result = true;

				// map에 데이터 담기 위한용도
				HashMap<Character, Character> map = new HashMap<>();

				for(int p=0; p<arr[j].length(); p++) {
					char tempOne = arr[j].charAt(p);  // 원본 데이터
					char tempTwo = arr[k].charAt(p);	// 꼼숑인지 뭔숑인지 데이터
					if(map.containsKey(tempOne)) {
						// 문제가 있는 부분
						if(map.get(tempOne) != tempTwo) {
							result = false;
							break;
						}
					}
					else {
						Iterator<Character> keys = map.keySet().iterator();
						while(keys.hasNext()) {
							char key = keys.next();
							if(map.get(key) == tempTwo) {
								result = false;
								break;
							}
						}
						if(result) map.put(tempOne, tempTwo);
					} // if문 탈출
				} // p 반복문 탈출
				if(result) answer++;
			} // k 반복문 탈출
		} // j 반복문 타룰
        in.close();

		return answer;
	}
}

// 방식2. BackJoon에서 통과된 로직
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();

		// CheckPoint1. 들어가는 데이터 숫자 만큼 데이터 입력
		String[] arr = new String[N];

		for(int r=0; r<N; r ++) {
			arr[r] = in.next();
		}

		// 문제 요점. 해당 이중문자(aa, bb, cc..)등이 자리 매김하고 있다면 해당 다른 문자에서 사용하게 된다면 중복처리 된다.
		// 하지만 이중 문자가 아니라면 비슷한 문자로 취급하여 중복이 되지 않는다.
		int answer = 0;

		// test
		for(int j=0; j<N; j++) {
			for(int k=j+1; k<N; k++) {
				boolean result = true;

				// map에 데이터 담기 위한용도
				HashMap<Character, Character> map = new HashMap<>();

				for(int p=0; p<arr[j].length(); p++) {
					char tempOne = arr[j].charAt(p);  // 원본 데이터
					char tempTwo = arr[k].charAt(p);	// 꼼숑인지 뭔숑인지 데이터
					if(map.containsKey(tempOne)) {
						// 문제가 있는 부분
						if(map.get(tempOne) != tempTwo) {
							result = false;
							break;
						}
					}
					else {
						Iterator<Character> keys = map.keySet().iterator();
						while(keys.hasNext()) {
							char key = keys.next();
							if(map.get(key) == tempTwo) {
								result = false;
								break;
							}
						}
						if(result) map.put(tempOne, tempTwo);
					} // if문 탈출
				} // p 반복문 탈출
				if(result) answer++;
			} // k 반복문 탈출
		} // j 반복문 타룰

		System.out.println(answer);
	}
}


/**
 * 방식 1에서 안된 이유
 * BackJoon 특성 상 해당 데이터를 바로바로 주입하기 떄문에 다음 메서드로 넘어가서 데이터를 받는 것을 
 * 허용 하지 않는 것으로 보여진다. 
 * 방식1에서 변형으로 여러가지를 실험하였지만 모두다 "NoSuchElement"가 발생하였으며
 * 방식2에서는 예제의 데이터를 한 메서드에서 주입해야 해당 데이터들이 바로 들어가지기 때문에 바로 통과되었다. 
 * 즉, 예제 프로그램 입력은 개발자가 짠 로직에 맞춰서 데이터를 입력할 수가 없다. 때문에 NoSuchElement가 발생하는 것으로 추정하고 있다.
 */

