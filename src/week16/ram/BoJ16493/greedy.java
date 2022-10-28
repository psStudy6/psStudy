package week16.src;
import java.util.*;
import java.io.*;

class Table implements Comparable<Table>{
	int ch; 
	int day;//한 챕터를 읽는데 걸리는 시간
	Table(int day,int ch){
		this.day=day;
		this.ch=ch;
	}
	@Override
	public int compareTo(Table o) { //챕터가 가장 큰 순으로 정렬
		if(this.ch==o.ch) return this.day-o.day;//2순위로 day가 작은 순으로 정렬
		else return o.ch-this.ch;
	}
	
}



public class BoJ16493 {
	static int ch;
	static ArrayList<Table> tb;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int day=Integer.parseInt(st.nextToken());
		ch=Integer.parseInt(st.nextToken());
		
		tb = new ArrayList<>();
		
		for(int i=0;i<ch;i++) {
			st=new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tb.add(new Table(a,b));
			
		}
		Collections.sort(tb);
		
		System.out.println(greedy(day));
		
	}
	static int greedy(int day) {
		int ans=0;
		int i=0;
		while(day>0&&i<ch) {
			System.out.println(tb.get(i).day+" "+tb.get(i).ch);
			if(tb.get(i).day<=day) {
				ans+=tb.get(i).ch;
				day-=tb.get(i).day;
			}
			i++;
			
		}
		
		
		
		return ans;
	}

}
