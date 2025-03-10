import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int cnt = 0;
		for (int i : arr) {
			int check = 0;
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) check++;
			}
			if (check == 2) cnt++;
		}
		
		System.out.println(cnt);
	}

}
