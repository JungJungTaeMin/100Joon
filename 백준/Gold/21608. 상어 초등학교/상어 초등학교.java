import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int Student = n * n;

        int[][] grid = new int[n][n];

        Set<Integer>[] prefList = new HashSet[Student + 1];

        int[] studentOrder = new int[Student];

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for(int i = 0; i < Student; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int studentId = Integer.parseInt(st.nextToken());
            studentOrder[i] = studentId;

            prefList[studentId] = new HashSet<>();

            for(int j = 0; j < 4; j++) {
                prefList[studentId].add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int studentId : studentOrder) {
            int bestR = -1;
            int bestC = -1;
            int maxPreferred = -1;
            int maxEmpty = -1;

            Set<Integer> myPrefs = prefList[studentId];

            for(int r = 0; r < n; r++) {
                for(int c = 0; c < n; c++) {
                    if(grid[r][c] != 0)
                        continue;

                    int currentPreferred = 0;
                    int currentEmpty = 0;

                    for(int i = 0; i < 4; i++) {
                        int nr = r + dr[i];
                        int nc = c + dc[i];

                        if(nr >= 0 && nr < n && nc >= 0 && nc < n) {
                            int neighborId = grid[nr][nc];
                            if(neighborId == 0) {
                                currentEmpty++;
                            }
                            else if(myPrefs.contains(neighborId)) {
                                currentPreferred++;
                            }
                        }
                    }

                    boolean isBetter = false;

                    if(currentPreferred > maxPreferred) {
                        isBetter = true;
                    }
                    else if(currentPreferred == maxPreferred) {
                        if(currentEmpty > maxEmpty) {
                            isBetter = true;
                        }
                        else if (currentEmpty == maxEmpty && bestR == -1) {
                            isBetter = true;
                        }
                    }

                    if(isBetter) {
                        maxPreferred = currentPreferred;
                        maxEmpty = currentEmpty;
                        bestR = r;
                        bestC = c;
                    }
                }
            }
            grid[bestR][bestC] = studentId;
        }

        int answer = 0;
        int[] score = {0, 1, 10, 100, 1000};

        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                int studentId = grid[r][c];
                Set<Integer> myPrefs = prefList[studentId];
                int preferredNeighborCount = 0;

                for(int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if(nr >= 0 && nr < n && nc >= 0 && nc < n) {
                        if(myPrefs.contains(grid[nr][nc])) {
                            preferredNeighborCount++;
                        }
                    }
                }
                answer += score[preferredNeighborCount];
            }
        }

        System.out.println(answer);
    }
}