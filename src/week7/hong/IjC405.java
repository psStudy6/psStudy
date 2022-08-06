/**
 * 문제 제목 : 038. K번째 큰 수
 * 강의 시청 : ✔️
 */

// 강의를 보기전 내 방식 -> ❌ (false)


// =============================================================== //

import java.util.*;

public class Main{
  
  public static void main(String[] args) {
    Main T = new Main();
    
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int k = kb.nextInt();
    int[] arr = new int[n];
    
    for(int i=0; i<n; i++) {
      arr[i] = kb.nextInt();
    }

    System.out.println(T.solution(arr, n, k));
  }
  
  public int solution(int[] arr, int n, int k) {
    int answer = -1;
    
    TreeSet<Integer> Test = new TreeSet<>(Collections.reverseOrder());
    for(int i=0;i<n; i++) {
        for(int j=i+1; j<n; j++) {
          for(int l=j+1; l<n; l++) {
            Test.add(arr[i] + arr[j] + arr[l]);
          }
        }
    }
    int cnt = 0;
    for(int x : Test) {
      cnt++;
      if(cnt == k) return x;
    }
    
    return answer;
  }
}
