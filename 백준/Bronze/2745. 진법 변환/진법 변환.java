import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        String N = str.split(" ")[0];
        int B = Integer.parseInt(str.split(" ")[1]);

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put((char) ('A' + i), 10 + i);
        }

        int result = 0;
        int length = N.length();
        for (int i = 0; i < length; i++) {
            char c = N.charAt(length - 1 - i);
            int value;
            // 숫자 0-9일 경우
            if (Character.isDigit(c)) {
                value = c - '0';
            }
            // 문자 A-Z일 경우
            else {
                value = map.get(c);
            }
            result += value * Math.pow(B, i);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

}
