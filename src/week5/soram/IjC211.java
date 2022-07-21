package week5.soram;
import java.util.*;
//11.임시반장 정하기
public class IjC211 {
	public int solution(int n,int[][] arr) {
		int answer=0,max=Integer.MIN_VALUE;//Integer.MIN_VALUE = -2147483648
		for(int i=1;i<=n;i++) {//n명의 학생 SEARCH
			int cnt = 0; //cnt는 매번 초기화해줄 것
			for(int j=1;j<=n;j++) {
				for(int k=1;k<=5;k++) {
					if(arr[i][k]==arr[j][k]) {
						cnt++;
						break;
					}
				}
			}
			if(cnt>max) {
				max=cnt;
				answer=i;
			}
		}
		return answer;
		
	}
	
	public static void main(String args[]) {
		IjC211 T = new IjC211();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] std = new int[n+1][6];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=5;j++) {//5학년까지이므로 1명당 5개를 받아들임
				std[i][j]=sc.nextInt();
			}
		}
		System.out.print(T.solution(n, std));
		
	}

}
