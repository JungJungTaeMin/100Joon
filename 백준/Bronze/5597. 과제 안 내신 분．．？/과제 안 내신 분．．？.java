import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[] isSubmitted = new boolean[31];

        for (int i = 0; i < 28; i++) {
            int studentNum = sc.nextInt();
            isSubmitted[studentNum] = true;
        }

        for (int i = 1; i <= 30; i++) {
            if (!isSubmitted[i]) { 
                System.out.println(i);
            }
        }

        sc.close();
    }
}