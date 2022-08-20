/**
 * 등록 번호 : 9322번  
 * 등록 제목 : 철벽 보안 알고리즘
 * 현재 상태 : 완료 ✔️
 */
package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
  /** 문제의 이해 
   * 처음에 문제를 이해하기 위해서 여러번 지문을 읽어봤지만 이해가 되지 않아서 
   * 스터디원들에게 질문을 통해서 해당 답변을 통해서 이해를 하였다. -> 나는 0개 국어자인거 같다... 문제보다 지문이 이해 하기 어렵다. ㅠㅠ
   * 제 1 공개 키 공략. 
     1번 데이터 : A B C D -> 0 1 2 3
     2번 데이터 : D A B C -> 3 0 1 2
     3번 데이터 : C B A P -> 3 0 1 2
     4번 데이터 : 여기 올 데이터는 0 1 2 3으로 원복시켜야한다. 즉. B A P C 가 출력되어야한다.
   * 제 2 공개 키 공략
     1번 데이터 : SECURITY THROUGH OBSCURITY -> 0 1 2
     2번 데이터 : OBSCURITY THROUGH SECURITY -> 2 1 0
     3번 데이터 : TOMORROW ATTACK WE -> 2 1 0
     4번 데이터 : 여기 올 데이터는 0 1 2으로 원복시켜야한다. 즉 WE ATTACK TOMORROW으로 출력되어야한다.
   */
	public static void main(String[] args) throws IOException {
		long s_time = System.currentTimeMillis();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.valueOf(st.nextToken());
		for(int i=1; i<=T; i++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.valueOf(st.nextToken());
			HashMap<String, Integer> map = new HashMap<>();
			int nomal[] = new int[N];
			
			// 1번째 관문 : Data setting - Hasmap<inputString , LocationNumber> 
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				String key = st.nextToken();
				map.put(key, j);
			}

			// 2번째 관문 : pattren Abaktsis - LocationValue
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				String key = st.nextToken();
				nomal[j]=map.get(key);
			}

			
			// 3번째 관문 : Restoration the pattren - LocationValue 
			st = new StringTokenizer(br.readLine());
			String res[] = new String[N];
			for(int j=0; j<N; j++) {
				res[nomal[j]] = st.nextToken();
			}
			
			long e_time = System.currentTimeMillis();
			double d_time = (double)(e_time - s_time)/1000;
			System.out.println("process time : " + d_time);

			// answer the data
			for(int j=0; j<N; j++) {
				System.out.print(res[j]+" ");
			}
			System.out.println();
		}
	}
}
