import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] time;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		time = new int[100001];
		bfs(N, K);
	}
	
	static void bfs(int start, int target) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		time[start] = 1;
		
		while (!q.isEmpty()) {
			int tmp = q.poll();
			
			if (tmp == target) {
				System.out.println(time[tmp] - 1);
				return;
			}
		
			int[] nextPositions = { tmp - 1, tmp + 1, tmp * 2 };
			
			for (int next : nextPositions) {
				if (next >= 0 && next <= 100000 && time[next] == 0) {
					time[next] = time[tmp] + 1;
					q.add(next);
				}
			}
		}
	}

}
