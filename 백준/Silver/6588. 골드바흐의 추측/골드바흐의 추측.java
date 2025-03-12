import java.io.*;

public class Main {

	static int MAX = 1000000;
	static boolean[] primeNumber = new boolean[MAX + 1];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] result;
		
		// 소수 찾는 메서드
		findPrimeNumber(primeNumber);
		
		int n = 0;
		while ((n = Integer.parseInt(br.readLine())) != 0) {
			result = new int[2];
			
			for (int i = n; i >= 0; i--) {
				if (primeNumber[i] && primeNumber[n - i]) {
					result[0] = n - i;
					result[1] = i;
					bw.write(n + " = " + result[0] + " + " + result[1] + "\n");
					break;
				}
			}
			
			if (result[0] == 0)
				bw.write("Goldbach's conjecture is wrong." + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	private static boolean[] findPrimeNumber(boolean[] arr) {
		int cnt;
		for (int i = 2; i < arr.length; i++) {
			cnt = 0;
			for (int j = 2; j * j <= i; j++) {
				if (i % j == 0) {
					cnt++;
					break;
				}
			}
			if (cnt == 0) {
				arr[i] = true;
			}
		}
		return arr;
	}

}
