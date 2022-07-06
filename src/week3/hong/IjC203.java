/**
 * 문제 제목 : 015. 가위 바위 보
 * 강의 시청 : ✔️
 */

// 강의를 보기전 내 방식 -> ✔️(Success)
import java.util.Scanner;

public class Ijc203 {
	public char[] solution(int cnt, int[][] arr) {
		char[] answer = new char[cnt];
		for (int i = 0; i < cnt; i++) {
			// CheckPoint2-1. A == B
			if (arr[0][i] == arr[1][i])
				answer[i] = 'D';
			// CheckPoint2-2. A > B
			else if (arr[0][i] == 1 && arr[1][i] == 3)
				answer[i] = 'A';
			// CheckPoint2-3. A < B
			else if (arr[0][i] == 3 && arr[1][i] == 1)
				answer[i] = 'B';
			// CheckPoint2-4. 변수(?)
			else {
				// CheckPoint3. 승리자 select
				if (arr[0][i] > arr[1][i])
					answer[i] = 'A';
				else
					answer[i] = 'B';
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Ijc203 main = new Ijc203();
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();

		// CheckPoint1. 이중 배열을 통한 데이터 넣기
		int[][] arr = new int[2][cnt];
		for (int i = 0; i < 2; i++) {
			for (int k = 0; k < cnt; k++) {
				arr[i][k] = sc.nextInt();
			}
		}

		for (char x : main.solution(cnt, arr)) {
			System.out.println(x);
		}
	}
}

// =============================================================== //

// 강의내용1
import java.util.*; 

public class Main {
	public String solution(int n, int[] a, int[] b){
		String answer="";
		for(int i=0; i<n; i++){
			if(a[i]==b[i]) answer+="D";
			else if(a[i]==1 && b[i]==3) answer+="A";
			else if(a[i]==2 && b[i]==1) answer+="A";
			else if(a[i]==3 && b[i]==2) answer+="A";
			else answer+="B";
		}
		return answer;
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);	
		int n=kb.nextInt();
		int[] a=new int[n];
		int[] b=new int[n];
		
    for(int i=0; i<n; i++){
			a[i]=kb.nextInt();
		}
		for(int i=0; i<n; i++){
			b[i]=kb.nextInt();
		}		

		for(char x : T.solution(n, a, b).toCharArray()) System.out.println(x);	
	}
}
