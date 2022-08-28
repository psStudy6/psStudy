package week10.ram;
import java.util.*;

public class IjC608 { // binary search
	
	public static int solution(int n, int m, int[] arr) {
		int answer = 0;
		
		Arrays.sort(arr); // 오름차순 정렬
		int lt = 0, rt = n-1; 		
		while(lt<=rt) {
			int mid = (lt+rt)/2;
			if (arr[mid]==m) {
				answer = mid+1;
				break;
			} 
			if (arr[mid]>m) rt = mid-1;
			else lt = mid+1;
		}
		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 배열 크기
		int m = sc.nextInt(); // 찾는 숫자
		int[] arr = new int[n];
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(solution(n,m,arr));
	}

}
