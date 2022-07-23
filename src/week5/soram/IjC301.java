package week5.soram;
import java.util.*;
//1.두 배열 합치기(two pointers algorithm)
//key point : 효율성
//정렬의 시간복잡도 O(nlogn)
//배열을 2개 만든 후 pointer p1,p2가 배열의 요소를 0부터 가리키토록한다.

public class IjC301 {
	public ArrayList<Integer> solution(int n,int m,int[] a,int[] b){
		ArrayList<Integer> answer = new ArrayList<>();
		int p1=0,p2=0;
		while(p1<n && p2<m) {
			if(a[p1]<b[p2]) answer.add(a[p1++]);
			else answer.add(b[p2++]);
		}
		while(p1<n) answer.add(a[p1++]);
		while(p2<m) answer.add(b[p2++]);
		
		return answer;
	}
	public static void main(String[] args) {
		IjC301 T = new IjC301();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		int m = sc.nextInt();
		int[] b=new int[m];
		for(int i=0;i<m;i++) {
			b[i]=sc.nextInt();
		}
		for(int x:T.solution(n, m, a, b)) System.out.print(x+" ");
	}

}
