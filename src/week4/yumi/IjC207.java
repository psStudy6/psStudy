package week4.yumi;

import java.util.Scanner;

/** 인프런 2-7 점수계산
 * 
 *  문제 : 앞의 문제에 대해서는 답을 틀리다가 답이 맞는 처음 문제는 1점으로 계산한다.
 *  	  또한, 연속으로 문제의 답이 맞는 경우에서 두 번째 문제는 2점, K번째 문제는 K점으로 계산한다. 
 *  	  틀린 문제는 0점으로 계산 
 *  
 *  핵심 : -
*/
public class IjC207 {
	
	// 방법 1 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		int accum = 0;
		
		while (n-- > 0) {
			int score = sc.nextInt();
			// 가산점
			accum = score==0 ? 0 : accum+1;
			if (accum > 0) {
				score = accum;
			}
			sum += score;
		}
		sc.close();
		System.out.println(sum);
	}
	
	
	
	// 방법 2
	public int solution(int[] arr) {
		int sum = 0, cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				cnt = 0;
				continue;
			}
			// 가산점 
			cnt++;
			sum += cnt;
		}
		return sum;
	}
	
	public static void main2(String[] args) {
		IjC207 ijC = new IjC207();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(ijC.solution(arr));
	}
	
}
