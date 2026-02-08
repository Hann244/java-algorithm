import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static boolean[] visited;
	static int n, v, cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		v = Integer.parseInt(br.readLine());
		
		// 컴퓨터 번호가 1번부터 시작
		map = new int[n + 1][n + 1];
		
		for (int i = 0; i < v; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 양방향 연결
			map[a][b] = map[b][a] = 1;
		}
		
		visited = new boolean[n + 1];
		
		dfs(1);
		
		System.out.println(cnt);
		
	}
	
	private static void dfs(int start) {
		visited[start] = true;
		
		for (int i = 1; i <= n; i++) {
			if (map[start][i] == 1 && !visited[i]) {
				dfs(i);
				cnt++;
			}
		}
	}
}
