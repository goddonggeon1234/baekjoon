import java.io.*;
import java.util.*;

public class boj2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k + 1];
        int[] coins = new int[n+1];
        for (int i = 1; i <= n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }


        for (int i = 1; i <= n; i++) {
            for (int j = coins[i]; j <= k; j++) {

                if( j == coins[i]){
                    dp[j] =1;
                    continue;
                }
                //만들수 없는 경우
                if(dp[j- coins[i]] == 0){
                    continue;
                }
                //가장 처음 만들어 지는 수 : 나중에 들어오는 수
                else {
                    dp[j] =(dp[j] ==0) ? dp[j-coins[i]]+1 :  Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }

        int ans = (dp[k] == 0) ? -1 : dp[k];
        System.out.println(ans);
    }
}
