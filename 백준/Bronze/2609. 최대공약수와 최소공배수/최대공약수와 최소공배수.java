import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		System.out.println(gcd(a, b));
		System.out.println(lcm(a, b));
	}
	
	public static int gcd(int num1, int num2) {
		if (num1 % num2 == 0) {
			return num2;
		}
		return gcd(num2, num1 % num2);
	}

	public static int lcm(int num1, int num2) {
		return num1 * num2 / gcd(num1, num2);
	}
}
