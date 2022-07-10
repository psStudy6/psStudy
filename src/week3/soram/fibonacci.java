import java.io.*;
import java.math.BigInteger;
import java.util.*;
class Main {  
//오류..예제는 괜찮지만 딱 a나 b값일 때 포함을 못하는 경우에서 틀리지않았나	

public int solution(BigInteger a,BigInteger b){
	List<BigInteger> fibo = new ArrayList<>();
	int a_num=0,b_num=0;
	//0~b 사이에 있는 피보나치를 모두 구함
	
	fibo.add(new BigInteger("1"));
	fibo.add(new BigInteger("2"));
	
	for(int j=2;;j++) {
		
		BigInteger result = fibo.get(j-1).add(fibo.get(j-2));
		if(result.compareTo(b)==1) {//result>b시 arraylist에 저장하지않고 for문 종료
			b_num = fibo.size();
			break;
		}
		fibo.add(result);
		if(result.compareTo(a)==0&&result.compareTo(b)==0)a_num=fibo.size();
        //result>=a인순간 a_num 입력을 종료
	}
	
	
		
		
	
	
	
	
	return b_num-a_num;
	
	

}


public static void main(String args[]) throws IOException{ 
  Main T =new Main();
  Scanner sc = new Scanner(System.in);
  //BigInteger a = new BigInteger(sc.next());
  //BigInteger b = new BigInteger(sc.next());
  //ArrayList<Integer> list =new ArrayList<>();
  
  
  
  
  while(true) {
	  StringTokenizer st=new StringTokenizer(sc.nextLine());
	  BigInteger a = new BigInteger(st.nextToken());
	  BigInteger b = new BigInteger(st.nextToken());
	  
	  if(a.compareTo(BigInteger.valueOf(0))==0&&b.compareTo(BigInteger.valueOf(0))==0) break;
	  System.out.println(T.solution(a, b));
	  
  }
 
  
	sc.close();

  
}
}
