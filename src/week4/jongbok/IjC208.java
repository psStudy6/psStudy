package week4.jongbok;
import java.util.*;
  
public class Main {
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    ArrayList<Integer> origin = new ArrayList<>(); 
    ArrayList<Integer> arr = new ArrayList<>();
    int n = sc.nextInt(); 
    int answer = 0; 
    
    for(int i=0; i<n; i++){
      int num = sc.nextInt();
      origin.add(num);
      arr.add(num);
    }

    Collections.sort(arr, Collections.reverseOrder());
    
    int size = origin.size(); 
    
    for(int i=0; i<size; i++){
        int num = origin.get(i);
        int cnt = 1;
        
        for(int j=0; j<size; j++){
            if(arr.get(j) == num){
                break;
            }else{
                cnt++;
            }
        }
        
        System.out.print(cnt+ " ");
    }
  }
}
