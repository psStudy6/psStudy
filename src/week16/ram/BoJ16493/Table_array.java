package week16.src;
import java.util.*;
import java.io.*;

class Table {//구조체 이용한 dp버전
	int ch; 
	int day;//한 챕터를 읽는데 걸리는 시간
	Table(int day,int ch){
		this.day=day;
		this.ch=ch;
	}
	
	
}
public class BoJ16493 {
	static int N,M;
	static int[] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Table[] tb = new Table[M+1];
		dp = new int[N+1];
		
		for(int i=1;i<=M;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int day=Integer.parseInt(st.nextToken());
			int ch= Integer.parseInt(st.nextToken());
			tb[i]=new Table(day,ch);
			
			
		}
		
		for(int i=1;i<=M;i++) {
			int day = tb[i].day;
			int page = tb[i].ch;
			for(int j=N;j>=day;j--) {//dp[날짜]=읽은 챕터수의 지금까지의 최대값을 넣는다.
				//System.out.println(dp[j-day]);
				//자바 배열의 초기값은 0이다.
				dp[j]=Math.max(dp[j], dp[j-day]+page);
			}
		}
		System.out.println(dp[N]);
		
	}

}
