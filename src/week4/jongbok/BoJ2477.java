package week4.jongbok;
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
           
           // direction이 1이나 2일 때는 동 or 서를 의미하고,
           // 그중 최대값을 widthMax에 저장한다. 
           if(direction == 1 || direction == 2){
               widthMax = Math.max(widthMax, length);
           }
           // direction이 3이나 4일 때는 남 or 북을 의미하고,
           // 그중 최대값을 heightMax에 저장한다. 
           else{
               heightMax = Math.max(heightMax, length);
           }
       }
       
       
       for(int i=0; i<6; i++){
           
           int beforeDir = (i+5)%6;
           int nextDir = (i+1)%6;
           
           // 이전 값의 방향과 이후 값의 방향이 같다면, 그 지점은 사각형의 움푹 패인 지점을 의미함
           // 이 때, 방향에 따라서 방향이 1이나 2면 widthMin에
           // 3이나 4면 heightMin에 값을 저장함 
           if(dir[beforeDir] == dir[nextDir]){
               if(dir[i] == 1 || dir[i] == 2){
                   widthMin = len[i];
               }else{
                   heightMin = len[i];
               }
           }
       }
       
       // 최종 결과를 구함
       answer = N*((widthMax*heightMax)-(widthMin*heightMin));
       
       System.out.println(answer);
     
     
    }
}
