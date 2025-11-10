import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        char[] gom = input.toCharArray();

        int Ccount = 0;
        int Ncount = 0;

        for(char i : gom){
            if(i == 'C')
                Ccount++;
            else
                Ncount++;
        }


        long result = (long)Math.ceil((double)Ccount / (double)(Ncount+1));

        System.out.println(result);
    }

}
