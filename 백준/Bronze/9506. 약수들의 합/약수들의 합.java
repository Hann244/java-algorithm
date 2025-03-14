import java.io.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = 0;
		while ((n = Integer.parseInt(br.readLine())) != -1) {
			ArrayList<Integer> list = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			sb.append(n).append(" = ");
			for (int i = 1; i < n; i++) {
				if (n % i == 0) list.add(i);
			}
			int total = list.stream().mapToInt(Integer::intValue).sum();
			if (total == n) {
				for (int i = 0; i < list.size() - 1; i++) {
					sb.append(list.get(i));
					sb.append(" + ");
				}
				sb.append(list.get(list.size() - 1));
				System.out.println(sb.toString());
			} else {
				System.out.println(n + " is NOT perfect.");
			}
		}
	}

}
