import java.io.*;
import java.util.*;

public class Main {

	static int[][] area;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int N, cnt, result, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		area = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(area[i][j], max);
			}
		}

		result = 1;
		for (int i = 1; i <= max; i++) {
			visited = new boolean[N + 1][N + 1];
			cnt = 0;
			for (int x = 1; x <= N; x++) {
				for (int y = 1; y <= N; y++) {
					if (area[x][y] > i && !visited[x][y]) {
						cnt++; // 안전 영역 한 개 발견
						DFS(x, y, i);
	
					}
				}
			}
			result = Math.max(cnt, result);
		}
		
		System.out.println(result);

	}

	private static void DFS(int x, int y, int rain) {
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			
			if (nx >= 1 && ny >= 1 && nx <= N && ny <= N && !visited[nx][ny] && area[nx][ny] > rain) {
				DFS(nx, ny, rain);
			}
		}
	}
}
