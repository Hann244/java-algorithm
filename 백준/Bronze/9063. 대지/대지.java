import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            int X = Integer.parseInt(s.split(" ")[0]);
            int Y = Integer.parseInt(s.split(" ")[1]);

            if (minX > X) {
                minX = X;
            }
            if (maxX < X) {
                maxX = X;
            }
            if (minY > Y) {
                minY = Y;
            }
            if (maxY < Y) {
                maxY = Y;
            }
        }

        System.out.println((maxX - minX) * (maxY - minY));
    }
}
