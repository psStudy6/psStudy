package week4.jongbok;
import java.util.Scanner;
  
public class Main {
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int answer = 0; 
    int N = sc.nextInt();
    int[][] arr = new int[N+1][N+1];
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            int num = sc.nextInt();
            arr[i][j] = num;
        }
    }

       
    for(int i=0; i<N; i++){
        for(int j=0; j<N;j++){
            
            int cnt = 0; 
            
            for(int k=0; k<4; k++){
                int ni = i + dx[k];
                int nj = j + dy[k];
                
                if(0<=ni && ni<N && 0<=nj && nj<N){
                    if(arr[ni][nj] < arr[i][j]){
                        cnt++;
                    }
                }else{
                    cnt++;
                }
            }
            
            if(cnt == 4){
                answer++;
            }
            
        }
    }
    
    System.out.println(answer);
    
    
    
    return ;
  }
}
