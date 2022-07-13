package ju;
import java.util.*;
//인프런 5.소수(에라토스테네스 체)
//소수의 정의 : 1과 그 수 자신 이외의 자연수로는 나눌 수 없는 자연수
class Main {  
public int solution(int n){//made by me , timeout
ArrayList<Integer> list = new ArrayList<>();
int count=0;
int half;
if(n>=2)list.add(2);
for(int j=3;j<=n;j=j+2){//2보다 큰 짝수는 소수가 될 수 없다.
	  half = j/2;
  for(int i=2;i<=half;i++){ //20의 경우 최대 약수는 10이다.
    //j가 2~n일 때 loop를 돌며 j가 소수인지 검사
    if(j%i == 0) count++;
  }
  if(count==0) list.add(j);
  count=0;
}
return list.size();

}  
public static void main(String args[]) { 
Main T = new Main();
Scanner sc = new Scanner(System.in);
int input = sc.nextInt();
System.out.println(T.solution(input));

} 
}
