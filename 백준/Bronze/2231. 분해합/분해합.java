import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int total = 0;

        while (true) {
            int result = 0;
            total++;

            int num = total;
            while (num > 0) {
                result += num % 10;
                num /= 10;
            }
            result += total;

            if (total > N) {
                System.out.println(0);
                break;
            }

            if (result == N) {
                System.out.println(total);
                break;
            }
        }
    }
}
