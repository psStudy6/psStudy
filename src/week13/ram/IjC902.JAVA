package week13.ram;
import java.util.*;
import java.io.*;
/* 회의실 배정
 * 겹치지않게 회의실을 사용할 수 있는 최대 수의 회의
 * 중단X
 * 회의이 끝나는 시간으로 먼저 오름차순 정렬
 * 가장 먼저 끝나는 회의를 하나 넣고
 * 그 다음번부터 그 전회의의 끝나는 시간보다 시작시간이 같거나 큰 경우를 차례때로 체크
 * 끝 시간이 같은 경우도 있으므로 끝시간 같은 경우는 시작시간으로 오름차순 정렬
 */
class Time implements Comparable<Time>{
	public int start,end;
	Time(int start,int end){
		this.start=start;
		this.end=end;
	}
	
	@Override
	public int compareTo(Time o) {//object가 더 크면 음수 리턴,this가 더 크면 양수 리턴
		if(this.end == o.end) return this.start - o.start;
		//끝나는 시간으로 오름차순
		else return this.end - o.end;//끝나는 시간으로 오름차순
	}
}
public class IjC902 {
	static int N;
	static ArrayList<Time> arr;
	public int solution() {
		int ans=0,et=0;
		System.out.println();
		Collections.sort(arr);
		for(Time ob : arr) {
			if(ob.start >= et) {
				ans++; //회의 하나 추가하고
				et = ob.end; //끝나는 시간 변경
			}
		}
		
		
		return ans;
		
	}
	public static void main(String[] args) throws IOException{
		IjC902 T = new IjC902();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			
			arr.add(new Time(x,y));
		}
		System.out.println(T.solution());
	}
}
