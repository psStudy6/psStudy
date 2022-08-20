package week6.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/** 인프런 4-1 학급 회장(해쉬)
 * 
 * 문제 : 학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.
 * 		투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다.
 * 		선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램
 * 
 * 핵심 : 학생별 득표수 = key - value
*/
public class IjC401 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int max = 0;
		char maxStudent = ' ';
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		while (n-- > 0) {
			char student = (char) br.read();
			map.put(student, map.getOrDefault(student, 0) + 1);
		}
		for (Character ch : map.keySet()) {
			if (max < map.get(ch)) {
				max = map.get(ch);
				maxStudent = ch;
			}
		}
		System.out.println(maxStudent);
	}
}
