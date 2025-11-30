import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> stack = new ArrayList<Integer>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String text = st.nextToken();
			
			if (text.equals("push")) {
				stack.add(Integer.parseInt(st.nextToken()));
			} else if (text.equals("pop")) {
				if (stack.isEmpty()) {
					bw.write(String.valueOf(-1) + "\n");
					continue;
				}
				bw.write(String.valueOf(stack.remove(stack.size() - 1)) + "\n");
			} else if (text.equals("size")) {
				bw.write(String.valueOf(stack.size()) + "\n");
			} else if (text.equals("empty")) {
				if (stack.isEmpty()) {
					bw.write(String.valueOf(1) + "\n");
				} else {
					bw.write(String.valueOf(0) + "\n");
				}
			} else if (text.equals("top")) {
				if (stack.isEmpty()) {
					bw.write(String.valueOf(-1) + "\n");
					continue;
				}
				bw.write(String.valueOf(stack.get(stack.size() - 1)) + "\n");
			}
		}

		bw.flush();
		bw.close();
	}

}
