package week.soram;
import java.util.*;
//맨 왼쪽아래 칸에서 오른쪽으로밖에 이동하지 못한다.
public class BOJ1783 {
	public int solution(int n,int m) {
		int answer = 0;
		if(n==1) answer=1;//세로칸이 1일 경우 이동 불가
		else if (n==2) answer = Math.min((m+1)/2, 4);
		else {
			if(m<7) answer = Math.min(m, 4);
			else answer = m-2;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		BOJ1783 T = new BOJ1783();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		System.out.println(T.solution(n, m));
		
	}
	
}
