import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        String[] arr = new String[T];

        for (int i = 0; i < T; i++) {
            arr[i]= sc.next();
        }

        for (int i = 0; i < T; i++) {
            System.out.print(arr[i].charAt(0));
            System.out.print(arr[i].charAt(arr[i].length() - 1));
            System.out.println();
        }
    }
}
