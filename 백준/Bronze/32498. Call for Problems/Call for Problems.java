import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int odd_count = 0;

        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();

            if (d % 2 != 0) {
                odd_count++;
            }
        }

        System.out.println(odd_count);

        sc.close();
    }
}