import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int A = Integer.parseInt(str.split(" ")[0]);
        int B = Integer.parseInt(str.split(" ")[1]);
        int N = Integer.parseInt(str.split(" ")[2]);

        if ((N-B)%(A-B) == 0) {
            System.out.println((N-B)/(A-B));
        }
        if ((N-B)%(A-B) != 0) {
            System.out.println((N-B)/(A-B)+1);
        }
    }
}
