/**
 * 문제 제목 : 018. 점수계산
 * 강의 시청 : ✔️
 */

// 강의를 보기전 내 방식 -> ✔️(Success)
package main;

import java.util.Scanner;

public class IjC207 {

	public static void main(String[] args) {
		IjC207 M = new IjC207();
		Scanner in = new Scanner(System.in);

		int num = in.nextInt();
		int[] arr = new int[num+1];
		for(int i=0; i<num; i++) {
			arr[i] = in.nextInt();
		}

		in.close();
		System.out.println(M.solution(arr, num));
	}

	public int solution(int[] arr, int num) {
		int answer = 0;
		int cnt = 1;
		for(int i=0; i<num; i++) {
				if(arr[i] == 1) {
					answer += arr[i];
					if(arr[i+1] == 0) {
						cnt = 1;
					} else {
						// System.out.println("1 : " + cnt);
						answer += cnt;
						cnt++;
						// System.out.println("2 : " + cnt);
					}
				} else if(arr[i] == 0) {
					answer += 0;
				} else {
					answer += arr[i];
				}
				// System.out.println(answer);
		}
		return answer;
	}
}

// =============================================================== //

// 강의내용1
import java.util.*;

public class Main {
  public int solution(int n, int[] arr) {
    int answer=0, cnt=0;
    for(int i=0; i<n; i++) {
      if(arr[i] == 1) {
        cnt++;
        answer += cnt;
      }
      else cnt =0;
    }
    return answer;
  }
  
  public static void main(String[] args) {
    Main T = new Main();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int[] arr = new int[n];
    for(int i=0; i<n; i++) {
     arr[i] = kb.nextInt(); 
    }
    System.out.println(T.solution(n,arr));
  }
}
