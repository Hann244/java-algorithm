import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			System.out.print(" ".repeat(N - 1 - i));
			System.out.print("*".repeat(i + 1));
			System.out.print("*".repeat(i));
			System.out.println();
		}
		for (int i = N - 2; i >= 0; i--) {
			System.out.print(" ".repeat(N - 1 - i));
			System.out.print("*".repeat(i + 1));
			System.out.print("*".repeat(i));
			System.out.println();
		}
	}

}
