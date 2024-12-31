import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.next();
        char[] arr = text.toCharArray();
        boolean flag = true;

        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                System.out.println(0);
                flag = false;
                break;
            }

            if (arr[i] == arr[arr.length - 1 - i]) {
                flag = true;
            }
        }

        if (flag) {
            System.out.println(1);
        }
    }
}
