import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1613 {

    static int[][] map;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];

        for (int i = 0; i <k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = -1;
        }
        for (int i = 1; i <= n; i++) {
            map[i][i] = 0;
        }

        for (int m = 1; m <= n; m++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (map[i][m] == 1&& map[m][j] == 1) {
                        map[i][j] = 1;
                    }
                    else if (map[i][m] == -1&& map[m][j] == -1) {
                        map[i][j] = -1;
                    }

                }

            }
        }


        StringBuilder sb = new StringBuilder();
        k = Integer.parseInt(br.readLine());


        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(map[a][b]*-1).append("\n");
        }
        System.out.println(sb);






    }
}
