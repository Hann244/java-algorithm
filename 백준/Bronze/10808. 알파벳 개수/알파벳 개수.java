import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String S = br.readLine();
		Map<Character, Integer> map = new HashMap<>();
		
		for (int i = 97; i <= 122; i++) {
			map.put((char) i, 0);
		}
		
		for (int i = 0; i < S.length(); i++) {
			map.put(S.charAt(i), map.get(S.charAt(i)) + 1);

		}
		
		StringBuilder sb = new StringBuilder();
		for (Character key : map.keySet()) {
			sb.append(map.get(key)).append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
