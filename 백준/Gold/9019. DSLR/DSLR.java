import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	// 큐에 넣을 상태 객체  (현재 숫자와 그 숫자까지 도달하기 위한 명령어)
	static class Register {
		int num;
		String command;
		
		Register(int num, String command) {
			this.num = num;
			this.command = command;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			bfs(a, b);
		}
	}
	
	static void bfs(int a, int b) {
		Queue<Register> queue = new LinkedList<>();
		boolean[] visited = new boolean[10000]; // 0 ~ 9999 방문 체크
		
		// 초기 상태 설정
		queue.offer(new Register(a, ""));
		visited[a] = true;
		
		while (!queue.isEmpty()) {
			Register current = queue.poll();
			
			// 목표 숫자에 도달하면 명령어 출력 후 종료
			if (current.num == b) {
				System.out.println(current.command);
				return;
			}
			
			int n = current.num;
			
			// D 연산
			int d = (n * 2) % 10000;
			if (!visited[d]) {
				visited[d] = true;
				queue.offer(new Register(d, current.command + "D"));
			}
			
			// S 연산
			int s = (n == 0) ? 9999 : n - 1;
			if (!visited[s]) {
				queue.offer(new Register(s, current.command + "S"));
			}
			
			// L 연산
			int l = (n % 1000) * 10 + (n / 1000);
			if (!visited[l]) {
				visited[l] = true;
				queue.offer(new Register(l, current.command + "L"));
			}
			
			// R 연산
			int r = (n % 10) * 1000 + (n / 10);
			if (!visited[r]) {
				visited[r] = true;
				queue.offer(new Register(r, current.command + "R"));
			}
		}
	}

}
