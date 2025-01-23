import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> queue = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if (str.contains("push")) {
				queue.add(Integer.parseInt(str.split(" ")[1]));
			}
			if (str.equals("pop")) {
				if (queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.remove(0));
				}
			}
			if (str.equals("size")) {
				System.out.println(queue.size());
			}
			if (str.equals("empty")) {
				if (queue.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			}
			if (str.equals("front")) {
				if (queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.get(0));
				}
			}
			if (str.equals("back")) {
				if (queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.get(queue.size() - 1));
				}
			}
		}
	}

}
