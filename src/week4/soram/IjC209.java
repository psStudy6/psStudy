package week4.soram;
import java.util.*;
//인프런 9.격자판 최대합
//N*N 격자판에서 각 행의 합, 각 열의 합, 두 대각선의 합 중 가장 큰 합을 출력
class IjC209 {  
public int solution(int n,int[][] arr){
	int answer = Integer.MIN_VALUE; //-2^31
	int sum1,sum2;
	for(int i=0;i<n;i++) {
		sum1=sum2=0;
		for(int j=0;j<n;j++) {
			sum1 += arr[i][j];//각 행의 합
			sum2 += arr[j][i];//각 열의 합
		}
		answer = Math.max(answer, sum1);
		answer = Math.max(answer, sum2);
		
	}
	sum1=sum2=0;
	for(int i=0;i<n;i++) {
		sum1+=arr[i][i];//대각선의 합
		sum2+=arr[i][n-i-1];//반대 대각선의 합
	}
	answer=Math.max(answer,sum1);
	answer=Math.max(answer, sum2);
	return answer;
}  

public static void main(String args[]) { 
	  IjC209 T = new IjC209();
	  Scanner sc = new Scanner(System.in);
	  int input = sc.nextInt();
	  int[][] arr = new int[input][input];
	  for(int i=0;i<input;i++) {
		  for(int j=0;j<input;j++) {
			  arr[i][j]=sc.nextInt();
		  }
	  }
	  System.out.print(T.solution(input, arr));
	}
}
