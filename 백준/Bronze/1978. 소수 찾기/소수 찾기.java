import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int  n = Integer.parseInt(br.readLine());

        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i = 0; i < n; i++){

            boolean tf = true;

            int s = Integer.parseInt(st.nextToken());

            if(s == 1) {
                continue;
            }
            for(int j = 2; j <= Math.sqrt(s); j++) {
                if(s % j == 0) {
                    tf = false;
                    break;
                }
            }
            if(tf) count++;
        }
        System.out.println(count);
    }

}