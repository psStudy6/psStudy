/**
 * 문제 제목 : 036. 매출액의 종류
 * 강의 시청 : ✔️
 */

// 강의를 보기전 내 방식 -> ✔️ (Success)
import java.util.*;
  
public class Main {
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);

    int n = in.nextInt();
    int k = in.nextInt();
    int[] arr = new int[n];
    for(int i=0; i<n; i++){
      arr[i] = in.nextInt();
    }
    List<Integer> answer = new ArrayList<>();

    HashMap<Integer, Integer> map = new HashMap<>();

    for(int i=0; i<k-1; i++){
        map.put(arr[i], map.getOrDefault(arr[i],0)+1);
    }

    int lt=0;
    for(int rt=k-1; rt<n; rt++){
        map.put(arr[rt],map.getOrDefault(arr[rt],0)+1);
        answer.add(map.size());
        map.put(arr[lt], map.get(arr[lt])-1);

        if(map.get(arr[lt])==0){
            map.remove(arr[lt]);
        }
        lt++;
    }

    for(int a: answer){
        System.out.print(a + " ");
    }
  }
}

// =============================================================== //

import java.util.*;

public class Main {
    public ArrayList<Integer> solution(int n, int k, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<k; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        answer.add(map.size());

        for(int i=k; i<n; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);

            if(map.get(arr[i-k])==1){
                map.remove(arr[i-k]);
            }else{
                map.put(arr[i-k], map.getOrDefault(arr[i-k], 0)-1);
            }

            answer.add(map.size());
        }

        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int k=kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }

        for(int x : T.solution(n, k, arr)){
            System.out.print(x+" ");
        }

    }
}
