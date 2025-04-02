import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int A = Integer.parseInt(str.split(" ")[0]);
		int B = Integer.parseInt(str.split(" ")[1]);
		
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int total = 0;
		for (int i = 0; i < m; i++) {
			int n = Integer.parseInt(st.nextToken());
			total += Math.pow(A, m - 1 - i) * n;
			
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		while (total > 0) {
			list.add(total % B);
			total /= B;
		}
		
		for (int i = list.size() - 1; i > -1; i--) {
			System.out.print(list.get(i) + " ");
		}
	}

}
