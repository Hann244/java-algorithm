import java.util.Scanner;

// 10813번. 공 바꾸기
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] ball = new int[N];
        for (int k = 0; k < N; k++) {
            ball[k] = k + 1;
        }

        for (int k = 0; k < M; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();

            int temp = ball[i - 1];
            ball[i - 1] = ball[j - 1];
            ball[j - 1] = temp;
        }

        for (int b : ball) {
            System.out.print(b + " ");
        }
    }
}