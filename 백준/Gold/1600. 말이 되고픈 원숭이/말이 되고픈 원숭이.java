import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[][][] visited;
	static int[][] map;
	static int w, h = 0;
	// 원숭이 이동 방법
	static int[] dx = {-1, 1, 0, 0}; // x방향
	static int[] dy = {0, 0, -1, 1}; // y방향
	// 말 이동 방법
	static int[] hx = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] hy = {-1, 1, -2, 2, -2, 2, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int k = Integer.parseInt(br.readLine()); // 말처럼 움직일 수 있는 횟수
		
		st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		// 2차원 배열은 map[행][열]로 접근하는 게 편하다고 함
		map = new int[h][w];
		
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[h][w][k + 1];
		System.out.println(bfs(k));
		
	}
	
	private static int bfs(int k) {
		Queue<Node> q = new LinkedList<>();
		
		q.offer(new Node(0, 0, 0, 0)); // 시작 위치(0, 0), 이동 횟수 0, 능력 사용 0
		visited[0][0][0] = true; // 시작점 방문 처리 (능력 0번 사용한 상태)
		
		while(!q.isEmpty()) {
			Node current = q.poll(); // 큐에서 현재 상태(Node) 꺼내기
			
			int cx = current.x;
			int cy = current.y;
			int cCount = current.count;
			int ck = current.k; // 지금까지 말 능력을 몇 번 썼는지
			
			// 목적지 도착 확인 (도착했다면 최소 이동 횟수에 반환)
			if (cx == h - 1 && cy == w - 1) {
				// bfs 특성상 가장 먼저 도착한 경우가 최단 거리
				return cCount;
			}
			
			// 인접한 4방향(상하좌우) 일반 이동 탐색 - 항상 가능
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				// nx, ny가 맵 범위 안인지
				if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
					// 장애물(1)이 아니고 visited[nx][ny][ck]를 방문한 적 없는지 체크하고 큐에 넣기
					if (map[nx][ny] == 0 && !visited[nx][ny][ck]) {
						
						// 방문 처리
						visited[nx][ny][ck] = true;
						
						// 큐에 다음 상태 넣기 (이동 횟수인 cCount만 1 증가, 능력 사용 횟수는 ck 그대로)
						q.offer(new Node(nx, ny, cCount + 1, ck));
					}
				}	
			}
			
			// 말처럼 8방향 이동 탐색 - 능력이 남아있을 때만
			if (ck < k) { // 전체 허용 횟수(k)보다 현재 사용 횟수(ck)가 작을 때만 진입
				for (int i = 0; i < 8; i++) {
					int nx = cx + hx[i]; // 아까 만든 8방향 배열 사용
					int ny = cy + hy[i];
					
					// nx, ny가 맵 범위 안인지
					if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
						// 장애물(1)이 아닌지, visited[nx][ny][ck + 1]을 방문한 적 없는지 체크하고 큐에 넣기
						if (map[nx][ny] == 0 && !visited[nx][ny][ck + 1]) {
							
							// 방문 처리
							visited[nx][ny][ck + 1] = true;
							
							// 말 능력을 썼으므로 다음 상태는 ck + 1이 되어야 함 & 큐에 상태 넣기
							q.offer(new Node(nx, ny, cCount + 1, ck + 1));
						}
					}
				}
			}
		}
		
		// while문을 다 돌고 빠져나온 건 목적지에 도달하지 못했다는 뜻
		return -1;
	}
	
	// 위치와 상태를 담을 클래스
	static class Node {
		int x, y, count, k; // x좌표, y좌표, 총 이동 횟수, 말 능력 사용 횟수
		
		public Node(int x, int y, int count, int k) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.k = k;
		}
	}

}
