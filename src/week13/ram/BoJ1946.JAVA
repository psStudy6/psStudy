package week13.ram;
import java.util.*;
import java.io.*;
/* 신입 사원
 * 초기를 인원수 N으로 초기화 해놓고 
 * flag를 하는 방법으로 할 것 아니면
 * 조건이 안되는 경우 N을 감소시키는 방법을 사용하면 된다.
 * 시간초과 ㅠㅠㅠ
 */
public class BoJ1946 {
	public static int solution(int[] arr,int N) {
		int ans=N;
		for(int i=2;i<=N;i++) {
			int interview = arr[i];
			for(int j=i-1;j>=1;j--) {
				if(interview>arr[j]) {
					ans--;
					//System.out.println(i+" "+j);
					break;
				}
			}
		}
		
		return ans;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			//System.out.println(N);
			int[] arr = new int[N+1];
			arr[0]=0;
			for(int j=0;j<N;j++) {
				String[] input = br.readLine().split(" ");
				int tmp=Integer.parseInt(input[0]);
				arr[tmp]=Integer.parseInt(input[1]);
				
			}

			bw.write(solution(arr,N)+"\n");
		}
		bw.flush();
        bw.close();
        br.close();

	}

}
