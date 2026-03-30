import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int n, m;
	
	static class Node {
		int x, y, dist, wall;
		
		public Node(int x, int y, int dist, int wall) {
			this.x = x;
			this.y = y;
			this.dist = dist; // 이동거리
			this.wall = wall; // 0: 안 부숨, 1: 부숨
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m][2];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		System.out.println(bfs());
	}

	static int bfs() {
		Queue<Node> q = new LinkedList<>();
		
		q.offer(new Node(0, 0, 1, 0));
		visited[0][0][0] = true;
		
		while (!q.isEmpty()) {
			Node current = q.poll();
			
			if (current.x == n - 1 && current.y == m - 1) {
				return current.dist;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				
				if (nx >= 0 && nx < n && ny >= 00 && ny < m) {
					if (map[nx][ny] == 0) {
						if (!visited[nx][ny][current.wall]) {
							visited[nx][ny][current.wall] = true;
							q.offer(new Node(nx, ny, current.dist + 1, current.wall));
						}
					}
				
				
					else if (map[nx][ny] == 1) {
						if (current.wall == 0 && !visited[nx][ny][1]) {
							visited[nx][ny][1] = true;
							q.offer(new Node(nx, ny, current.dist + 1, 1));
						}
					}
				}
			}
		}
		
		return -1;
	}
}
