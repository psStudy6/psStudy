package week15.yumi;

/** 프로그래머스 87946 피로도
 * 
*/
public class PrG87946 {
	
	public static boolean[] visited;
	public static int max;
	
	public int solution(int k, int[][] dungeons) {
        max = 0;
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return max;
    }
	
	public static void dfs(int tired, int[][] dungeons, int cnt){
        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i] && dungeons[i][0] <= tired){
            	// 피로도 - 소모 가정 후 실행
            	visited[i] = true;
                dfs(tired - dungeons[i][1], dungeons, cnt+1);
                visited[i] = false;
            }
        }
        // 최대 던전 도는 경우 찾기
        max = Math.max(max, cnt);
    }
	
	public static void main(String[] args) {
		PrG87946 prg = new PrG87946();
		int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
		System.out.println(prg.solution(80, dungeons));
	}
}
