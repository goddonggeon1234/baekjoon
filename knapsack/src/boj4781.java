import java.io.*;
import java.util.*;

public class boj4781 {

    static int knapsack(int n, int m, int[][] candies){
        int[] dp  = new int[m+1];
        for(int i=1;i<=n;i++){
            int curcarl = candies[i][0];
            int curcost = candies[i][1];

            for(int j=candies[i][1];j<=m;j++){
                dp[j] = Math.max(dp[j], dp[j-curcost]+curcarl);
            }
        }
        return dp[m];
    }




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Math.round(100*Float.parseFloat(st.nextToken()));
        StringBuilder sb = new StringBuilder();

        while(n != 0){
            int[][] candies = new int[n+1][2];
            for(int i=1; i<=n; i++){
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int p = (Math.round(Float.parseFloat(st.nextToken())*100));
                //[0]은 칼로리 [1]은 가격
                candies[i][0] = c;
                candies[i][1] = p;
            }
            sb.append(knapsack(n, m , candies)).append("\n");
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Math.round(100*Float.parseFloat(st.nextToken()));
        }

        System.out.print(sb);
    }
}
