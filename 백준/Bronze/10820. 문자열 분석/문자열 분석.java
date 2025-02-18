import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = "";
		while ((str = br.readLine()) != null && !str.isEmpty()) {
			int lowerCnt = 0, upperCnt = 0, numCnt = 0, blankCnt = 0;
			for (int i = 0; i < str.length(); i++) {
				char chr = str.charAt(i);
				if (chr >= 'a' && chr <= 'z') {
					lowerCnt++;
				}
				else if (chr >= 'A' && chr <= 'Z') {
					upperCnt++;
				}
				else if (chr >= '0' && chr <= '9') {
					numCnt++;
				}
				else if (chr == ' ') {
					blankCnt++;
				}
			}
			System.out.println(lowerCnt + " " + upperCnt + " "  + numCnt  + " " + blankCnt);
		}
	}

}
