package week18;

public class PrG43165 {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, target, numbers[0], 1) + dfs(numbers, target, -numbers[0], 1);
        return answer;
    }

    public int dfs(int[] numbers, int target, int sum, int i) {
        if (i == numbers.length) {
            return sum==target? 1 : 0;
        }
        int result = 0;
        result += dfs(numbers, target, sum+numbers[i], i+1);
        result += dfs(numbers, target, sum-numbers[i], i+1);
        //
        return result;
    }
}
