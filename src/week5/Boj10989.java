import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
   public static void main(String args[]) throws IOException {
     
       
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
       int N = Integer.parseInt(br.readLine());
       int[] arr = new int[10010];
       
       for(int i=0; i<N; i++){
           arr[Integer.parseInt(br.readLine())]++;
       }
       
       br.close();
        
       StringBuilder sb = new StringBuilder();
        
       for(int i=1; i<=10000; i++){
           int cnt = arr[i];
           if(cnt == 0){
               continue;
           }
           while(cnt > 0){
               sb.append(i).append('\n');
               cnt--;
           }
       }
       
       System.out.println(sb);
     
    }
}
