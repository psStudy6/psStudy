package week.soram;
import java.util.Scanner;
//인프런 7.점수계산
class IjC207 {  
	public int solution(int n,int[] arr){
		int answer=0,cnt=0; 
		for(int i=0;i<n;i++) {
			if(arr[i]==1) {
				cnt++;
				answer+=cnt; //누적
			}
			else cnt = 0; //틀린경우 cnt를 초기화
		}

		return answer;
	}  

	public static void main(String args[]) { 
		IjC207 T = new IjC207();
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int[] arr = new int[input];
		for(int i=0;i<input;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.print(T.solution(input, arr));
	}
}
