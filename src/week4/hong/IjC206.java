/**
 * 문제 제목 : 017. 뒤집은 소수
 * 강의 시청 : ✔️
 */

// 강의를 보기전 내 방식 -> ❌(false)
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static String solution(int n, String[] strArr) {
		String answer = "";		
		ArrayList<Integer> intArr = new ArrayList<Integer>(); // 뒤집은 숫자들
		
		// 뒤집기
		for (String x : strArr) {
			char[] c = x.toCharArray();
			int lt = 0, rt = x.length()-1;
			while (lt<rt) {
				char temp = c[lt];
				c[lt] = c[rt];
				c[rt] = temp;
				lt++;
				rt--;
			}
			x = String.valueOf(c);
			intArr.add(Integer.parseInt(x));
		}
		
		// 소수 검사
		for (int x : intArr) {
			int[] temp = new int[x+1]; // 다 0으로 초기화
			boolean isPrime = false;
			for (int i=2; i<x+1; i++) {
				if (temp[i]==0) { // 소수O
					isPrime = true;
					for (int j=i; j<x+1; j=j+i) {
						temp[j] = 1;
					}
				} else isPrime = false; // temp[i]==1 // 소수X
			}
			if (isPrime) answer += x + " ";
		}
        
		return answer;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String[] strArr = new String[n];
		for (int i=0; i<n; i++) {
			strArr[i] = scanner.next();
		}
		System.out.println(solution(n, strArr));
	}

}


// =============================================================== //

// 강의내용1
import java.util.*;

public class Main {
  public bboolean isPrime(int num) {
    if(num == 1) return false;
    for(int i=2; i< num; i++) {
      if(num%i == 0) return false;
    }
  }
  
  public ArrayList<Integer> solution(int n, int[] arr) {
    ArrayList<Integerrr> answer = new ArrayList<>();
    for(int i=0; i<n; i++) {
  int tmp=arr[i];
      int res=0;
      while(tmp>0) {
       int t=tmp%10;
        res=res*10+t;
        tmp=tmp/10;
      }
      if(isPrime(res)) answer.ass(res);
    }
    return answer;
  }
  
  public static void main(String[] args){
    Main T= new Main();
    Scanner kb = new Scanner(System.in);
    int n = kb.nextInt();
    int[] arr= new int[n];
    for(int i=0; i<n; i++) {
      arr[i] = kb.nextInt();
    }
    for(int x : T,solution(n, arr)) {
      System.out.print(x + " "); 
    }
  }
}
