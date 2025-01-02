import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input.split(" ")[0]);
        int M = Integer.parseInt(input.split(" ")[1]);

        int[][] arr = new int[N*2][M];

        for (int i = 0; i < N*2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + arr[i + N][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
