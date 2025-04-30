import java.io.*;
import java.util.*;

public class Main {

	static int[][] field;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int M, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			field = new int[M][N];
			visited = new boolean[M][N];
			
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				field[X][Y] = 1;
			}
			
			int count = 0;
			for (int x = 0; x < M; x++) {
				for (int y = 0; y < N; y++) {
					if (field[x][y] == 1 && !visited[x][y]) {
						DFS(x, y);
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
	}

	private static void DFS(int x, int y) {
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
			if (!visited[nx][ny] && field[nx][ny] == 1) {
				DFS(nx, ny);
			}
		}
	}

}
