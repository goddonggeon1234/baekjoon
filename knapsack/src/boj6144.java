import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class boj6144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //n은 보석의 갯수 m은 무게제한

        int n = Integer.parseInt(st.nextToken());
        int m  = Integer.parseInt(st.nextToken());

        int[][] items = new int[n+1][2];

        //[0]은 무게 [1]은 가치
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[2][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(items[i][0] <= j ){
                    dp[i%2][j] = Math.max(dp[(i-1)%2][j], dp[(i-1)%2][j-items[i][0]]+items[i][1]);
                }
                else{
                    dp[i%2][j] = dp[(i-1)%2][j];
                }
            }

        }


        System.out.println(dp[n%2][m]);
    }
}
