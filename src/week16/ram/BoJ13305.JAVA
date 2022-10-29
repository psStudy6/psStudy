package week16.src;
import java.util.*;
import java.io.*;
/* 주유소(실버3)
 * 일직선 도로상에 도시
 * 왼->오
 * 58점
 */
public class BoJ13305 {
	static int N; //도시의 개수
	static long[] distance;//도시와 도시사이 거리
	static long[] city;//도시별 가격
	static long min_cost=0;//최저가격
	//int가 아닌 long으로 해야 100점이 나온다.
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		distance = new long[N-1];
		city = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N-1;i++) {
			distance[i]=Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			city[i]=Integer.parseInt(st.nextToken());
		}
		
		System.out.println(solution());
		
		
		
	}
	static public int solution() {
		int ans=0;
		min_cost = city[0];//최저비용을 첫번째 도시의 단가로 초기화
		
		for(int i=0;i<N-1;i++) {
			if(city[i]<min_cost) {
				//도시의 단가<최저비용=>최저비용 갱신
				min_cost=city[i];
			}
			
			ans+=distance[i]*min_cost;//도시사이거리*최저비용
		}
		return ans;
	}

}
