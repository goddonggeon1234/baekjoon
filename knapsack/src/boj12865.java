import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //n = 보석 갯수, k = 가방한도
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] items = new int[n+1][2];

        //[0]은 무게 [1]은 가치
        for (int i = 1; i <=n; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        /*for (int i = 1; i <=n; i++) {
            System.out.println((items[i][0] + " " +  items[i][1]));
        }*/

        int[][] dp = new int[n+1][k+1];

        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=k; j++) {
                if( j >= items[i][0]){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-items[i][0]] + items[i][1]);
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        sb.append(dp[n][k]);

        /*for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=k; j++) {
                System.out.print(dp[i][k] + " ");
            }
            System.out.println();
        }*/

        System.out.println(sb);


    }

}