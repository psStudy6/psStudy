package week4.soram;
import java.util.*;

//인프런 8.등수구하기
class IjC208 {  
	public int[] solution(int n,int[] arr){
		int[] answer = new int[n];//i번 index 학생의 등수를 넣는다.
		for(int i=0;i<n;i++) {
			int cnt = 1;
			for(int j=0;j<n;j++) {
				if(arr[j]>arr[i]) cnt++;
			}
			answer[i]=cnt;
		}
		return answer;
	}  

	public static void main(String args[]) { 
		IjC208 T = new IjC208();
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int[] arr = new int[input]; //성적을 받는 배열
		for(int i=0;i<input;i++) {
			arr[i]=sc.nextInt();
		}
		for(int x : T.solution(input, arr)) System.out.print(x+ " ");
	}
}
