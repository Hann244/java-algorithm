import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 문자열 입력
		String str = br.readLine();
		LinkedList<Character> editor = new LinkedList<>();
		
		for (int i = 0; i < str.length(); i++) {
			editor.add(str.charAt(i));
		}
		
		// 명령어 개수
		int M = Integer.parseInt(br.readLine());
		
		// iterator 메소드 호출
		ListIterator<Character> iter = editor.listIterator();
		
		// 커서 위치 초기화(문장의 맨 뒤에 위치)
		while (iter.hasNext()) {
			iter.next();
		}
		
		for (int i = 0; i < M; i++) {
			String command = br.readLine();
			
			if (command.contains("P")) {
				iter.add(command.charAt(2));

			}
			if (command.equals("L")) {
				if (iter.hasPrevious()) {
					iter.previous();
				}
			}
			if (command.equals("D")) {
				if (iter.hasNext()) {
					iter.next();
				}
			}
			if (command.equals("B")) {
				if (iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
			}
		}
		
		for (char c : editor) {
			bw.write(c);
		}
		bw.flush();
		bw.close();
	}

}
