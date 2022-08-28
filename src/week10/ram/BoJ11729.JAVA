package week10.ram;
import java.util.Scanner;
/* 하노이탑
 * 재귀가 '가장 작은 단위'가 될 때까지 재귀호출
 * 가장 작은 단위까지 호출되면 연산 실행
 * Hanoi(n)=2Hanoi(n-1)+1
 */
public class BoJ11729 {
	static int cnt = 0;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		move(N, 1, 3, 2);//temp = 3
		System.out.println(cnt);
		System.out.println(sb.toString());
	}

	static void move(int N, int from, int to, int temp) {
		if (N == 1) {
			cnt++;
			sb.append(from + " " + to + "\n");
			return;
		} else {
			move(N - 1, from, temp, to);
			sb.append(from + " " + to + "\n");
			cnt++;
			move(N - 1, temp, to, from);
		}
	}

}
