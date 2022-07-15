import java.util.*;
import java.math.*;

class Main {
    
    
    public long fibonacci(BigInteger a, BigInteger b){
        
        long cnt = 0; 
        ArrayList<BigInteger> arr = new ArrayList<BigInteger>();
        arr.add(new BigInteger("1"));
        arr.add(new BigInteger("2"));
        
        if(a.compareTo(arr.get(0)) <= 0  && (arr.get(0)).compareTo(b) <= 0){
                cnt++;
        }
        
        if(a.compareTo(arr.get(1)) <= 0  && (arr.get(1)).compareTo(b) <= 0){
                cnt++;
        }
        
        while(true){
            
            int len = arr.size();
            
            BigInteger tmp = arr.get(len-2).add(arr.get(len-1));
            
            if( a.compareTo(tmp) <= 0  && tmp.compareTo(b) <= 0){
                cnt++;
            }
            
            if(b.compareTo(tmp) == -1){
                break;   
            }
            
            arr.add(tmp);
        }
        
        
        return cnt; 
    }
    
    public static void main(String args[]) {
      Main c = new Main();
      Scanner sc = new Scanner(System.in);
      
      while(true){
         StringTokenizer st=new StringTokenizer(sc.nextLine());
	       BigInteger a = new BigInteger(st.nextToken());
	       BigInteger b = new BigInteger(st.nextToken());
          
           if(a.compareTo(BigInteger.valueOf(0))==0&&b.compareTo(BigInteger.valueOf(0))==0) break;
           long result = c.fibonacci(a, b);
           System.out.println(result);
      }
      

    }
}
