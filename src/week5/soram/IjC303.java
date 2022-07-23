package week5.soram;

import java.util.Scanner;
//3.최대 매출(Sliding window)
public class IjC303 {
	public int solution(int n,int k,int[] arr){
		int answer=0,sum=0;
		for(int i=0;i<k;i++) sum+=arr[i];
		answer=sum;
		for(int i=k;i<n;i++) {
			sum+=(arr[i]-arr[i-k]);
			/**arr[i-k] 은 방금 지나간 창문 자리**/
			answer=Math.max(answer, sum);
		}
		return answer;
		
	}
	public static void main(String[] args) {
		IjC303 T = new IjC303();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
			
		}
		System.out.print(T.solution(n,k,arr));
	}

}
