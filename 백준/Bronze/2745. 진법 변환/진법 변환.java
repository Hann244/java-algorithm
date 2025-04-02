import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		String N = str.split(" ")[0];
		int B = Integer.parseInt(str.split(" ")[1]);

		int result = 0;
		for (int i = 0; i < N.length(); i++) {
			char ch = N.charAt(i);
			if (B > 10) {
				if (ch - '0' < 10) {
					result += Math.pow(B, N.length() - 1 - i) * (ch - '0');
				} else {
					result += Math.pow(B, N.length() - 1 - i) * ((ch - 'A') + 10);
				}
			} else {
				result += Math.pow(B, N.length() - 1 - i) * (ch - '0');
			}
		}

		System.out.println(result);
	}

}
