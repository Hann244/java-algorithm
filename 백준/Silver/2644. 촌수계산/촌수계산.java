import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map = new int[101][101];
	static boolean[] visited = new boolean[101];
	static int n;
	static int result = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 전체 사람의 수
		n = Integer.parseInt(br.readLine());
		
		// 촌수를 계산해야 되는 서로 다른 두 사람의 번호
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		// 부모 자식들 간의 관계의 개수
		int m = Integer.parseInt(br.readLine());
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			
			// 부모
			int x = Integer.parseInt(st.nextToken());
			// 자식
			int y = Integer.parseInt(st.nextToken());
			// 촌수는 양방향(부모 -> 자식 : 1촌 / 자식 -> 부모 : 1촌)
			map[x][y] = map[y][x] = 1;
		}
		
		dfs(start, end, 0); // 0촌부터 탐색 시작
		System.out.print(result);
	}
	
	static void dfs(int current, int target, int count) {
		// 현재 사람 방문 처리
		visited[current] = true;
		
		// 방문한 사람을 찾은 경우
		if (current == target) {
			result = count; // 현재까지의 촌수를 정답에 저장
			return; // 더 탐색할 필요가 없으므로 종료
		}
		
		// 현재 사람과 연결된 다른 사람들을 찾아 1촌 이동
		for (int i = 1; i <= n; i++) {
			// i번 사람과 연결되어 있고(map[current][i] == 1), 아직 안 만나본 사람인 경우
			if (map[current][i] == 1 && !visited[i]) {
				dfs(i, target, count + 1);
			}
		}
	}

}
