import java.io.*;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		BigInteger bi = new BigInteger(str, 8);
		bw.write(bi.toString(2));
		bw.flush();
		bw.close();
	}

}
