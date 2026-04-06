import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	
	// dx, dy 순서를 서(1), 북(2), 동(4), 남(8) 순서에 맞춤
	static int[] dx = { 0, -1, 0, 1 }; // 서, 북, 동, 남 순서 (행 변화)
	static int[] dy = { -1, 0, 1, 0 }; // 서, 북, 동, 남 순서 (열 변화)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[m][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[m][n];
		int roomCount = 0;
		int maxRoomArea = 0;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					roomCount++; // 새로운 방 발견
					maxRoomArea = Math.max(maxRoomArea, dfs(i, j)); // 최대 넓이 갱신
				}
			}
		}
		
		System.out.println(roomCount);
		System.out.println(maxRoomArea);
		
		int maxAfterBreak = 0;
		
		// 모든 칸을 돌면서
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// 4방향을 확인하며 벽이 있는지 봄
				for (int k = 0; k < 4; k++) {
					// (map[i][j] & (1 << k)) != 0 이면 k번째 방향에 벽이 있다는 뜻
					if ((map[i][j] & (1 << k)) != 0) {
						
						// 1. 벽을 임시로 허묾
						map[i][j] -= (1 << k);
						
						// 2. 방문 배열을 초기화하고 다시 DFS를 돌려봄
						visited = new boolean[m][n];
						// 여기서는 모든 칸을 다시 검사해서 최대값을 찾아야 함
						for (int r = 0; r < m; r++) {
							for (int c = 0; c < n; c++) {
								if (!visited[r][c]) {
									maxAfterBreak = Math.max(maxAfterBreak, dfs(r, c));
								}
							}
						}
						
						// 3. 벽을 다시 원래대로 세움
						map[i][j] += (1 << k);
					}
				}
			}
		}
		
		System.out.println(maxAfterBreak);
	}
	
	static int dfs(int x, int y) {
		visited[x][y] = true;
		int count = 1; // 현재 칸을 포함하므로 1부터 시작
		
		for (int i = 0; i < 4; i++) {
			// 비트 연산으로 벽 확인: map[x][y]의 i번째 비트가 0이면 벽이 없음
			if ((map[x][y] & (1 << i)) == 0) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				// 맵 범위 내에 있고 아직 방문하지 않았다면 이동
				if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny]) {
					count += dfs(nx, ny); // 연결된 칸들의 개수를 모두 더함
				}
			}
		}
		return count; // 이 방의 총 면적 반환
	}

}
