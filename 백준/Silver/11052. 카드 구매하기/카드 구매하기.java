import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] cards = new int[N + 1];
		int[] dp = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], dp[i - j] + cards[j]);
			}
		}
		
		bw.write(String.valueOf(dp[N]));
		bw.flush();
		bw.close();
	}

}
