package week8.yumi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/** 백준 2304 창고 다각형
 * 실버2
 * 
 * 문제 : N 개의 막대 기둥이 일렬로 세워져 있다. 
 * 		기둥들의 폭은 모두 1 m이며 높이는 다를 수 있다.
 * 		1. 지붕은 수평 부분과 수직 부분으로 구성되며, 모두 연결되어야 한다.
 * 		2. 지붕의 수평 부분은 반드시 어떤 기둥의 윗면과 닿아야 한다.
 * 		3. 지붕의 수직 부분은 반드시 어떤 기둥의 옆면과 닿아야 한다.
 * 		4. 지붕의 가장자리는 땅에 닿아야 한다.
 * 		5. 비가 올 때 물이 고이지 않도록 지붕의 어떤 부분도 오목하게 들어간 부분이 없어야 한다.
 * 		기둥들의 위치와 높이가 주어질 때, 가장 작은 창고 다각형의 면적
 * 
 * 핵심 : 양쪽 높이 보다 낮은 경우 고려하지 않음
 * 		 막대기들 중 제일 높은 막대기가 1개일 경우 = +높이
 * 		 막대기가 1개일 경우 높이 리턴
*/
public class BoJ2304 {
	
	// 방법1 : stack을 사용함
	public int solution(int[][] arr) {
		int tot = 0;
		Stack<Integer> width = new Stack<>();
		Stack<Integer> height = new Stack<>();
		// x축을 오름차순으로 정렬
		Arrays.sort(arr, (o1, o2) -> {return o1[0] - o2[0];});
		// 막대가 1개일 경우 막대 자체가 창고임 - 높이 리턴
		if (arr.length == 1) {
			return arr[0][1];
		}
		// 첫번째 값 세팅
		width.push(arr[0][0]);
		height.push(arr[0][1]);
		// 두번째부터 탐색
		for (int i = 1; i < arr.length; i++) {
			int w = arr[i][0];
			int h = arr[i][1];
			// 기존 높이 <= 현재 높이
			if (height.peek() <= h) {
				while (!width.empty() && height.peek() <= h) {
					// stack 시작점부터 현재 막대기 전까지의 너비 
					if (width.size() == 1) {
						tot += (w - width.peek()) * height.peek();
					}
					// 기존 높이 제거 - 양쪽 높이 보다 낮은 경우
					width.pop();
					height.pop();
				}
			}
			// 마지막 막대기
			if (i == arr.length-1) {
				// 기존 높이 > 현재 높이
				while (!width.empty()) {
					// 이전 막대기부터 현재 막대기까지의 너비비
					tot += (w - width.peek()) * h;
					w = width.pop();
					h = height.pop();
				}
				// stack 시작 막대기 = stack에 있던 막대기들 중 제일 높은 막대기
				tot += h;
				break;
			}
			width.push(w);
			height.push(h);
		}
		return tot;
	}
	
	public static void main(String[] args) throws IOException {
		BoJ2304 boj = new BoJ2304();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		System.out.println(boj.solution(arr));
	}
	
	
	
	
	
	
	// 방법2 : x축 만큼의 배열을 생성한 후 더 큰 높이가 나올 때까지 현재 높이로 계속 더함 
	public int solution2(int[] arr, int maxIdx) {
		int tot = 0, tmpH = 0;
		// x축 0부터 최대 높이 인덱스까지 높이 더함
		for (int i = 0; i <= maxIdx; i++) {
			// 기존 높이 < 현재높이
			if (tmpH < arr[i]) {
				tmpH = arr[i];
			}
			// 더 큰 높이가 나올 때까지 현재 높이로 계속 더함 
			tot += tmpH;
		}
		tmpH = 0;
		// x축 1000부터 최대 높이 인덱스전까지 높이 더함
		for (int i = 1000; i > maxIdx; i--) {
			// 기존 높이 < 현재높이
			if (tmpH < arr[i]) {
				tmpH = arr[i];
			}
			// 더 큰 높이가 나올 때까지 현재 높이로 계속 더함 
			tot += tmpH;
		}
		return tot;
	}
	
	public static void main2(String[] args) throws IOException {
		BoJ2304 boj = new BoJ2304();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[1001]; // 1 <= n <= 1000
		int maxH = 0, maxIdx = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			arr[idx] = h;
			if (maxH < h) {
				maxH = h;
				maxIdx = idx;
			}
		}
		System.out.println(boj.solution2(arr, maxIdx));
	}
}
