class Solution {
    static int[] numbers;
    static int target,ans=0;
    public int solution(int[] numbers, int target) {
        this.numbers=numbers;//static으로 선언해놓은 함수 input 값을 입력
        this.target=target;// 
        dfs(0,0);
        return ans;
    }
    void dfs(int sum,int depth){//node의 depth를 찾는 것
        if(depth==numbers.length){
            if(sum==target) ans++;
            return;
        }
        
        //numbers[depth] : depth번째의 수
        dfs(sum+numbers[depth],depth+1);
        dfs(sum-numbers[depth],depth+1);
        
    }
}
