import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int bitset = 0;

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int x;

            switch (op) {
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    bitset |= (1 << x);
                    break;

                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    bitset &= ~(1 << x);
                    break;

                case "check":
                    x = Integer.parseInt(st.nextToken());
                    if ((bitset & (1 << x)) != 0) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;

                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    bitset ^= (1 << x);
                    break;

                case "all":
                    bitset = (1 << 21) - 1;
                    break;

                case "empty":
                    bitset = 0;
                    break;
            }
        }

        System.out.print(sb);
    }
}