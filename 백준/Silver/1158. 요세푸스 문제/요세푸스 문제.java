import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			arr.add(i + 1);
		}
		
		System.out.print("<");
		int idx = K - 1;
        while (arr.size() > 1) {
        	idx %= arr.size();
            System.out.print(arr.remove(idx) + ", ");
            idx = (idx + K - 1) % arr.size();
            
        }

		System.out.print(arr.get(0) + ">");
	}

}
