import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = st.nextToken();
		}
		// 중복제거
		arr = Arrays.stream(arr).distinct().toArray(String[]::new);
		
		// 정렬
		Arrays.sort(arr, Comparator.comparingInt(String::length).thenComparing(String::compareTo));
		
		for (String word : arr) {
			bw.write(word + "\n");
		}
		
		bw.close();
	}

}
