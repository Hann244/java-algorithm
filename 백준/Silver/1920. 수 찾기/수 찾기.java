import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashSet<Integer> list = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		int m = Integer.parseInt(br.readLine());
		int[] mList = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			mList[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < m; i++) {
			if (list.contains(mList[i])) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}

}
