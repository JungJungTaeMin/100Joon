import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            int count = 0;

            boolean b = true;

            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                
                if (c == '(')
                    count++;
                else
                    count--;
                
                if (count < 0) {
                    b = false;
                    break;
                }
            }

            if (count != 0)
                b = false;
            if (b)
                sb.append("YES").append("\n");
            else 
                sb.append("NO").append("\n");
        }

        System.out.print(sb);
    }
}