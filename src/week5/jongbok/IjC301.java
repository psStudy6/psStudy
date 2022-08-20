import java.util.*;
  
public class Main {
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int[] arr1 = new int[110];
    int[] arr2 = new int[110];
    ArrayList<Integer> answer = new ArrayList<>();
    
    int n1 = sc.nextInt();
    for(int i=0; i<n1; i++){
        int num = sc.nextInt();
        arr1[i] = num; 
    }
    
    int n2 = sc.nextInt();
    for(int i=0; i<n2; i++){
        int num = sc.nextInt();
        arr2[i] = num; 
    }
    
    int pos1 = 0;
    int pos2 = 0;
    
    while(pos1 < n1 || pos2 < n2){
       
      if(pos1 == n1){
          answer.add(arr2[pos2++]);
      }else if(pos2 == n2){
          answer.add(arr1[pos1++]); 
      }else{
             
      	if(arr1[pos1] < arr2[pos2]){
           answer.add(arr1[pos1++]);
      	}else{
           answer.add(arr2[pos2++]);
      	}        
      }    
    }
    
    
    for(int i=0; i<answer.size(); i++){
        System.out.print(answer.get(i)+ " "); 
    }
    
    
    return ;
  }
}
