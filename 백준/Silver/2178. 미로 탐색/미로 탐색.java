import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	// 1단계) 받아줄 값 세팅
	static int n, m; // n*m 미로
	static int[][] arr; // 미로를 담을 배열
	static boolean[][] visited; // 방문 여부 확인
	static int[] dx = {-1, 1, 0, 0}; // x방향 상하좌우
	static int[] dy = {0, 0, -1, 1}; // y방향 상하좌우

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			String inputLine = br.readLine();
			
			for (int j = 0; j < inputLine.length(); j++) {
				arr[i][j] = inputLine.charAt(j) - '0';
			}
		}
		
		// 3단계) bfs 알고리즘에 시작 위치 넣기
		bfs(0, 0);
		
		// 4단계) 값 출력
		// bfs를 다 돌고 나면 도착할 칸의 행렬 값은 거쳐야 할 최소 칸의 수가 됨
		System.out.println(arr[n - 1][m - 1]); // 마지막 칸의 인덱스로 값을 출력
		
	}
	
	// 2단계) bfs 알고리즘
	static void bfs(int x, int y) {
		// Queue 생성
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y));
		visited[x][y] = true; // 방문처리
		
		while (!queue.isEmpty()) {
			Point currentPoint = queue.poll();
			// 현재 위치에서 사방위 이동가능여부 판별
			for (int i = 0; i < 4; i++) {
				int nextX = currentPoint.x + dx[i];
				int nextY = currentPoint.y + dy[i];
				
				// 1. 범위 이내에 있는지
				if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) 
					continue; // 범위에서 나가면 넘기기
				// 2. 막힌 길인지
				if (arr[nextX][nextY] == 0)
					continue; // 막힌 길이면 넘기기
				// 3. 이미 방문 했는지
				if (visited[nextX][nextY])
					continue; // 방문했으면(true 이면) 넘기기
				// 모든 조건에 해당되지 않고 갈 수 있는 길이면
				// queue에 삽입하고 방문 처리
				queue.offer(new Point(nextX, nextY));
				visited[nextX][nextY] = true;
				// 최소 칸의 수를 구해야 하므로 해당하는 칸에 1씩 누적
				// 도착 칸이면 그 값이 지나야 하는 최소 칸의 수가 됨
				arr[nextX][nextY] = arr[currentPoint.x][currentPoint.y] + 1;
			}
		}
	}

}
