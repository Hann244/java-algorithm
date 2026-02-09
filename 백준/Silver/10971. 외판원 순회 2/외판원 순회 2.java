
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N = 0;
	static int[][] W;
	static boolean[] visited;
	static int minCost = Integer.MAX_VALUE; // 최소 비용을 저장할 변수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		W = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 어느 도시에서 시작해도 순환 구조이므로 결과는 동일
		// 0번(1번 도시)에서 시작
		visited = new boolean[N];
		visited[0] = true;
		
		// dfs(현재 위치, 방문한 도시 수, 현재까지의 누적 비용)
		dfs(0, 1, 0);
		
		System.out.println(minCost);
	}
	
	private static void dfs(int now, int count, int sum) {
		// 종료 조건 : 모든 도시를 방문했을 때
		if (count == N) {
			// 마지막 도시에서 다시 시작 도시(0번)로 돌아갈 수 있는지 확인
			if (W[now][0] != 0) {
				// 돌아가는 비용까지 합산해서 최솟값 갱신
				minCost = Math.min(minCost, sum + W[now][0]);
			}
			return;
		}
		
		// 가지치기(선택 사항) : 현재 누적 비용이 이미 알고 있는 최솟값보다 크면 더 갈 필요 없음
		if (sum >= minCost) return;
		
		// 다음 도시 탐색
		for (int i = 0; i < N; i++) {
			// 아직 방문하지 않았고, 현재 도시에서 그 도시로 가는 길이 있다면
			if (!visited[i] && W[now][i] != 0) {
				visited[i] = true; // 방문 표시 (상태 변화)
				
				// 다음 도시로 이동 (누적 비용에 합산, 방문수 + 1)
				dfs(i, count + 1, sum + W[now][i]);
				
				visited[i] = false; // 백트래킹 : 다른 경로를 위해 방문 표시 해제
			}
			
		}
	}

}
