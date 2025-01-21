import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			String str = sc.next();
			char[] arr = new char[50];
			arr = str.toCharArray();
			
			Stack<Character> stack = new Stack<>();
			boolean flag = true;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == '(') {
					stack.push('(');
				}
				if (arr[j] == ')') {
					if (stack.isEmpty()) {
						flag = false;
						break;
					}
					stack.pop();
				}
			}
			if (flag && stack.isEmpty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

}
