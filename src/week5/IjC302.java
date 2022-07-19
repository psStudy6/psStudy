import java.util.*;
  
public class Main {
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    ArrayList<Integer> arr1 = new ArrayList<>();
    ArrayList<Integer> arr2 = new ArrayList<>();
    ArrayList<Integer> answer = new ArrayList<>();
    
    int n1 = sc.nextInt();
    for(int i=0; i<n1; i++){
        int num = sc.nextInt();
        arr1.add(num);
    }
    
    int n2 = sc.nextInt();
    for(int i=0; i<n2; i++){
        int num = sc.nextInt();
        arr2.add(num); 
    }
    
    Collections.sort(arr1);
    Collections.sort(arr2);
    
    int pos1 = 0;
    int pos2 = 0;
    
    while(pos1 < n1 && pos2 < n2){
       if(arr1.get(pos1) < arr2.get(pos2)){
           pos1++;
       }else if(arr1.get(pos1) > arr2.get(pos2)){
           pos2++;
       }else{
           answer.add(arr1.get(pos1));
           pos1++;
           pos2++;
       }
       
    }
    
    
    for(int i=0; i<answer.size(); i++){
        System.out.print(answer.get(i)+ " "); 
    }
    
    
    return ;
  }
}
