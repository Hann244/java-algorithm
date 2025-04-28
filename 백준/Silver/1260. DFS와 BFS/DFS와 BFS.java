import java.io.*;
import java.util.*;

public class Main {

	static boolean visited[];
	static ArrayList<Integer>A[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			A[S].add(E);
			A[E].add(S);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(A[i]);
		}
		
		visited = new boolean[N + 1];
		DFS(start);
		System.out.println();
		visited = new boolean[N + 1];
		BFS(start);
	}
	
	private static void DFS(int node) {
		System.out.print(node + " ");
		visited[node] = true;
		for (int i : A[node]) {
			if (!visited[i]) {
				DFS(i);
			}
		}
	}

	private static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(node);
		visited[node] = true;
		
		while(!queue.isEmpty()) {
			int now_node = queue.poll();
			System.out.print(now_node + " ");
			for (int i : A[now_node]) {
				if (!visited[i]) {
					visited[i] = true;
					queue.add(i); // BFS는 queue에 넣어주면 됨
				}
			}
		}
	}

}
