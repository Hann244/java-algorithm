import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int count = 0, total = 0;
		
		for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                total++; // 열린 괄호는 열린 상태를 기록
            } else {
                total--; // 닫힌 괄호는 열린 상태를 해제
                if (str.charAt(i - 1) == '(') {
                    count += total; // 레이저가 있을 경우 조각 수 증가
                } else {
                    count++; // 레이저가 아니면 하나의 조각이 끝남
                }
            }
        }
		
		System.out.println(count);
	}

}
