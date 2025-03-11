import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int M = Integer.parseInt(str.split(" ")[0]);
        int N = Integer.parseInt(str.split(" ")[1]);

        boolean[] isPrime = new boolean[N + 1];
        isPrime[0] = isPrime[1] = true;


        for (int i = 2; i * i <= N; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (!isPrime[i]) {
                System.out.println(i);
            }
        }
    }
}
