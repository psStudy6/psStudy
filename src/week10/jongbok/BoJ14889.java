import java.util.*;

public class Main {
    
    public static int N;
    public static int[][] arr;
    public static boolean[] checked;
    public static int minDiff; 
    
    public void DFS(ArrayList<Integer> selected){
        
        if(selected.size() == (N/2)){
            
            ArrayList<Integer> unselected = new ArrayList<>();
            
            int selectedSum = 0;
            int unselectedSum = 0; 
            
            for(int i=1; i<=N; i++){
                
                boolean isSelected = false;
                
                for(int j=0; j<selected.size(); j++){
                    if(selected.get(j) == i){
                        isSelected = true;
                        break;
                    }
                }
                
                if(isSelected == false){
                    unselected.add(i);
                }
            }
            
            for(int i=0; i<selected.size(); i++){
                for(int j=0; j<selected.size(); j++){
                    if(i != j){
                        selectedSum += arr[selected.get(i)][selected.get(j)];
                    }
                }
            }
            
            
            for(int i=0; i<unselected.size(); i++){
                for(int j=0; j<unselected.size(); j++){
                    if(i != j){
                        unselectedSum += arr[unselected.get(i)][unselected.get(j)];
                    }
                }
            }
            
            minDiff = Math.min(minDiff, Math.abs(selectedSum-unselectedSum));
            
            return; 
        }
        
        int nextNum;
        if(selected.isEmpty()){
            nextNum = 1;
        }else{
            nextNum = selected.get(selected.size()-1)+1;
        }
        
        for(int i=nextNum; i<=N; i++){
            if(checked[i] == false){
                checked[i] = true;
                selected.add(i);
                DFS(selected);
                selected.remove(selected.size()-1);
                checked[i] = false;
            }
        }
        
        
    }
    
    
    public static void main(String args[]) {
      
      Main K = new Main();
      
      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();
      arr = new int[N+1][N+1];
      checked = new boolean[N+1];
      minDiff = Integer.MAX_VALUE; 
      
      for(int i=1; i<=N; i++){
          for(int j=1; j<=N; j++){
              int num = sc.nextInt();
              arr[i][j] = num;
          }
      }
      
      ArrayList<Integer> selected = new ArrayList<>();
      
      K.DFS(selected);
      
      System.out.println(minDiff);
      
      
    }
}
