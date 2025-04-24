import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N + 1];
		int cnt = 1;
		for (int i = 1; i <= N; i++) {
			dp[i] = 1;
			for (int j = 1; j <= i; j++) {
				if (A[i] > A[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			cnt = Math.max(cnt, dp[i]);
		}
		
		System.out.println(cnt);
	}

}
