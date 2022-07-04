/**
 * 문제 제목 : 013. 큰 수 출력하기
 * 강의 시청 : ✔️
 */

// 강의를 보기전 내 방식 -> ✔️(Success)
import java.util.Scanner;

public class IjC201 {

	public static void main(String[] args) {
		IjC113 M = new IjC113();
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println(M.solution(arr));
	}

	public static String solution(int[] arr) {
		StringBuilder sb = new StringBuilder();
		sb.append(arr[0]).append(" ");

		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] < arr[i]) {
				sb.append(arr[i]).append(" ");
			}
		}
		return sb.toString();
	}
}

// =============================================================== //

// 강의내용1
import java.util.*;
class Main {    
    public ArrayList<Integer> solution(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for(int i=1; i<n; i++){
            if(arr[i]>arr[i-1]) answer.add(arr[i]);
        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        for(int x : T.solution(n, arr)){
            System.out.print(x+" ");
        }
    }
}
