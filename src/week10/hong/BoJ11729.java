/**
 * 등록 번호 : 11729번
 * 등록 제목 : 하노이 탑 이동 순서
 * 현재 상태 : 성공 ✔️
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		int count = hanoi(N, 1, 2, 3, 0, sb);
		
		bw.write(String.valueOf(count)+"\n");
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
		
		
	}
	
	public static int hanoi(int n, int start, int sub, int to, int count, StringBuilder sb) {
		
		count++;
		
		if(n == 1) {
			sb.append(start + " " + to + "\n");
			return count;
		}
		
		count = hanoi(n-1, start, to, sub, count, sb);
		sb.append(start + " " + to + "\n");
		count = hanoi(n-1, sub, start, to, count, sb);
		
		return count;
	}
}
