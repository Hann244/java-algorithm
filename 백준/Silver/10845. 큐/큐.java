import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> queue = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			if (command.equals("push")) {
				queue.add(Integer.parseInt(st.nextToken()));
			} else if (command.equals("pop")) {
				if (queue.isEmpty()) {
					bw.write(-1 + "\n");
					continue;
				}
				bw.write(queue.remove() + "\n");
			} else if (command.equals("size")) {
				bw.write(queue.size() + "\n");
			} else if (command.equals("empty")) {
				if (queue.isEmpty()) {
					bw.write(1 + "\n");
				} else {
					bw.write(0 + "\n");
				}
			} else if (command.equals("front")) {
				if (queue.isEmpty()) {
					bw.write(-1 + "\n");
					continue;
				}
				bw.write(queue.get(0) + "\n");
			} else if (command.equals("back")) {
				if (queue.isEmpty()) {
					bw.write(-1 + "\n");
					continue;
				}
				bw.write(queue.get(queue.size() - 1) + "\n");
			}
		}
		
		bw.close();
	}

}
