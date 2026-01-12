import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int arr[] = new int[10001];
	static boolean visited[] = new boolean[10001];
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<>();
		list.add(a);
		
		while (true) {
			int temp = list.get(list.size() - 1);
			int next = 0;
			
			while (temp > 0) {
				next += (int) Math.pow(temp % 10, p);
				temp /= 10;
			}
			
			if (list.contains(next)) {
				System.out.println(list.indexOf(next));
				break;
			}
			
			list.add(next);
		}
	}

}
