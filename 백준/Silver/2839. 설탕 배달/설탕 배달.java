import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// 사용한 봉지의 개수
		int cnt = 0;
		
		// 설탕을 다 담을 때까지(n이 0이 될 때까지)
		// 혹은 정확히 담을 수 없어 음수가 될 때까지 계속 반복
		while (n > 0) {
			
			// 1. 가장 무거운 5kg 봉지로만 다 담을 수 있는지 확인
			if (n % 5 == 0) {
				cnt++;
				n -= 5;
			} else {
				cnt++;
				n -= 3;
			}
		}
		
		if (n != 0) {
			System.out.println(-1);
		} else {
			System.out.println(cnt);
		}
	}

}
