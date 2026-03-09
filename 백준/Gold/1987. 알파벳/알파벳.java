import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static char[][] map;
	static boolean[] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int r, c;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		
		// 알파벳 개수에 맞춰 0~25 사이의 인덱스로 방문 처리
		visited = new boolean[26];
		
		for (int i = 0; i < r; i++) {
			String t = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = t.charAt(j);
			}
		}
		dfs(0, 0, 1);
		
		System.out.print(cnt);
	}
	
	static void dfs(int x, int y, int count) {
		
		// 매번 올 때마다 최댓값 갱신
		cnt = Math.max(cnt, count);
		
		// 현재 위치 방문 처리
		visited[map[x][y] - 'A'] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
				int tempIdx = map[nx][ny] - 'A';
				if (!visited[tempIdx]) {
					// 다음 칸으로 넘어갈 때 이동 횟수(count)를 1 증가시켜서 넘김
					dfs(nx, ny, count + 1);
				}
			}
			
		}
		
		// 백트래킹
		// 이 경로에서의 탐색을 마치고 이전 갈림길로 되돌아갈 때
		// 현재 칸의 방문 기록을 지워주어야 다른 경로에서 이 알파벳을 다시 사용 가능
		visited[map[x][y] - 'A'] = false;
	}

}
