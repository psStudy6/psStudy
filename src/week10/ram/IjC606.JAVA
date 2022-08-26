package week10.ram;
import java.util.*;
import java.io.*;
public class IjC606 {
	public static ArrayList<Integer> solution(int n, int[] arr) {
		ArrayList<Integer> answer = new ArrayList<>();
		int[] temp = arr.clone(); // 깊은 복사
		
		Arrays.sort(temp); // 복사한 배열 정렬		
		for (int i=0; i<n; i++) {
			if (arr[i]!=temp[i]) answer.add(i+1);
		}		
		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n]; // 학생들의 키
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		for (int x : solution(n,arr)) {
			System.out.print(x + " ");
		}
	}

}
