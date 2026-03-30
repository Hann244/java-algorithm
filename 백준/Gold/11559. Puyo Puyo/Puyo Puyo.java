import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static char[][] map = new char[12][6];
	static ArrayList<int[]> list; // 연결된 뿌요들의 좌표를 담을 바구니
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 12; i++) {
			String line = br.readLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		// 전체 게임 루프
		int combo = 0; // 정답(연쇄 횟수)을 저장할 변수
		
		while (true) {
			boolean isPopped = false; // 이번 턴에 한 번이라도 터졌는지 체크
			visited = new boolean[12][6]; // 매 연쇄(턴)마다 방문 기록은 새로 초기화
			
			// 맵 전체를 돌면서 터뜨릴 뿌요 찾기
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					// 빈칸이 아니고 아직 방문 안 한 뿌요를 발견하면
					if (map[i][j] != '.' && !visited[i][j]) {
						list = new ArrayList<>(); // 새 덩어리를 담을 바구니 준비
						
						// 시작점 방문 처리 및 바구니에 담기
						visited[i][j] = true;
						list.add(new int[] {i, j});
						
						// DFS로 연결되 같은 색 뿌요들 모두 바구니에 담아오기
						dfs(i, j, map[i][j]);
						
						// 바구니에 담긴 뿌요가 4개 이상이라면 터뜨리기 (빈칸으로 만들기)
						if (list.size() >= 4) {
							isPopped = true; // 이번 턴에 터진 적이 있다고 표시
							for (int[] pos : list) {
								map[pos[0]][pos[1]] = '.';
							}
						}
					}
				}
			}
			
			// 맵을 다 뒤졌는데 한 번도 터진 게 없다면 무한 루프 종료
			if (!isPopped) {
				break;
			}
			
			// 터진 뿌요가 있다면 연쇄 횟수를 올리고, 공중에 뜬 블록들을 바닥으로 내림
			combo++;
			gravity();
		}
		
		// 최종 연쇄 횟수 출력
		System.out.println(combo);
	}
	
	static void dfs(int x, int y, char color) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 맵 범위 안이고, 아직 방문 안 했고, 같은 색깔이라면
			if (nx >= 0 && nx < 12 && ny >= 0 && ny < 6) {
				if (!visited[nx][ny] && map[nx][ny] == color) {
					visited[nx][ny] = true; // 방문 처리
					list.add(new int[] {nx, ny}); // 바구니에 좌표 담기
					dfs(nx, ny, color); // 연결된 다음 뿌요 찾으러 이동
				}
			}
		}
	}
	
	static void gravity() {
		// 0열부터 5열까지 각각 독립적으로 중력 적용
		for (int j = 0; j < 6; j++) {
			Queue<Character> q = new LinkedList<>();
			
			// 1. 맨 아래(11)부터 위(0)로 훝으면서 뿌요들을 큐에 수집
			for (int i = 11; i >= 0; i--) {
				if (map[i][j] != '.') {
					q.offer(map[i][j]); // 뿌요 담기
					map[i][j] = '.'; // 담았으니 맵에서 지우기(빈칸으로 청소)
				}
			}
			
			// 2. 다시 맨 아래부터 큐에서 꺼내어 차곡차곡 쌓기
			int idx = 11;
			while (!q.isEmpty()) {
				map[idx][j] = q.poll();
				idx--;
			}
		}
	}
}
