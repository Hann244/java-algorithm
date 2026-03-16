import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n + 1][n + 1];
		
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = map[b][a] = 1;
		}
		
		int minKevinBacon = Integer.MAX_VALUE; // 최소 케빈 베이컨 수를 저장할 변수
		int resultPerson = 0; // 정답이 될 사람의 번호
		
		// 1번 사람부터 N번 사람까지 각각 BFS를 돌려 케빈 베이컨 수를 구함
		for (int i = 1; i <= n; i++) {
			int currentKevinBacon = bfs(i);
			
			// 더 작은 케빈 베이컨 수를 찾으면 갱신
			// '<' 기호를 쓰면 값이 같을 경우 번호가 작은 사람이 유지됨
			if (currentKevinBacon < minKevinBacon) {
				minKevinBacon = currentKevinBacon;
				resultPerson = i;
			}
		}
		
		System.out.print(resultPerson);
	}
	
	// 특정 출발점에서 다른 모든 사람까지의 케빈 베이컨 수의 합을 반환하는 메서드
	static int bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		int[] dist = new int[n + 1]; // 거리 기록 겸 방문 체크용 배열
		
		// 배열을 -1로 초기화(-1은 아직 방문하지 않았음을 의미)
		for (int i = 1; i <= n; i++) {
			dist[i] = -1;
		}
		
		// 시작점 설정
		queue.add(start);
		dist[start] = 0; // 자기 자신과의 거리는 0
		int totalDistance = 0;
		
		while (!queue.isEmpty()) {
			int current = queue.poll();
			
			// 현재 사람과 연결된 다른 사람들을 탐색
			for (int i = 1; i <= n; i++) {
				// 친구 관계가 있고(1), 아직 방문하지 않은 사람(-1)이라면
				if (map[current][i] == 1 && dist[i] == -1) {
					// 이전 사람의 거리 + 1을 해줌
					dist[i] = dist[current] + 1;
					totalDistance += dist[i]; // 총합에 누적
					queue.add(i); // 큐에 넣어서 다음 탐색에 사용
				}
			}
		}
		
		return totalDistance;
	}

}
