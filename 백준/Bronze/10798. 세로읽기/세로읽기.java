import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] arr = new char[5][15];

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            arr[i] = str.toCharArray();
        }

        br.close();

        String result = "";
        int idx = 0;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[j].length > i && arr[j][i] != '\0') {
                    result += arr[j][i];
                }
            }
            idx++;
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
