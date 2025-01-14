import java.io.*;
import java.util.StringTokenizer;

public class boj9084 {
    static int knapsack(int[] coins, int m){
        int[] dp = new int[m+1];

        for (int i = 1; i <= coins.length-1; i++) {
            for (int j = coins[i]; j <= m; j++) {
                if (j == coins[i]){
                    dp[j] += 1;
                }
                dp[j] += dp[j-coins[i]];

            }
        }
        return dp[m];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
       //테스트 케이스 t
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            // n은 동전의 갯수 m은 만들 금액
            int n = Integer.parseInt(br.readLine());
            int[] coins = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n+1; j++) {
                coins[j] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            sb.append(knapsack(coins, m)).append("\n");

        }
        System.out.println(sb.toString());
    }
}
