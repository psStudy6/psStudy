/**
 * 문제 제목 : 014. 보이는 학생
 * 강의 시청 : ✔️
 */

// 강의를 보기전 내 방식 -> ✔️(Success)
import java.util.Scanner;

public class Main {
	
	public static int solution(int n, int[] arr) {
		int answer = 1, max = arr[0];

		for (int i=1; i<n; i++) {
      //CheckPoint1. max 학생보다 크다면
			if (max < arr[i]) {
				max = arr[i];
				answer++;
			}
		}     
		return answer;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println(solution(n, arr));
	}
}

// =============================================================== //

// 강의내용1
import java.util.*;
public class main {
  public int solution(int n, int[] arr) {
    int answer=1, max=arr[0];
    for(int i=1; i<n; i++){
      if(arr[i]>max) {
        answer++;
        max = arr[i];
  }
      
  public static void main(String[] args) {
    Main T = new main();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int[] arr = new int[n];
    for(int i=0; i<n; i++) {
      arr[i] = kb.nextint();      
    }
    System.out.print(T.solution(n, arr));
}  
