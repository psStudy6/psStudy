import java.util.*; 


public class Main {
    
  public static void main(String args[]) {
     
       Scanner sc = new Scanner(System.in);
       int N = sc.nextInt(); 
       int answer = 0; 
       int[] dir = new int[6];
       int[] len = new int[6];
       
       int widthMax = Integer.MIN_VALUE;
       int heightMax = Integer.MIN_VALUE;
       int widthMin = Integer.MAX_VALUE;
       int heightMin = Integer.MAX_VALUE;
       
       int max = Integer.MIN_VALUE;
       
       for(int i=0; i<6; i++){
           int direction = sc.nextInt();
           int length = sc.nextInt();
           dir[i] = direction;
           len[i] = length;
           
           if(direction == 1 || direction == 2){
               widthMax = Math.max(widthMax, length);
           }else{
               heightMax = Math.max(heightMax, length);
           }
       }
       
       
       for(int i=0; i<6; i++){
           
           int beforeDir = (i+5)%6;
           int nextDir = (i+1)%6;
           
           if(dir[beforeDir] == dir[nextDir]){
               if(dir[i] == 1 || dir[i] == 2){
                   widthMin = len[i];
               }else{
                   heightMin = len[i];
               }
           }
       }
       
       
       answer = N*((widthMax*heightMax)-(widthMin*heightMin));
       
       System.out.println(answer);
     
     
    }
}
