package week10.ram;
import java.io.*;
/* 완전 이진 트리
 * 중위 순회한 후 
 * 재귀함수와 StringBuffer 배열을 이용하여
 * 각 층의 노드를 출력
 */
public class BoJ9934 {
	static int K;
	static StringBuffer[] ans;
	static int[] arr;
	public static void solve(int s,int e,int floor) {
		if(floor==K)
			return;
		int m=(s+e)/2;
		ans[floor].append(arr[m]+" ");
		
		solve(s,m-1,floor+1);
		solve(m+1,e,floor+1);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		K = Integer.parseInt(br.readLine());
		arr = new int[(int) Math.pow(2, K)-1];//지수승
		
		String[] input = br.readLine().split(" ");
		for(int i=0;i<arr.length;i++)
			arr[i]=Integer.parseInt(input[i]);
		
		ans = new StringBuffer[K]; //각층의 노드를 저장하는 StringBuffer 배열
		for(int i=0;i<K;i++)
			ans[i]=new StringBuffer();
		
		solve(0,arr.length-1,0);
		
		for(int i=0;i<K;i++)
			bw.write(ans[i].toString()+"\n");
		bw.flush();
	}

}
