package week3.yumi;

import java.util.Scanner;

/** 프로그래머스 600057 문자열 압축
 * 
 * 문제 : 문자열에서 같은 값이 연속해서 나타나는 것을 그 문자의 개수와 반복되는 값으로 표현하여 더 짧은 문자열로 줄여서 표현
 * 		문자열을 1개 이상의 단위로 잘라서 압축하여 더 짧은 문자열로 표현
 * 		압축할 문자열 s가 매개변수로 주어질 때, 위에 설명한 방법으로 1개 이상 단위로 문자열을 잘라 압축하여 표현한 문자열 중 가장 짧은 것의 길이를 return 
 * 
 * 핵심 : 1. 같은 길이의 구문이 2개 이상인 경우만 탐색
 * 		2. 문장 % n > 0 일 수 있음
 * 		3. 동일한 구문이 10개(두자리 수) 이상 일 수 있으므로 숫자 길이 더함
 * 
 * 방법 3 추천 - 빠름
*/
public class Prg60057 {
	// 방법 1 : 배열 사용
	// 코드가 길지만 속도가 빠름 - 테스트 1 〉	통과 (0.23ms, 77.8MB)
	public int solution(String str) {
		// 최대값은 문장 길이이므로 기본값 설정
		int min = str.length();
		// 같은 길이의 구문이 2개 이상인 경우 (n = 문장 길이의 반 이하)
		// - 같은 길이의 구문이 2개 미만일 경우 문장의 길이와 동일하므로 종료
		for (int n = 1; n <= str.length()/2; n++) {
			String[] arr = setArr(str, n);
			int cnt = countStr(arr, n);
			// 최솟값
			if (min > cnt) {
				min = cnt;
			}
		}
		return min;
	}
	
	// 문장을 n개 단위로 자른 배열
	public String[] setArr(String str, int n) {
		// 배열의 길이 = 문장을 n개 단위로 자른 개수 + 1(비교 위한 널 값) 
		// Math.ceil() : 소수점 생길 시 올림
		String[] arr = new String[(int) Math.ceil((double)str.length()/n)+1];
		
		for (int i = 0; i < arr.length-2; i++) {
			arr[i] = str.substring(i*n, (i+1)*n);
		}
		// 문장 % n > 0 일 수 있으므로 str.length()까지 세팅
		// - IndexOutOfBoundsException 방지
		arr[arr.length-2] = str.substring((arr.length-2)*n, str.length());
		return arr;
	}
	
	// 문장을 n개 단위로 잘랐을 때 문장 길이
	public int countStr(String[] arr, int n) {
		int cnt = 0;
		int dupCnt = 1;
		
		for (int i = 0; i < arr.length-1; i++) {
			// 현재 구문이 다음 구문과 같은 경우 
			// - 동일한 구문 개수++ 
			if (arr[i].equals(arr[i+1])) {
				dupCnt++;
				continue;
			}
			if(dupCnt > 1) {
				// 동일한 구문이 10개(두자리 수) 이상 일 수 있으므로 숫자 길이 더함
				cnt += Math.log10(dupCnt)+1;
				dupCnt = 1;
			}
			// 문장 % n > 0 일 수 있으므로
			cnt += arr[i].length();
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		Prg60057 prg = new Prg60057();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		System.out.println(prg.solution2(str));
	}
	
	
	
	
	//---------------------------------------------------------------------------------------------
	
	// 방법 2 : 재귀 함수 사용
	// 코드가 짧지만 속도가 안 좋음 - 테스트 1 〉	통과 (16.57ms, 100MB)
	public int solution2(String str) {
		int min = 0;
		// 같은 길이의 구문이 2개 이상인 경우 (n = 문장 길이의 반 이하) + 1 (한자리수 문장)
		for (int n = 1; n <= (str.length()/2); n++) {
			int result = getSplitedLength(str, n, 1).length();
			// n이 1일 떄 최솟값 세팅, 이후 길이 비교
			if (n == 1 || min > result) {
				min = result;
			}
		}
		return min;
	}
	
	// 문장을 n개 단위로 잘라 압축한 문장
	public String getSplitedLength(String str, int n, int repeat) {
		// 마지막 구문의 길이가 n의 길이보다 작으면 구문 그대로 반환
		if (str.length() < n) {
			return str;
		}
		
		String result = "";
		String now = str.substring(0, n); // 현재구문
		String post = str.substring(n, str.length()); // 남은 구문
		
		// 현재구문 == 다음구문 
		// - 결과 + (반복 횟수++ 재귀함수)
		if (post.startsWith(now)) {
			return result += getSplitedLength(post, n, repeat+1);
		}
		// 현재구문 != 이전구문 && 현재구문 != 다음구문
		// - 결과 + 현재구문 + (반복 횟수 1 재귀함수)
		if (repeat == 1) {
			return result += now + getSplitedLength(post, n, repeat);
		}
		// 현재구문 == 이전구문 && 현재구문 != 다음구문
		// - 결과 + 반복횟수 + 현재구문 + (반복 횟수 1로 초기화 재귀함수)
		return result += Integer.toString(repeat) + now + getSplitedLength(post, n, 1);
	}

	
	
	
	//---------------------------------------------------------------------------------------------
	
	// 방법 3 : String 으로만 해결
	// 속도 빠름 - 테스트 1 〉	통과 (0.08ms, 72.8MB)
	public int solution3(String str) {
		int min = str.length();
        int len = str.length()/2+1;
        for(int n = 1; n < len; n++) {
            String before = "";
            int cnt = 0;
            int dupCnt = 1;
            for(int i = 0; i < str.length();) {               
                int beginIdx = i;
                // endIdx 세팅
				// - 문장 % n > 0 일 수 있으므로 마지막 구문은 str.length()로 세팅 
                if (i+n > str.length()) {
                	i = str.length();
				} else {
					i = i+n;
				}
                String temp = str.substring(beginIdx, i);
                // 이전 구문과 같은 시 반복 횟수++
                if(temp.equals(before)) {
                    dupCnt++;
                    continue;
                } 
                // 이전 구문과 같지 않고 이전 구문들이 반복 된 구문인 경우 반복횟수의 길이 더함
                if(dupCnt != 1) {
                    cnt += Math.log10(dupCnt) + 1;
                }
            	// 구문 더함   
                dupCnt = 1;
                cnt += before.length();
                before = temp;
            }
            cnt+=before.length();
            if(dupCnt != 1) {
                cnt += (int)Math.log10(dupCnt)+1;
            }
            // 최솟값
            min = (min > cnt) ? cnt : min;
        }
        return min;
	}
	
}
