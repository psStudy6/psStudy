package week12.ram;
import java.util.*;
import java.io.*;
/* 바이러스
 * 네트워크(무방향 그래프)
 */
public class BoJ2606 {
	static ArrayList<ArrayList<Integer>> arr;
	static boolean check[];
	static int ans=0;
	static int dfs(int v) {
		for(int i=0;i<arr.get(v).size();i++) {
			if(check[arr.get(v).get(i)]==false) {
				check[arr.get(v).get(i)]=true;
				ans++;
				dfs(arr.get(v).get(i));
			}
		}
		
		return ans;
		}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		arr = new ArrayList<ArrayList<Integer>>();
		
		check = new boolean[N+1];
		
		//ArrayList 객체 안에 요소로써 ArrayList 객체를 생성
		for(int i=0;i<=N;i++) { 
			arr.add(new ArrayList<Integer>());
			
		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		check[1]=true;
		dfs(1);
		System.out.println(ans);
		
	}

}
