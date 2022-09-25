package week13.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/** 인프런 9-1 씨름선수
 * 
 * 문제 : A라는 지원자를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A지원자 보다 높은(크고, 무겁다) 지원자가 존재하면 A지원자는 탈락하고, 그렇지 않으면 선발된다.
 * 		N명의 지원자가 주어지면 위의 선발원칙으로 최대 몇 명의 선수를 선발할 수 있는지 알아내는 프로그램
 * 
 * 
*/
class Player implements Comparable<Player> {
	int height;
	int weight;
	
	public Player(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}

	@Override
	public int compareTo(Player o) {
		return o.height - this.height;
	}
}

public class IjC901 {
	
	public int solution(ArrayList<Player> list) {
		int cnt = 0;
		Collections.sort(list);
		int maxWeight = Integer.MIN_VALUE;
		for (Player player : list) {
			if (player.weight > maxWeight) {
				maxWeight = player.weight;
				cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		IjC901 ijc = new IjC901();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Player> list = new ArrayList<Player>();
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Player(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		System.out.println(ijc.solution(list));
	}
}
