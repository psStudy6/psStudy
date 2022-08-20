package week9.ram;
import java.util.*;
import java.io.*;
/* 수정렬하기 2
 * N의 범위 : 1~10^6 
 * ->quick sort를 사용하더라도 시간복잡도가
 * average case는 O(nlog n)이지만 
 * worst case의 경우 O(n^2)이므로 10^12이므로 시간초과가 나온다.
 * Array.sort를 사용하면 안된다.
 * Collection.sort()<-Timsort 사용(합병+삽입정렬)
 * hybrid stable sorting algorithm
 * https://st-lab.tistory.com/276
 */
public class BoJ2751 {
	public static void main(String[] args) throws IOException {
    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		// list 계열 중 하나를 쓰면 된다.
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list);
		
		for(int value : list) {
			sb.append(value).append('\n');
		}
		System.out.println(sb);
	}
}
