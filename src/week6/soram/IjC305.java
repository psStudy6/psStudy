package week6.soram;

import java.util.*;

public class IjC305 {
	public int solution(int n) {
		int ans = 0,sum=0,lt=0;
		int m=n/2+1;
		int[] arr = new int[m];
		for(int i=0;i<m;i++) arr[i]=i+1;
		for(int rt=0;rt<m;rt++) {
			sum+=arr[rt];
			if(sum==n) ans++;
			while(sum>=n) {
				sum -= arr[lt++];
				if(sum==n) ans++;
			}
		}
			
		
		return ans;
	}
	public int solution2(int n) {
		int ans=0,cnt=1;
		n--;
		while(n>0) {
			cnt++;
			n=n-cnt;
			if(n%cnt==0) {
				System.out.println(n+" "+cnt);
				ans++;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		IjC305 T = new IjC305();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(T.solution(n));
		
	}

}
