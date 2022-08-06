package week7.ram;
import java.util.*;
class IjC405 {
    public int solution(int[] arr, int n, int k){
        int answer=-1;

        // 중복 X + 내림차순
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());

        // 3가지 모든 경우의 수
        // -> 중복 허용 X : ex. 13 34 13 (X), 13 15 34 - 15 13 34 (X)
        // 실제론 i는 n-2, j는 n-1, l은 n까지 돌게된다. for문이 거짓되므로 Tset.add()가 되지않기 때문이다.
        for(int i=0; i<n; i++){
            // 중복으로 또 i를 뽑으면 안되니까 i+1부터 시작
            for(int j=i+1; j<n; j++){
                for(int l=j+1; l<n; l++){
                    // System.out.println(arr[i] + " "+arr[j] +" " +arr[l]);
                    Tset.add(arr[i]+arr[j]+arr[l]);
                }
            }
        }

        int cnt=0;
        for(int x : Tset){
            cnt++;
            if(cnt==k) return x;
        }

        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }

        System.out.print(T.solution(arr, n, k));
    }
}
