/**
 * 등록 번호 : 9934번
 * 등록 제목 : 완전 이진 트리
 * 현재 상태 : 성공 ✔️
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int K;
	static int[] arr;
	static StringBuffer[] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
    K = Integer.parseInt(br.readLine());
		arr = new int[(int) Math.pow(2, K) - 1];
		String[] input = br.readLine().split(" ");
    
		for (int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(input[i]);

		answer = new StringBuffer[K];
    
		for (int i = 0; i < K; i++) answer[i] = new StringBuffer();
		solve(0, arr.length - 1, 0); // 재귀함수
    
		for (int i = 0; i < K; i++) bw.write(answer[i].toString() + "\n");
		bw.flush();
	}

	public static void solve(int n, int r, int level) {
		if (level == K) return;
		int m = (n + r) / 2;
		answer[level].append(arr[m] + " ");

		// System.out.println(n + " / " + r + " / " + level);
		/** n : 노드 | e : 오른쪽 | level : 레벨(층) */
		solve(n, m - 1, level + 1); 
		solve(m + 1, r, level + 1); 
	}
}
