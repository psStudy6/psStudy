import java.util.*;
class ReversePrimeNumber {  
public ArrayList<Integer> solution(int n,int[] arr){
  ArrayList<Integer> answer = new ArrayList<>();
  for(int i=0 ; i<n ; i++){
    int tmp = arr[i]; //
    int b = 0;
    while(tmp > 0){
      int c = tmp % 10; //나머지 연산으로 tmp의 일의자리 수를 구함
      b = b * 10 + c ; //처음엔 b에 일의 자리 수가 들어감
      tmp = tmp / 10 ; //다시 둘째자리부터 같은 연산 반복
    }
    if(isPrime(b)) answer.add(b);
    }
  return answer;
  
}
public boolean isPrime(int num){
if(num == 1) return false;
for(int i=2 ; i<num ; i++){
  if(num % i == 0) return false;
}
return true;
}
public static void main(String args[]) { 
 ReversePrimeNumber T = new ReversePrimeNumber();
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  int[] arr = new int[n];
  for(int i=0;i<n;i++){
    arr[i] = sc.nextInt();
  }
	for(int x : T.solution(n,arr)){
		System.out.print(x+" ");
} 
}
}
