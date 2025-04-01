import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(str.split(" ")[0]);
		int B = Integer.parseInt(str.split(" ")[1]);

		StringBuilder sb = new StringBuilder();

		while (N > 0) {
			if (N % B >= 10) {
				sb.insert(0, (char) ((N % B) - 10 + 'A'));
			} else {
				sb.insert(0, N % B);
			}
			N /= B;
		}

		System.out.println(sb);

	}

}
