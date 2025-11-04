import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Interval implements Comparable<Interval> {
    int L, R, originalIndex;

    Interval(int L, int R, int originalIndex) {
        this.L = L;
        this.R = R;
        this.originalIndex = originalIndex;
    }

    @Override
    public int compareTo(Interval other) {
        if (this.L != other.L) {
            return Integer.compare(this.L, other.L);
        }
        return Integer.compare(other.R, this.R); 
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] mines = new int[n];
        for (int i = 0; i < n; i++) {
            mines[i] = Integer.parseInt(br.readLine());
        }

        int[] L = new int[n];
        int[] R = new int[n];

        for (int i = 0; i < n; i++) {
            L[i] = i;
            int power = mines[i];
            for (int j = i - 1; j >= 0; j--) {
                if (power > mines[j]) {
                    L[i] = L[j];
                    power = mines[j];
                } else {
                    break;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            R[i] = i;
            int power = mines[i];
            for (int j = i + 1; j < n; j++) {
                if (power > mines[j]) {
                    R[i] = R[j];
                    power = mines[j];
                } else {
                    break;
                }
            }
        }

        List<Interval> intervals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            intervals.add(new Interval(L[i], R[i], i + 1));
        }

        Collections.sort(intervals);

        List<Integer> answer = new ArrayList<>();
        int currentPos = 0;
        int i = 0;

        while (currentPos < n) {
            int maxReach = -1;
            int bestClickIndex = -1;

            while (i < n && intervals.get(i).L <= currentPos) {
                if (intervals.get(i).R > maxReach) {
                    maxReach = intervals.get(i).R;
                    bestClickIndex = intervals.get(i).originalIndex;
                }
                i++;
            }
            
            if (bestClickIndex == -1) {
                 break;
            }

            answer.add(bestClickIndex);
            currentPos = maxReach + 1;
        }

        Collections.sort(answer);
        
        for (int index : answer) {
            System.out.println(index);
        }
    }
}