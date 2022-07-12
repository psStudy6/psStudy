/**
 * 문제 제목 : 019. 등수구하기
 * 강의 시청 : ✔️
 */

// 강의를 보기전 내 방식 -> ✔️(Success)
package main;

import java.util.Scanner;

public class IjC208 {

    public static void main(String[] args) {
    	IjC208 M = new IjC208();
    	Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int num[] = new int[n];

        for(int i=0; i<num.length; i++){
            num[i] = in.nextInt();
        }
        in.close();
        System.out.println(M.solution(num, n));
    }

    public String solution(int[] num, int n) {
    	String answer = "";
    	int result[] = new int[n];
        int count;

    	for(int i=0; i<num.length; i++){
            count = 1;
            for(int j=0; j<num.length; j++){
                if(num[i]<num[j]){
                    count++;
                }
            }
            result[i] = count;
        }

        for(int x : result) {
        	answer += x + " ";
        }
        return answer;
    }
}

// =============================================================== //

// 강의내용1
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Main T = new Main();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = kb.nextInt();
    }
    for (int x : T.solution(n, arr)) {
      System.out.print(x + " ");
    }
  }

  public int[] solution(int n, int[] arr) {
    int[] answer = new int[n];
    for (int i = 0; i < n; i++) {
      int cnt = 1;
      for (int j = 0; j < n; j++) { 
        if (arr[j] > arr[i]) cnt++; 
      }
      answer[i] = cnt; 
    }
    return answer;
  }
}
