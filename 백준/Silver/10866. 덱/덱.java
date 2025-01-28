import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> dequeue = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String command = br.readLine();
			switch (command.split(" ")[0]) {
			case "push_front":
				dequeue.add(0, Integer.parseInt(command.split(" ")[1]));
				break;
			case "push_back":
				dequeue.add(dequeue.size(), Integer.parseInt(command.split(" ")[1]));
				break;
			case "pop_front":
				if (dequeue.isEmpty()) {
					System.out.println(-1);
					break;
				} else {
					System.out.println(dequeue.remove(0));
					break;
				}
			case "pop_back":
				if (dequeue.isEmpty()) {
					System.out.println(-1);
					break;
				} else {
					System.out.println(dequeue.remove(dequeue.size() - 1));
					break;
				}
			case "size":
				System.out.println(dequeue.size());
				break;
			case "empty":
				if (dequeue.isEmpty()) {
					System.out.println(1);
					break;
				} else {
					System.out.println(0);
					break;
				}
			case "front":
				if (dequeue.isEmpty()) {
					System.out.println(-1);
					break;
				} else {
					System.out.println(dequeue.get(0));
					break;
				}
			case "back":
				if (dequeue.isEmpty()) {
					System.out.println(-1);
					break;
				} else {
					System.out.println(dequeue.get(dequeue.size() - 1));
					break;
				}
			}
		}
		
	}

}
