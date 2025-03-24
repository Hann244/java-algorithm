import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			long total = 0;
			for (int j = 0; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					total += gcd(arr[j], arr[k]);
				}
			}
			System.out.println(total);
		}
	}
	
	private static long gcd(int num1, int num2) {
		if (num1 % num2 == 0) return num2;
		return gcd(num2, num1 % num2);
	}

}
