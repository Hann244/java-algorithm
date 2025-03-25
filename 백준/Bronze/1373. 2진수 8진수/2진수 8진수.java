import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		if (str.length() % 3 != 0) {
			str = "0".repeat(3 - (str.length() % 3)) + str;
		}
		
		for (int i = 0; i < str.length(); i += 3) {
			String s = str.substring(i, i + 3);
			
			int total = 0;
			for (int j = 0; j < 3; j++) {
				char ch = s.charAt(j);
				total += Math.pow(2, 2 - j) * (ch - '0');
			}
			sb.append(Integer.toString(total));
		}
		
		System.out.println(sb.toString());
	}

}
