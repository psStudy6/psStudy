import java.util.*;
  
public class Main {
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n = sc.nextInt();
    ArrayList<Integer> arrA = new ArrayList<>();
    ArrayList<Integer> arrB = new ArrayList<>();
    
    for(int i=0; i<n; i++){
       int num = sc.nextInt();
       arrA.add(num);
    }
    
    for(int i=0; i<n; i++){
       int num = sc.nextInt();
       arrB.add(num);
    }  
    
    for(int i=0; i<n; i++){
     
       if(arrA.get(i) == arrB.get(i)){
          System.out.println("D"); 
       }else{
         if(arrA.get(i) == 1){
            if(arrB.get(i) == 3){
              System.out.println("A"); 
            }else{
              System.out.println("B");
            }  
         }else if(arrA.get(i) == 2){
            if(arrB.get(i) == 1){
              System.out.println("A"); 
            }else{
              System.out.println("B");
            }
         }else if(arrA.get(i) == 3){
           if(arrB.get(i) == 2){
              System.out.println("A"); 
            }else{
              System.out.println("B");
            }
         }
       } 
    }
    
    return ;
  }
}
