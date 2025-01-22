import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> result = new Stack<>();

        int last = 0;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n > last) {
                for (int j = last + 1; j <= n; j++) {
                    result.push(j);
                    sb.append("+\n");
                }
                last = n;
            }
            if (result.get(result.size()- 1 ) == n) {
                result.pop();
                sb.append("-\n");
            }
        }
        if (result.size() > 0) {
            bw.write("NO\n");
        }
        else {
            bw.write(sb+"\n");
        }
        bw.flush();
        br.close();


    }
}