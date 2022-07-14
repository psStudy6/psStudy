import java.util.*;
//인프런 5.소수(에라토스테네스 체)
//소수의 정의 : 1과 그 수 자신 이외의 자연수로는 나눌 수 없는 자연수
class Main {  
public int solution1(int n){//made by me , timeout
  //int[] arr=new int[n];
  int num=0,count=0;
  int half;
  for(int j=2;j<=n;j++){
	  half = j/2;
    for(int i=2;i<=half;i++){ //20의 경우 최대 약수는 10이다.
      //j가 2~n일 때 loop를 돌며 j가 소수인지 검사
      if(j%i == 0) count++;
    }
    if(count==0) num++;
    count=0;
  }
  return num;
}  

public static void main(String args[]) { 
  Main T = new Main();
  Scanner sc = new Scanner(System.in);
  int input = sc.nextInt();
  System.out.println(T.solution1(input));
  sc.close();
} 
}
