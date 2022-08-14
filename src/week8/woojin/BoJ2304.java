import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BoJ2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        int[] pArr = new int[1001];
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            pArr[x] = y;
            start = Math.min(x, start);
            end = Math.max(x, end);
        }

        int tempY = pArr[start];
        for (int i = start+1; i <= end; i++) {
            if(pArr[i] < tempY)
                s.push(i);
            else {
                while(!s.isEmpty()){
                    int tempX = s.pop();
                    pArr[tempX] = tempY;
                }
                tempY = pArr[i];
            }
        }

        s.clear();

        tempY = pArr[end];
        for (int i = end - 1; i >= start; i--) {
            if(pArr[i] < tempY)
                s.push(i);
            else {
                while(!s.isEmpty()){
                    int tempX = s.pop();
                    pArr[tempX] = tempY;
                }
                tempY = pArr[i];
            }
        }

        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += pArr[i];
        }
        System.out.println(sum);
        br.close();
    }
}
