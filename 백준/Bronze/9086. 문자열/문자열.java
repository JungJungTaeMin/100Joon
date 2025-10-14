import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < n; i++) {
            String s = "11";
            s = sc.nextLine();
            int length = s.length();
            char first = s.charAt(0);
            char last = s.charAt(length - 1);

            System.out.print(first);
            System.out.println(last);

        }


    }
}