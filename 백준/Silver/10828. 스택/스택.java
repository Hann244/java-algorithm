import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            if (command.contains("push")) {
                nums.add(Integer.parseInt(command.split(" ")[1]));
            }
            if (command.equals("pop")) {
                if (nums.isEmpty()) {
                    System.out.println(-1);
                }
                if (!nums.isEmpty()) {
                    System.out.println(nums.remove(nums.size() - 1));
                }
            }
            if (command.equals("size")) {
                System.out.println(nums.size());
            }
            if (command.equals("empty")) {
                if (!nums.isEmpty()) {
                    System.out.println(0);
                }
                if (nums.isEmpty()) {
                    System.out.println(1);
                }
            }
            if (command.equals("top")) {
                if (!nums.isEmpty()) {
                    System.out.println(nums.get(nums.size() - 1));
                }
                if (nums.isEmpty()) {
                    System.out.println(-1);
                }
            }
        }
    }
}
