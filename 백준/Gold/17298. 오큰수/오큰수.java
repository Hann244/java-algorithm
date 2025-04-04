import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
				A[stack.pop()] = A[i];
			}
			stack.push(i);
		}
		
		while (!stack.isEmpty()) {
			A[stack.pop()] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(A[i]).append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
