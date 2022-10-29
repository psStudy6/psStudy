import java.util.*;

/* 피로도 시스템
* 최소 필요 피로도 : 시작 조건
* 소모 피로도 : 던전 돌때 감소되는 양
* 최대한 많은 던전 돌기
* k = 현재 피로도
* 완전탐색 dfs로 진행
* 그리디일 때는 반례가 존재
*/

class PrG87946 {
	public static int answer=0;
	public static boolean[] visited;
	public static int solution(int k, int[][] dungeons) {

		visited = new boolean[dungeons.length];
		dfs(k,dungeons,0);

		return answer;
	}
	private static void dfs(int k,int[][] dungeons,int depth){
		for(int i=0;i<dungeons.length;i++){
			if(!visited[i]&&dungeons[i][0]<=k){
				visited[i]=true;
				dfs(k-dungeons[i][1],dungeons,depth+1);
				visited[i]=false;
			}
		}
		answer = Math.max(answer,depth);
	}
	public static void main(String[] args) {
		int[][] arr = {
				{80,20},{50,40},{30,10}
		};
		System.out.println(solution(80,arr));
	}
}
