/**
 * 등록 번호 : 10989번  
 * 등록 제목 : 수 정렬하기 3
 * 현재 상태 : 완료 ✔️
 */

// ========================================== ▽ 시간 초과 로직 ▽ ========================================== //
import java.util.Arrays;
import java.util.Scanner;

public class BoJ10989 {

	public static void main(String[] args) {
		BoJ10989 M = new BoJ10989();
		Scanner in = new Scanner(System.in);
		
		int cnt = in.nextInt();
		int[] arr = new int[cnt];
		
		for(int i=0; i<cnt; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println(M.solution(arr));
		in.close();
	}
	
	public String solution(int[] arr) {
		String answer = "";
		
		Arrays.sort(arr);
		/*
		for(int x : arr) {
			answer += x;
		}
		*/
		for(int x=0; x<arr.length; x++) {
			if(x == arr.length-1) {
				answer += arr[x];				
			} else {				
				answer += arr[x] + "\n";
			}
		}
		
		return answer;
	}
}

// ========================================== ▽ 통과 로직 ▽ ========================================== //

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BoJ10989 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[10001];
		
		for(int i = 0; i < N; i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
		
		for(int i = 0; i < 10001; i++) {
			while(arr[i] > 0) {
				sb.append(i).append("\n");
				arr[i]--;
			}
		}
		System.out.println(sb);
	}
}
