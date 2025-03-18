import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		long n = Long.parseLong(str.split(" ")[0]);
		long m = Long.parseLong(str.split(" ")[1]);
		
		long five = cntFive(n) - cntFive(n - m) - cntFive(m);
		long two = cntTwo(n) - cntTwo(n - m) - cntTwo(m);
		
		System.out.println(Math.min(five, two));
	}

	private static long cntFive(long num) {
		int cnt = 0;
		
		while (num >= 5) {
			cnt += (num /= 5);
		}
		
		return cnt;
	}
	
	private static long cntTwo(long num) {
		int cnt = 0;
		
		while (num >= 2) {
			cnt += (num /= 2);
		}
		
		return cnt;
	}
}
