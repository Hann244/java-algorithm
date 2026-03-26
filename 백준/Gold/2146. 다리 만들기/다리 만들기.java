import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int n;
	
	// 정답을 담을 변수
	static int minAnswer = Integer.MAX_VALUE;
	
	static class Point {
		int y, x;
		int dist; // 바다를 건널 때마다 +1씩 증가할 다리 길이
		
		public Point(int y, int x, int dist) {
			this.y = y;
			this.x = x;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1. 모든 섬에 각자 다른 이름표(번호) 붙여주기
		int islandNum = 2; // 섬 번호는 2번부터 시작
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 아직 번호가 없는 육지(1)를 발견하면
				if (map[i][j] == 1) {
					// 연결된 섬을 다 같은 번호로 바꿈
					makeIsland(i, j, islandNum);
					islandNum++; // 다음 섬을 위해 번호 증가
				}
			}
		}
		
		// 2. 다리 놓기(최단 거리 찾기)
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 바다가 아닌 육지(번호가 2 이상)인 곳에서만 다리 놓기 시도
				if (map[i][j] >= 2) {
					buildBridge(i, j, map[i][j]);
				}
			}
		}
		
		// 가장 짧은 다리 길이 출력
		System.out.println(minAnswer);
	}
	
	// 첫 번째 BFS : 연결된 육지에 같은 번호(이름표)를 붙여주는 메서드
	static void makeIsland(int y, int x, int num) {
		Queue<Point> q = new LinkedList<>();
		// 육지 위를 돌아다니는 거라 거리는 0으로 세팅
		q.offer(new Point(y, x, 0));
		map[y][x] = num; // 시작점 방문 처리 및 번호 붙이기
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				
				// 범위 안에 있고 아직 번호가 안 붙은 육지(1)라면
				if (ny >= 0 && nx >= 0 && ny < n && nx < n) {
					if (map[ny][nx] == 1) {
						map[ny][nx] = num; // 같은 번호표를 붙여줌
						q.offer(new Point(ny, nx, 0));
					}
				}
			}
		}
	}
	
	// 두 번째 BFS : 바다 위로 다리를 뻗어나가며 다른 섬을 찾는 메서드
	static void buildBridge(int y, int x, int currentIsland) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(y, x, 0));
		
		// 바다 위를 헤맬 때 똑같은 곳을 또 가지 않기 위해 방문 체크 배열 필요
		// 다리를 놓을 때마다 다시 거리를 재야 하므로 여기서 새로 만들어야 함
		boolean[][] visited = new boolean[n][n];
		visited[y][x] = true;
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			// 가지치기(최적화)
			// 만약 지금 놓는 다리가 이미 발견한 정답(최소값)보다 길다면 더 볼 필요 없음
			if (p.dist >= minAnswer) continue;
			
			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				
				// 범위 안에 있고, 아직 다리를 안 놔본 곳이라면
				if (ny >= 0 && nx >= 0 && ny < n && nx < n && !visited[ny][nx]) {
					// 케이스 1: 바다(0)를 만남 -> 다리를 한 칸 연장해서 계속 뻗어나감
					if (map[ny][nx] == 0) {
						visited[ny][nx] = true;
						// 거리를 +1를 해서 큐에 넣음
						q.offer(new Point(ny, nx, p.dist + 1));
					}
					
					// 케이스 2: 다른 섬(내 번호와 다른 번호)을 만남 -> 다리 완성
					else if (map[ny][nx] != currentIsland) {
						// 현재까지 구한 거리와 기존 최소값 중 더 작은 것을 정답으로 갱신
						minAnswer = Math.min(minAnswer, p.dist);
						// 이 위치에서 출발한 최단 거리를 찾았으므로 탐색 즉시 종료
						return; 
					}
				}
			}
		}
	}

}
