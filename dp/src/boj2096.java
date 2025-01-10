import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2096 {
    static int[][] cost;

    static int getmin(int n){
        int[][] map = new int[2][3];
        map[0][0] = cost[0][0];
        map[0][1] = cost[0][1];
        map[0][2] = cost[0][2];

        for (int i = 1; i < n; i++) {
            map[1][0] = Math.min(map[0][0], map[0][1]) + cost[i][0];
            map[1][1] = Math.min(map[0][0], Math.min(map[0][1], map[0][2])) + cost[i][1];
            map[1][2] = Math.min(map[0][1], map[0][2]) + cost[i][2];

            map[0][0] = map[1][0];
            map[0][1] = map[1][1];
            map[0][2] = map[1][2];
        }
        return Math.min(map[0][0], Math.min(map[0][1], map[0][2]));

    }

    static int getmax(int n){
        int[][] map = new int[2][3];
        map[0][0] = cost[0][0];
        map[0][1] = cost[0][1];
        map[0][2] = cost[0][2];

        for (int i = 1; i < n; i++) {
            map[1][0] = Math.max(map[0][0], map[0][1]) + cost[i][0];
            map[1][1] = Math.max(map[0][0], Math.max(map[0][1], map[0][2])) + cost[i][1];
            map[1][2] = Math.max(map[0][1], map[0][2]) + cost[i][2];

            map[0][0] = map[1][0];
            map[0][1] = map[1][1];
            map[0][2] = map[1][2];
        }
        return Math.max(map[0][0], Math.max(map[0][1], map[0][2]));

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        cost = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());

        }
        System.out.println(getmax(n) +" " + getmin(n));

    }
}
