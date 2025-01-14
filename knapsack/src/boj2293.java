import java.io.*;
import java.util.*;
public class boj2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n+1];
        for (int i = 1; i <= n; i++) {
            coins[i]  =Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k+1];

        for(int i=1;i<=n;i++){
            for(int j=coins[i]; j<=k;j++){
                if( j  == coins[i]){
                    dp[j] += 1;
                }
                else{
                    dp[j] += dp[j-coins[i]];
                }

            }
        }

        System.out.println(dp[k]);

    }
}
