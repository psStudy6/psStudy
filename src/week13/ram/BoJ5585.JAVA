package week13.ram;
import java.util.*;
import java.io.*;
/* 거스름돈
 * 이 문제가 그리디 알고리즘의 대표격이라고 들었따
 * 한번 풀어보자
 */
public class BoJ5585 {
	static int N;
	static int solution() {
		int ans=0;
		int tmp=1000-N;
		while(tmp>=500) {
			ans++;
			tmp-=500;
		}
		while(tmp>=100) {
			ans++;
			tmp-=100;
		}
		while(tmp>=50) {
			ans++;
			tmp-=50;
		}
		while(tmp>=10) {
			ans++;
			tmp-=10;
		}
		while(tmp>=5) {
			ans++;
			tmp-=5;
		}
		while(tmp>=1) {
			ans++;
			tmp-=1;
		}
		
		
		return ans;
		
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		System.out.println(solution());

	}

}
