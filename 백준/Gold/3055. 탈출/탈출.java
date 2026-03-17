import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int x;
		int y;
		char type; // *(물) 또는 S(고슴도치)
		
		public Node(int x, int y, char type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}

	static char[][] map;
	static int[][] time; // 고슴도치가 이동한 시간을 기록할 배열
	
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	
	static int r, c;
	static Queue<Node> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		time = new int[r][c];
		
		// 고슴도치 위치 임시 저장
		Node hedgehog = null;
		
		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = s.charAt(j);
				
				if (map[i][j] == '*') {
					q.add(new Node(i, j, '*')); // 물을 먼저 큐에 삽입
				} else if (map[i][j] == 'S') {
					hedgehog = new Node(i, j, 'S');
				}
			}
		}
		
		// 물을 다 넣은 뒤에 고슴도치를 큐에 삽입
		q.add(hedgehog);
		
		bfs();
	}
	
	static void bfs() {
		
		while (!q.isEmpty()) {
			Node current = q.poll();
			
			// 4방향 탐색
			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				
				// 맵의 범위를 벗어나면 패스
				if (nx <0 || nx >= r || ny < 0|| ny >= c) continue;
				
				// 현재 큐에서 꺼낸 것이 물(*)인 경우
				if (current.type == '*') {
					// 물은 빈 칸(.)이거나 고슴도치가(S)가 있는 곳으로 번질 수 있음
					if (map[nx][ny] == '.' || map[nx][ny] == 'S') {
						map[nx][ny] = '*'; // 지도를 물로 덮어버림
						q.add(new Node(nx, ny, '*'));
					}
				}
				// 현재 큐에서 꺼낸 것이 고슴도치(S)일 경우
				else if (current.type == 'S') {
					// 목적지(D)에 도착한 경우
					if (map[nx][ny] == 'D') {
						System.out.println(time[current.x][current.y] + 1);
						return; // 정답을 찾았으니 함수 완전 종료
					}
					
					// 빈 칸(.)으로만 이동 가능
					if (map[nx][ny] == '.') {
						map[nx][ny] = 'S'; // 방문 처리(고슴도치가 이동했음을 표시)
						time[nx][ny] = time[current.x][current.y] + 1; // 시간 기록
						q.add(new Node(nx, ny, 'S'));
					}
				}
				
			}
			
		}
		
		// 큐가 빌 때까지 'D'에 도달하지 못했다면 목적지에 도달하지 못한 것이므로 'KAKTUS' 출력
		System.out.println("KAKTUS");
	}

}
