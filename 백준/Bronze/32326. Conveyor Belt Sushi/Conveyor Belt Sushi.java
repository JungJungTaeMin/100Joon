import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int G = sc.nextInt();
        int B = sc.nextInt();

        int totalCost = (R * 3) + (G * 4) + (B * 5);
        
        System.out.println(totalCost);

        sc.close();
    }
}    