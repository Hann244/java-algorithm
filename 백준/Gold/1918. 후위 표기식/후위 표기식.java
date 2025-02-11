import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char chr = str.charAt(i);
			if (chr >= 65 && chr <= 90) {
				sb.append(chr);
			}
			else {
				if (chr == '(') {
					stack.push(chr);
				}
				else if (chr == ')') {
					while (!stack.isEmpty() && stack.peek() != '(') {
						sb.append(stack.pop());
					}
					if (!stack.isEmpty()) {
						stack.pop(); // ( 연산자 제거
					}
				}
				else {
					while (!stack.isEmpty() && priority(stack.peek()) >= priority(chr)) {
						sb.append(stack.pop());
					}
					stack.push(chr);
				}
			}
		}
		
		while (!stack.isEmpty()) {
			if (stack.peek() == '(' || stack.peek() == ')') {
				stack.pop();
			}
			sb.append(stack.pop());
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	// 연산자 우선순위
	static int priority(char c) {
		if (c == '*' || c == '/') return 2;
		else if (c == '+' || c == '-') return 1;
		else return 0;
	}

}
