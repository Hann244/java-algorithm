import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static int n, m;
	static int result = 1;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		bfs();
		System.out.println(map[n - 1][m - 1]);
	}
	
	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point());
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 0; i < 4; i ++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if (nx > -1 && nx < n && ny > -1 && ny < m) {
					if (map[nx][ny] == 1) {
						// 이전 칸 (p.x, p.y)의 값에 1을 더해서 다음 칸에 저장
						map[nx][ny] = map[p.x][p.y] + 1;
						q.offer(new Point(nx, ny));
					}
				}
			}
		}
	}

}
