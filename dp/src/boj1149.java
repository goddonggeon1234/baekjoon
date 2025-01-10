import java.io.BufferedReader;
import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());


        }

        long[][] map = new long[n][3];
        map[0][0] = cost[0][0];
        map[0][1] = cost[0][1];
        map[0][2] = cost[0][2];
        for (int i = 1; i < n; i++) {
            map[i][0] = Math.min(map[i-1][1], map[i-1][2])+ cost[i][0];
            map[i][1] = Math.min(map[i-1][0], map[i-1][2])+ cost[i][1];
            map[i][2] = Math.min(map[i-1][1], map[i-1][0])+ cost[i][2];
        }
        long m = Math.min(map[n-1][0], Math.min(map[n-1][1], map[n-1][2]));
        System.out.println(m);





    }
}
