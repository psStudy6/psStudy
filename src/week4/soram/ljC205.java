package week4.soram;
import java.util.*;
//인프런 5.소수(에라토스테네스 체)
//소수의 정의 : 1과 그 수 자신 이외의 자연수로는 나눌 수 없는 자연수
//소수를 구하는 방법 중 에라토스테네스 체로 푸는 것이 가장 빠르다.
class IjC205 {  
	public int solution(int n){//강의 소스
		int answer = 0;
		int[] ch = new int[n+1]; //index 번호를 맞추기위해 n+1 개의 배열 선언
		for(int i=2;i<=n;i++){ //i(2~n) for문을 돌리면서 배열 값이 0인 곳을 찾고 소수를 counting한다.
			if(ch[i]==0){
				answer++;
				for(int j=i;j<=n;j=j+i) ch[j]=1;//소수의 배수를 찾아서 해당 배열 값을 1로 초기화한다.
			}
		}
		return answer;  
	}
	public int solution1(int n){//made by me , timeout
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
		IjC205 T = new IjC205();
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		System.out.println(T.solution(input));

	} 
}
