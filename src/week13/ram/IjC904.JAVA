package breaktime;
import java.util.*;
/* 최대 수입 스케쥴(우선순위큐 응용)
 * FIFO 구조를 가진 큐이지만 우선순위가 높은 데이터가 먼저 나간다.
 * time이 0일 때부터 접근하는 이유 : 최대한 적은 날을 소모하는 값을 넣어야 최대 값을 얻을 수 있다
 * 그리디 알고리즘 사용
 */

class Lecture implements Comparable<Lecture> {
	public int money;
	public int time;

	Lecture(int money, int time) {
		this.money = money;
		this.time = time;
	}

	@Override
	public int compareTo(Lecture ob) { // 시간이 큰 값을 우선으로 정렬
		return ob.time - this.time;
	}
}

public class IjC904 {
	static int n, max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		ArrayList<Lecture> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int m = kb.nextInt();
			int d = kb.nextInt();
			arr.add(new Lecture(m, d));
			if (d > max) max = d;
		}
		System.out.println(solution(arr));
	}

	// 해결방안
	// 시간이 큰 값부터 검사, 시간이 큰 값은 작은 시간때도 할 수 있으므로
	// 배열 리스트에 입력값을 시간의 내림차순으로 정렬
	// 입력된 값을 시간이 큰 값부터 우선순위 큐에 집어넣고 다음 시간으로 넘어가기 전에 가장 큰 값을 선택
	// 그 다음 시간에서 우선순위 큐에 남아있는 값 중 가장 큰 값을 선택, 그 이전에 선택되지 않은 값이 크다면 선택 가능하도록
	// 마지막까지 반복하고 선택된 값의 합을 출력
	public static int solution(ArrayList<Lecture> arr) {
		int answer = 0;
		// 큰 값을 우선순위로 저장하는 우선순위 큐
		PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
		Collections.sort(arr);
		int j = 0;
		for (int i = max; i >= 1; i--) {
			for (; j < n; j++) {
				if (arr.get(j).time < i) break; // 꺼낼 값이 시간보다 작아진다면 break하고 다음 시간대로 넘어감
				que.offer(arr.get(j).money); // 시간이 같다면 우선순위 큐에 입력
			}
			if (!que.isEmpty()) answer += que.poll(); // 큐에 있는 값 중 가장 큰 값을 꺼내서 더해줌
		}
		return answer;
	}
}
