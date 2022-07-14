import java.util.*;
//인프런 7.점수계산
class Score {  
public int solution(int n,int[] arr){
	int answer=0,cnt=0;
	for(int i=0;i<n;i++) {
		if(arr[i]==1) {
			cnt++;
			answer+=cnt;
		}
		else cnt = 0;
	}
 
	return answer;
}  

public static void main(String args[]) { 
	  Score T = new Score();
	  Scanner sc = new Scanner(System.in);
	  int input = sc.nextInt();
	  int[] arr = new int[input];
	  for(int i=0;i<input;i++) {
		  arr[i]=sc.nextInt();
	  }
	  System.out.print(T.solution(input, arr));
	}
}
