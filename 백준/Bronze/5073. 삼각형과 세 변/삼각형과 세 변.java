import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (a == 0 && b == 0 && c == 0) break;

            boolean flag = false;
            int max = Integer.MIN_VALUE;
            if (max < a) {
                max = a;
                if (b + c > max) flag = true;
            }
            if (max < b) {
                flag = false;
                max = b;
                if (a + c > max) flag = true;
            }
            if (max < c) {
                flag = false;
                max = c;
                if (a + b > max) flag = true;
            }

            if (flag) {
                if (a == b && b == c) {
                    System.out.println("Equilateral");
                    continue;
                }
                if (a == b && a != c || a == c && a != b || b == c && a != b) {
                    System.out.println("Isosceles");
                    continue;
                }
                if (a != b && a != c) {
                    System.out.println("Scalene");
                    continue;
                }
            }

            if (!flag) {
                System.out.println("Invalid");
            }
        }
    }
}
