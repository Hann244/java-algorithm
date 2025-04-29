import java.io.*;
import java.util.*;

public class Main {

	static boolean visited[];
	static ArrayList<Integer>A[];
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());

		A = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < c; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);
			A[e].add(s);
		}
		
		for (int i = 1; i <= n; i++) {
			Collections.sort(A[i]);
		}
		
		visited = new boolean[n + 1];
		DFS(1);
		System.out.println(count - 1);
	}
	
	private static void DFS(int node) {
		count++;
		visited[node] = true;
		for (int i : A[node]) {
			if (!visited[i]) {
				DFS(i);
			}
		}
	}

}
