import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (Character.isUpperCase(c)) {
                result.append(Character.toLowerCase(c));
            }
            else if (Character.isLowerCase(c)) {
                result.append(Character.toUpperCase(c));
            }
            else result.append(c);
        }

        System.out.println(result.toString());
    }
}