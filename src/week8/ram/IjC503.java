package week8.ram;
import java.util.*;
import java.io.*;
/* 크레인 인형뽑기(카카오)
 * 
 */
public class IjC503 {
	public static int solution(int[][] board,int n,int[] moves,int m) {
		Stack<Integer> stack = new Stack<>();
		int answer=0;
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++){
				int pos = board[j][moves[i]-1];//크레인 위치
				board[j][moves[i]-1]=0;
				
				if(pos != 0) {
					if(!stack.isEmpty()&&stack.peek()==pos) {
						stack.pop();
						answer +=2;
						
					} else {
						stack.push(pos);
					}
					break;
				}
			}
		}
		return answer;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];
		StringTokenizer st = null;
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			
			for(int j=0;st.hasMoreTokens();j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		int m = Integer.parseInt(br.readLine());
		int[] moves = new int[m];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;st.hasMoreTokens();i++) {
			moves[i]=Integer.parseInt(st.nextToken());
		}
		System.out.println(solution(board,n,moves,m));
		
	}
}
