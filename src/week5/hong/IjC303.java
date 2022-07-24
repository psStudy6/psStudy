/**
 * 문제 제목 : 027. 최대 매출 구하기
 * 강의 시청 : ✔️
 */

// 강의를 보기전 내 방식 -> ✔️ (Success)
package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IjC303 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(n, k, arr));
    }
  
    public int solution(int n, int k, int[] arr) {
        int answer = 0;

        for (int i = 0; i < n - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            if (sum > answer) answer = sum;
        }

        return answer;
    }
}
// =============================================================== //

import java.util.Scanner;

public class IjC303 {
	public int solution(int n,int k,int[] arr){
		int answer=0,sum=0;
		for(int i=0;i<k;i++) sum+=arr[i];
		answer=sum;
		for(int i=k;i<n;i++) {
			sum+=(arr[i]-arr[i-k]);
			answer=Math.max(answer, sum);
		}
		return answer;
		
	}
	public static void main(String[] args) {
		IjC303 T = new IjC303();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
			
		}
		System.out.print(T.solution(n,k,arr));
	}

}
