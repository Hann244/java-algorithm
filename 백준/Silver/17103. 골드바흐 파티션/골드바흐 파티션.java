import java.io.*;

public class Main {

	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] isPrime = new boolean[1000001];
		isPrime[0] = isPrime[1] = true;

		for (int i = 2; i * i < isPrime.length; i++) {
			if (!isPrime[i]) {
				for (int j = i * i; j < isPrime.length; j += i) {
					isPrime[j]= true;
				}
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			for (int j = 2; j <= N / 2; j++) {
				if (!isPrime[j] && !isPrime[N - j]) {
					if ((j + (N - j)) == N) cnt++;
				}
			}
			System.out.println(cnt);
		}
	}

}
