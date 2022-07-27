package week6.soram;
import java.util.*;
public class IjC306 {
	public int solution(int n,int k,int[] arr) {
		int ans=0,cnt=0,lt=0;
		for(int rt=0;rt<n;rt++) {
			if(arr[rt]==0) cnt++;
			while(cnt>k) {
				if(arr[lt]==0) cnt--;
				lt++;
			}
			ans = Math.max(ans, rt-lt+1);
		}
		return ans;
	}
	public static void main(String[] args) {
		IjC306 T = new IjC306();
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
