import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String S = br.readLine();
		int[] arr = new int[26];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
		
		for (int i = 0; i < S.length(); i++) {
			char chr = S.charAt(i);
			if (arr[chr - 97] != -1) continue;
			arr[chr - 97] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i : arr) {
			sb.append(i).append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
