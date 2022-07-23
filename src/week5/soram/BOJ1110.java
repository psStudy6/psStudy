package week5.soram;
import java.util.*;
//더하기 사이클
//배열 사용했다가 복잡해져서 Fail
public class BOJ1110 {
	public int solution(int in) {
		int answer=1,tmp=in;
		while(true) {
			int num1 = tmp/10;
			int num2 = tmp%10;
			int num3 = (num1+num2)%10;
			tmp = num2*10+num3;
			if(in==tmp) break;
			answer++;
			
			
			
			
		}
		
		return answer;
	}
	public static void BOJ1110(String[] args) {
		BOJ1110 T = new BOJ1110();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(T.solution(n));
	}

}
