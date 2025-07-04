import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int mod = 1_000_000_000;
		int[][] dp = new int[N + 1][10];
		
		for (int i = 0; i <= 9; i++) {
			dp[1][i] = 1; // 1자리 계단 수
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][1] % mod;
				}
				else if (j == 9) {
					dp[i][j] = dp[i - 1][8] % mod;
				}
				else {
					dp[i][j] = (dp[i - 1][j - 1] % mod + dp[i - 1][j + 1] % mod) % mod;
				}
			}
		}
		int sum = 0;
		for (int i = 1; i <= 9; i++) {
			sum += dp[N][i];
			
			sum %= mod; // 답을 더하면서 오버플로우가 발생할 수 있으므로 mod를 꼼꼼히 넣어줌
		}
		System.out.println(sum%mod);
	}

}
