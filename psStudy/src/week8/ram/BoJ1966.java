package week8.ram;
import java.util.*;
import java.io.*;
/* 프린터 큐
 * FIFO(First In First Out) : 먼저 요청된 것을 먼저 인쇄
 * ex.프린터 기기
 * 중요도가 높은 것을 우선 배치해준다.
 * 큐 개념 정리하기 /
 */
public class BoJ1966 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while(T-- >0) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		LinkedList<int[]> queue = new LinkedList<>(); //큐로 활용 할 연결 리스트
		st=new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			//{초기 위치,중요도}
			queue.offer(new int[] {i,Integer.parseInt(st.nextToken())});
			
		}
		
		int count = 0;//출력 횟수
		
		while(!queue.isEmpty()) { //한 케이스에 대한 반복문
			
			int[] front = queue.poll(); //가장 첫 원소
			boolean isMax = true; //front 원서가 가장 큰 원소인지를 판단하는 변수
			
			//큐에 남아 있는 원소들과 중요도를 비교
			for(int i=0;i<queue.size();i++) {
				//처음 뽑은 원소보다 큐에 있는 i번째 원소가 중요도가 클 경우
				if(front[1]<queue.get(i)[1]) {
					//뽑은 원소 및 i 이전의 원소들을 뒤로 보낸다.
					queue.offer(front);
					for(int j=0;j<i;j++) {
						queue.offer(queue.poll());
					}
					
					//front원소가 가장 큰 원소가 아니였으므로 false를 하고 탐색을 마침
					isMax = false;
					break;
				}
			}
				
				//front 원소가 가장 큰 원소였으므로 해당 원소는 출력해야하는 문서다.
				count++;
				if(front[0]==M) {//찾고자 하는 문서라면 해당 테스트케이스 종료
					break;
				}
			}

			sb.append(count).append('\n');
			
		}
		System.out.println(sb);
		
		}
	

}
