import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long result = 0;
		for (int i = n; i > 1; i--) {
			result += 4;
		}
		result += 4;
		
		System.out.println(result);
	}

}
