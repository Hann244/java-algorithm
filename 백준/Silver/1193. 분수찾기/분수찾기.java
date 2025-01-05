import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int floor = 1;

        while (N - floor > 0) {
            N -= floor;
            floor++;
        }

        int box = N;
        int hap = floor + 1;
        int a = 0, b = 0;

        if (floor % 2 == 0) {
            b = box;
            a = hap - box;
        }

        if (floor % 2 != 0) {
            a = box;
            b = hap - box;
        }

        System.out.println(b + "/" + a);
    }
}
