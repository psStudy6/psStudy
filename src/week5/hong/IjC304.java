/**
 * 문제 제목 : 028. 연속 부분수열
 * 강의 시청 : ✔️
 */

// 강의를 보기전 내 방식 -> ❌ (false)

// =============================================================== //

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Main T = new Main();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int m = kb.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = kb.nextInt();
    }
    System.out.println(T.solution(arr, n, m));
  }

  public int solution(int[] arr, int n, int m) {
    int answer = 0;
    int sum = 0;
    int front = 0, last = 0;

    while (last < n) {
      if (sum > m) {
        sum -= arr[front++];
        if (sum == m) answer++;
      } else if (sum <= m) {
        sum += arr[last++];
        if (sum == m) answer++;
      }
    }

    return answer;
  }
}
