
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static boolean[] visited;
	static int n, m, v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 정점의 개수
		m = Integer.parseInt(st.nextToken()); // 간선의 개수
		v = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호
		
		map = new int[n + 1][n + 1];
		
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = 1; // 양방향 간선
		}
		
		visited = new boolean[n + 1];
		dfs(v);
		System.out.println();
		visited = new boolean[n + 1];
		bfs(v);
		
	}
	
	static void dfs(int start) {
		visited[start] = true;
		System.out.print(start + " ");
		
		for (int i = 1; i <= n; i++) {
			if (map[start][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		
		while (!q.isEmpty()) {
			int temp = q.poll();
			
			System.out.print(temp + " ");
			
			for (int i = 1; i <= n; i++) {
				if (map[temp][i] == 1 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
		
	}
}
