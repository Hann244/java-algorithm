import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int[][] map;
	static int result = Integer.MAX_VALUE;
	static boolean[][][] visited;
	static int targetX, targetY, targetDir; // 목적지 정보
	static Queue<Node> q;
	
	// 상하좌우 
	// 동(1), 서(2), 남(3), 북(4)로 정해져 있으므로 인덱스 0은 비워두고 1~4 인덱스로 생성
	static int[] dx = { 0, 0, 0, 1, -1 };
	static int[] dy = { 0, 1, -1, 0, 0 };
	
	static class Node {
		int x, y, dir, count;
		
		Node(int x, int y, int dir, int count) {
			this.x = x;
			this.y = y;
			this.dir = dir; // 1:동, 2:서, 3:남, 4:북
			this.count = count; // 명령 횟수
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken()); // 세로 길이
		n = Integer.parseInt(st.nextToken()); // 가로 길이
		
		map = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		q = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		q.offer(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0));
		
		visited = new boolean[m + 1][n + 1][5];
		st = new StringTokenizer(br.readLine());
		targetX = Integer.parseInt(st.nextToken());
		targetY = Integer.parseInt(st.nextToken());
		targetDir = Integer.parseInt(st.nextToken());
		
		bfs();
	}
	
	static void bfs() {
		while (!q.isEmpty()) {
			Node curr = q.poll();
			
			// 목표 지점에 도착했다면 바로 종료
			if (curr.x == targetX && curr.y == targetY && curr.dir == targetDir) {
				System.out.println(curr.count);
				return;
			}
			
			// 1. "GO" 로직: 현재 방향으로 1, 2, 3칸 이동 시도
			for (int k = 1; k <= 3; k++) {
				int nx = curr.x + dx[curr.dir] * k;
				int ny = curr.y + dy[curr.dir] * k;
				
				// 맵 밖으로 나가거나 벽(1)을 만나면 '그 방향'으로는 더 이상 못 감
				if (nx < 1 || ny < 1 || nx > m || ny > n || map[nx][ny] == 1) {
					// 1칸 앞에 벽이 있으면 2, 3칸은 당연히 못 감
					break;
				}
				
				if (!visited[nx][ny][curr.dir]) {
					visited[nx][ny][curr.dir] = true;
					q.add(new Node(nx, ny, curr.dir, curr.count + 1));
				}
			}
			
			// 2. "TURN"로직 : 현재 위치에서 방향만 바꾸기
			for (int i = 1; i <= 4; i++) {
				// i가 현재 방향(curr.dir)과 다를 때만 회전 시도
				if (curr.dir != i) {
					int turnCount = getTurnCount(curr.dir, i); //회전 비용 계산
					
					// 이 문제에서 '명령 1회'는 90도 회전임. 
		            // 180도 회전(반대 방향)은 명령 2회로 처리되거나 
		            // 90도씩 나눠서 큐에 들어감 (로직에 따라 다름)
					
					// 90도 회전일 때만 처리
					if (turnCount == 1) {
						if (!visited[curr.x][curr.y][i]) {
							visited[curr.x][curr.y][i] = true;
							q.add(new Node(curr.x, curr.y, i, curr.count + 1));
						}
					}
				}
			}
		}
	}

	static int getTurnCount(int dir, int next) {
		if (dir == next) return 0;
		if ((dir == 1 && next == 2) || (dir == 2 && next == 1) ||
				(dir == 3 && next == 4) || (dir == 4 && next == 3)) return 2;
		return 1;
	}
}
