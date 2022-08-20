package week9.ram;
import java.util.*;
import java.io.*;

/* 중복 확인
 * 배열에 중복되는 숫자가 있는지 확인
 */

public class IjC605 {

  public static char solution(int n, int[] arr) {
      List<Integer> list = new ArrayList<>();

      for (int i = 0; i < n; i++) {
          if (list.contains(arr[i])) {
              return 'D';
          } else {
              list.add(arr[i]);
          }
      }

      return 'U';
  }
  
//정렬을 사용하여 풀이(강의 방식)
public static char solution2(int n, int[] arr) {
    Arrays.sort(arr);

    for (int i = 0; i < n - 1; i++) {
        if (arr[i] == arr[i + 1]) {
            return 'D';
        }
    }

    return 'U';
}


  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];

      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; st.hasMoreTokens(); i++) {
          arr[i] = Integer.parseInt(st.nextToken());
      }

      System.out.println(solution2(n, arr));
  }
}
