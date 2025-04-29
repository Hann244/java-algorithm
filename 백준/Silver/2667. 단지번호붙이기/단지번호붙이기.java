import java.io.*;
import java.util.*;

public class Main {

	static int[][] apt;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static List<Integer> result;
	static int cnt, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		result = new LinkedList<>();
		N = Integer.parseInt(br.readLine());
		apt = new int[N][N];
		visited = new boolean[N][N];
		cnt = 1; // 기준이 단지로 묶일 첫 아파트가 포함될 때이므로 1로 초기화
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				apt[i][j] = str.charAt(j) - '0';
			}
		}
		
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (apt[x][y] == 1 && !visited[x][y]) {
					DFS(x, y);
					result.add(cnt);
					cnt = 1;
				}
			}
		}
		
		Collections.sort(result);
		
		System.out.println(result.size());
		for (int r : result) System.out.println(r);
	}

	private static void DFS(int x, int y) {
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			
			if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && apt[nx][ny] == 1) {
				cnt++;
				DFS(nx, ny);
			}
		}
	}

}
