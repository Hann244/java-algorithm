import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String S = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < S.length(); i++) {
			char chr = S.charAt(i);
			if (chr >= 'A' && chr <= 'Z') {
				if (chr + 13 > 90) {
					sb.append((char) (chr - 13));
				} else {
					sb.append((char) (chr + 13));
				}
			}
			else if (chr >= 'a' && chr <= 'z') {
				if (chr + 13 > 122) {
					sb.append((char) (chr - 13));
				} else {
					sb.append((char) (chr + 13));
				}
			}
			else {
				sb.append(chr);
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
