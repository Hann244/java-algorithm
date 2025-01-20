import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] list = br.readLine().split(" ");

            for (String text : list) {
                StringBuilder sb = new StringBuilder(text);
                sb.reverse();
                System.out.print(sb + " ");
            }
        }
    }
}
