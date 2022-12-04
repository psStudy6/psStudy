package week18.woojin;

public class PrG43165 {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, target, numbers[0], 1) + dfs(numbers, target, -numbers[0], 1);

        return answer;
    }

    public int dfs(int[] numbers, int target, int current, int index){
        if(index == numbers.length) {
            if(current == target)
                return 1;
            else
                return 0;
        }

        int result = 0;
        result += dfs(numbers, target, current+numbers[index], index+1);
        result += dfs(numbers, target, current-numbers[index], index+1);
        return result;
    }
}
