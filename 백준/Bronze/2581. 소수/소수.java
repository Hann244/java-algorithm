import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        int[] nums = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            nums[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (nums[i] == 0) continue;
            for (int j = i + i; j <= N; j = j + i) {
                nums[j] = 0;
            }
        }

        int total = 0;
        int min = Integer.MAX_VALUE;

        for (int i = M; i <= N; i++) {
            if (nums[i] != 0) {
                total += i;
            }
            if (nums[i] != 0 && min > nums[i]) {
                min = nums[i];
            }
        }

        if (total == 0) {
            System.out.println(-1);
        } else {
            System.out.println(total);
            System.out.println(min);
        }
    }
}
