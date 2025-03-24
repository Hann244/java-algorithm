import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int N = Integer.parseInt(str.split(" ")[0]);
		int S = Integer.parseInt(str.split(" ")[1]);

		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Math.abs(S - Integer.parseInt(st.nextToken()));
		}

		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			min = gcd(min, arr[i]);
		}

		System.out.println(min);

	}

	public static int gcd(int num1, int num2) {
		if (num2 == 0)
			return num1;
		return gcd(num2, num1 % num2);
	}

}
