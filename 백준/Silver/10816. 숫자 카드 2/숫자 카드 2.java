import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		Map<Integer, Integer> cards = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if (!cards.containsKey(tmp)) {
				cards.put(tmp, 1);
			} else {
				cards.put(tmp, cards.get(tmp) + 1);
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		int[] userCards = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			userCards[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i : userCards) {
			sb.append(cards.get(i) == null ? 0  + " " : cards.get(i) + " ");
		}
		
		System.out.println(sb);
	}

}
