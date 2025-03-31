import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		if (N == 0) {
			sb.append(0);
		}
		else {
			while (N != 1) {
				sb.append(Math.abs(N % 2));
				
				N = (int) Math.ceil((double) N / -2);
			}
			sb.append(N);
		}
		
		bw.write(sb.reverse().toString());
		bw.flush();
		bw.close();
	}

}
