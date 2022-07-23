package week5.soram;
import java.util.*;
//sliding window O(n^2)->O(n)
//lt = left , rt = right
//N개의 수로 이루어진 수열에서 특정 숫자 M이 되는 경우가 몇 번 있는지 구해라
public class IjC304 {
	public int solution(int n,int m,int[] arr) {
		int answer = 0,sum = 0,lt=0;
		for(int rt=0;rt<n;rt++) {
			sum+=arr[rt];
			if(sum==m) answer++;
			while(sum>=m) {
				sum-=arr[lt++];
				if(sum==m) answer++;
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		IjC304 T = new IjC304();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.print(T.solution(n, m, arr));

	}

}
