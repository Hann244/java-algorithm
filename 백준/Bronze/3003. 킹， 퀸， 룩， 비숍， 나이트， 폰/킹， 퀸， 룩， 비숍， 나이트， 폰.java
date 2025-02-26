import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int[] arr = new int[6];

		for (int i = 0; i < 6; i++) {
			arr[i] = Integer.parseInt(str.split(" ")[i]);
		}

		if (arr[0] != 1) {
			if (arr[0] > 1) {
				arr[0] = 1 - arr[0];
			}
			else {
				arr[0] = 1;
			}
		} else {
			arr[0] = 0;
		}
		
		if (arr[1] != 1) {
			if (arr[1] > 1) {
				arr[1] = 1 - arr[1];
			}
			else {
				arr[1] = 1;
			}
		} else {
			arr[1] = 0;
		}
		
		if (arr[2] != 2) {
			if (arr[2] > 2) {
				arr[2] = 2 - arr[2];
			}
			else {
				arr[2] = 2 - arr[2];
			}
		} else {
			arr[2] = 0;
		}
		
		if (arr[3] != 2) {
			if (arr[3] > 2) {
				arr[3] = 2 - arr[3];
			}
			else {
				arr[3] = 2 - arr[3];
			}
		} else {
			arr[3] = 0;
		}
		
		if (arr[4] != 2) {
			if (arr[4] > 2) {
				arr[4] = 2 - arr[4];
			}
			else {
				arr[4] = 2 - arr[4];
			}
		} else {
			arr[4] = 0;
		}
		
		if (arr[5] != 8) {
			if (arr[5] > 8) {
				arr[5] = 8 - arr[5];
			}
			else {
				arr[5] = 8 - arr[5];
			}
		} else {
			arr[5] = 0;
		}
		
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}
