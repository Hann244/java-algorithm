import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int map[];
	static boolean visited[];
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		int tc = Integer.parseInt(br.readLine());
		for (int i = 0; i < tc; i++) {
			int n = Integer.parseInt(br.readLine());
			map = new int[n + 1];
			cnt = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n + 1; j++) {
				map[j] = Integer.parseInt(st.nextToken());
			}
			
			visited = new boolean[n + 1];
			for (int j = 1; j < n + 1; j++) {
				if (!visited[j]) {
					dfs(j);
					cnt++;
				}
			}
			
			System.out.println(cnt);
		}
	}
	
	static void dfs(int start) {
		visited[start] = true;
		
		int next = map[start];
		if(!visited[next]) {
			dfs(map[start]);
		}
	}

}
