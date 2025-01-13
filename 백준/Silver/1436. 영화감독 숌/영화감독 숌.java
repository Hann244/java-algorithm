import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int total = 666;
        int count = 1;

        while (true) {
            if (N == 1) {
                System.out.println(666);
                break;
            }
            total++;

            String str = Integer.toString(total);
            if (str.contains("666")) count++;
            if (count == N) {
                System.out.println(total);
                break;
            }

            total = Integer.parseInt(str);
        }
    }
}
