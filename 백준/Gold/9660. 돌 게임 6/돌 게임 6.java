import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        long temp = n % 7;

        if (temp == 0 || temp == 2) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}