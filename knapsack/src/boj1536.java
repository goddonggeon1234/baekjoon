import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class boj1536 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int hp = 100;
        int n = Integer.parseInt(br.readLine());

        int[] fatigue = new int[n+1];
        int[] joy = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            fatigue[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            joy[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[2][hp+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= hp; j++) {
                if(fatigue[i] < j){
                    dp[i%2][j] = Math.max(dp[(i-1)%2][j], dp[(i-1)%2][j-fatigue[i]]+ joy[i]);
                }
                else dp[i%2][j] = dp[(i-1)%2][j];
            }
        }

        System.out.println(dp[n%2][hp]);
    }
}
