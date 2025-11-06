import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();

            if (a == 0 && b == 0 && c == 0 && d == 0) {
                break; 
            }

            int min_age = c - b;

            int max_age = d - a;

            System.out.println(min_age + " " + max_age);
        }

        sc.close();
    }
}