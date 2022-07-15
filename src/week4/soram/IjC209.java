import java.util.*;
//인프런 9.격자판 최대합
class IjC209 {  
public int solution(int n,int[][] arr){
	int answer = Integer.MIN_VALUE;
	int sum1,sum2;
	for(int i=0;i<n;i++) {
		sum1=sum2=0;
		for(int j=0;j<n;j++) {
			sum1 += arr[i][j];
			sum2 += arr[j][i];
		}
		answer = Math.max(answer, sum1);
		answer = Math.max(answer, sum2);
		
	}
	sum1=sum2=0;
	for(int i=0;i<n;i++) {
		sum1+=arr[i][i];
		sum2+=arr[i][n-i-1];
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
