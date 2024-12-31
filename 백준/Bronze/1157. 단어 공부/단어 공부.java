import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine().toUpperCase();

        char[] arr = text.toCharArray();

        Map<Character, Integer> hs = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (hs.containsKey(arr[i])) {
                hs.put(arr[i], hs.get(arr[i]) + 1);
            } else {
                hs.put(arr[i], 1);
            }
        }

        int max = 0;
        char ch = '\0';
        boolean flag = true;

        for(Character key : hs.keySet()) {
            if (hs.get(key) > max) {
                max = hs.get(key);
                ch = key;
                flag = true;
            } else if (hs.get(key) == max) {
                flag = false;
            }
        }

        if (flag) {
            System.out.println(ch);
        } else {
            System.out.println("?");
        }

    }
}
