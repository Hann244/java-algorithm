import java.io.*;
import java.util.*;

public class Main {
	
	static ArrayList<Integer>A[];
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		
		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			A[u].add(v);
			A[v].add(u);
		}
		
		int count = 0;
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				count++;
				DFS(i);
			}
		}
		
		System.out.print(count);
	}

	private static void DFS(int node) {
		visited[node] = true;
		for (int i : A[node]) {
			if (!visited[i]) {
				DFS(i);
			}
		}
	}

}
