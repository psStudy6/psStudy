/**
 * 등록 번호 : 9012번  
 * 등록 제목 : 괄호
 * 현재 상태 : 성공 ✔️
 */
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
 
public class BoJ9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
 
		while (T-- > 0) {
			sb.append(solution(br.readLine())).append('\n');
		}
		System.out.println(sb);
	}
 
	public static String solution(String s) {
		int count = 0;
 
		for (char c : s.toCharArray()) {
			if (c == '(') {
				count++;
			} else if (count == 0) {
				return "NO";
			} else {
				count--;
			}
		}
 
		if (count == 0) {
			return "YES";
		} else {
			return "NO";
		}
	}
}
