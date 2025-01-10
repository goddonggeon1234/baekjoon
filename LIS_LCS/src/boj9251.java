import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class boj9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int n = str1.length();
        int m = str2.length();



        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = 1+ dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }


        int leng = dp[n][m];
        char[] ans = new char[leng];



        while(leng> 0){
            if(dp[n][m] > dp[n][m-1]&& dp[n][m] > dp[n-1][m]){
                ans[leng-1] = (str1.charAt(n-1));
                n--;
                m--;
                leng --;
            }
            else if(dp[n][m] > dp[n][m-1] && dp[n][m] == dp[n-1][m]){
                n--;
            }
            else m--;

        }




        System.out.println(dp[n][m]);
        System.out.println(ans);

    }
}
