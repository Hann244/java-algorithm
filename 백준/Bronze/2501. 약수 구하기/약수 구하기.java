import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (N % i == 0) {
				list.add(i);
			}
		}
		
		if (list.size() >= K) {
			System.out.println(list.get(K - 1));
		}
		else {
			System.out.println(0);
		}
	}

}
