import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		
		double[] arr = new double[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Double.parseDouble(br.readLine());
		}
		
		Stack<Double> stack = new Stack<>();
		double total = 0;
		
		for (int i = 0; i < str.length(); i++) {
			char chr = str.charAt(i);
			if (chr >= 65 && chr <= 90) {
				stack.push(arr[chr - 65]);
			} else {
				if (chr == '+') {
					total = stack.pop() + stack.pop();
					stack.push(total);
				} 
				else if (chr == '-') {
					double t = stack.pop();
					total = stack.pop() - t;
					stack.push(total);
				}
				else if (chr == '*') {
					total = stack.pop() * stack.pop();
					stack.push(total);
				}
				else if (chr == '/') {
					double t = stack.pop();
					total = stack.pop() / t;
					stack.push(total);
				}
			}
		}
		
		String answer = String.format("%.2f", total);
		bw.write(answer);
		bw.flush();
		bw.close();
	}

}
