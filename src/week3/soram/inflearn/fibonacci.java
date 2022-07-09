
//자바 알고리즘 4.피보나치 수열 + 배열을 쓰지 않는 경우
import java.io.IOException;
import java.util.*;

class Main {  
public void solution(int n){
	int a=1,b=1,c;
	System.out.print(a+" "+b+" ");
	for(int i=2;i<n;i++) {
		c=a+b;
		System.out.print(c+" ");
		a=b;
		b=c;
	}

}

public static void main(String args[]) throws IOException{ 
  Main T =new Main();
  Scanner kb = new Scanner(System.in);
  int n=kb.nextInt();
  T.solution(n);

  
 kb.close();
  
  
  
}
}
