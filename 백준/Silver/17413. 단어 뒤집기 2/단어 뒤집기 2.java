import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();

		char[] list = S.toCharArray();
		String word = "";
		int idx = 0;
		while (idx < list.length) {
			if (list[idx] == '<') {
				System.out.print(list[idx]);
				idx++;
				while (true) {
					System.out.print(list[idx]);
					idx++;
					if (list[idx] == '>') {
						System.out.print(list[idx]);
						idx++;
						break;
					}
				}

			} else {
				if (list[idx] == ' ') {
					StringBuilder sb = new StringBuilder(word);
					System.out.print(sb.reverse());
					System.out.print(list[idx]);
					idx++;
					word = "";
				} else {
					word += list[idx];
					idx++;
					if (idx != list.length && list[idx] == '<') {
						StringBuilder sb = new StringBuilder(word);
						System.out.print(sb.reverse());
						word = "";
					}
					if (idx == list.length) {
						StringBuilder sb = new StringBuilder(word);
						System.out.print(sb.reverse());
					}
				}

			}
		}
	}

}
