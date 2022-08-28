/**
 * 등록 번호 : 14501번
 * 등록 제목 : 퇴사
 * 현재 상태 : 성공 ✔️
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] time = new int[N+10];
		int[] price = new int[N+10];
		int[] deep_price = new int[N+10];
		int max = 0;
		String[] str;
		
		for (int i = 1; i <=N; i++) {
			str = br.readLine().split(" ");
			time[i] = Integer.parseInt(str[0]);
			price[i] = Integer.parseInt(str[1]);
		}
		
		for (int i = 1; i <=N+1; i++) {
			deep_price[i] = Math.max(deep_price[i], max);
			deep_price[time[i]+i] = Math.max(deep_price[time[i]+i],price[i]+deep_price[i]);
			max = Math.max(max, deep_price[i]);
		}
		System.out.println(max);
	}
}
