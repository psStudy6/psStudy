package week13.ram;
import java.util.*;
import java.io.*;
/* 씨름선수
 * 
 * 
 */
public class IjC901 {
	static int[][] arr;
	static int N;
	int solution() {
		int ans=0;
		for(int i=0;i<N;i++) {
			int height = arr[i][0];
			int weight = arr[i][1];
			boolean flag = true;
			for(int j=0;j<N;j++) {
				if(height<arr[j][0]&&weight<arr[j][1]) {
					flag=false;
					break;
				}
			}
			if(flag==true) ans++;
		}
		return ans;
		
	}

	public static void main(String[] args) throws IOException{
		IjC901 T = new IjC901();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr=new int[N][N];
		for(int i=0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			arr[i][0]=Integer.parseInt(input[0]);
			arr[i][1]=Integer.parseInt(input[1]);
		}
		System.out.println(T.solution());
	}

}
