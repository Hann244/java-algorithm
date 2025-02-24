import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		String A = str.split(" ")[0];
		String B = str.split(" ")[1];
		String C = str.split(" ")[2];
		String D = str.split(" ")[3];
		
		String ab = A + B;
		String cd = C + D;
				
		System.out.println(Long.parseLong(ab) + Long.parseLong(cd));
	}

}
