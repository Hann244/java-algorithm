import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int quarter = 0, dime = 0, nickel = 0, penny = 0;
			int cash = Integer.parseInt(br.readLine());
			while (cash > 0.00) {
				if (cash >= 25) {
					cash -= 25;
					quarter++;
				}
				if (cash < 25 && cash >= 10) {
					cash -= 10;
					dime++;
				}
				if (cash < 10 && cash >= 5) {
					cash -= 5;
					nickel++;
				}
				if (cash < 5 && cash > 0) {
					cash -= 1;
					penny++;
				}
			}
			System.out.println(quarter + " " + dime  + " " + nickel  + " " + penny);
		}
	}

}
