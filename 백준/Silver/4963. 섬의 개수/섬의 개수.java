import java.io.*;
import java.util.*;

public class Main {

	static int[][] land;
	static boolean[][] visited;
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int cnt, w, h;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if (w == 0 && h == 0) break;
			
			land = new int[h][w];
			visited = new boolean[h][w];
			cnt = 0;
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					land[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int x = 0; x < h; x++) {
				for (int y = 0; y < w; y++) {
					if (land[x][y] == 1 && !visited[x][y]) {
						DFS(x, y);
						cnt++;
					}
				}
			}

			System.out.println(cnt);
		}
	}

	private static void DFS(int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 8; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;

			if (nx >= 0 && ny >= 0 && nx < h && ny < w && !visited[nx][ny] && land[nx][ny] == 1) {
				DFS(nx, ny);
			}
		}
	}

}
