import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String[] arr = new String[str.length()];
		
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.substring(str.length() - (i + 1), str.length());
		}
		
		Arrays.sort(arr);
		for (String s : arr) {
			System.out.println(s);
		}
	}

}
