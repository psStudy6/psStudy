package week9.ram;
import java.util.*;
import java.io.*;
/* ATM(실버 4)
 * 각 사람이 돈을 인출하는데 기다리는 시간의 합이 최소가 되도록
 */
public class BoJ11399 {
	static int solution(int[] input) {
		Arrays.sort(input);
		int sum=0;
		int time=0;
		for(int i=0;i<input.length;i++) {
			sum=sum+input[i]; //대기시간 계산하여
			input[i]=sum; //각 사람의 대기시간을 계산해줌
			time=time+input[i];
			
		}
		return time;
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());
		
		
		
		//System.out.println(solution(input));
		
	}
}
