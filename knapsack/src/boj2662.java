import java.io.*;
import java.util.*;

public class boj2662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // n은 액수 m은 기업의 수
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] company = new int[m+1][n+1];
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            int cost =  Integer.parseInt(st.nextToken());
            for (int com = 1; com < m+1; com++) {
                company[com][cost] = Integer.parseInt(st.nextToken());
            }

        }




        int[][] dp = new int[m+1][n+1];
        int[][] prev = new int[m+1][n+1];

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                int max = 0;
                int tmp = 0;
                for (int k = 0; k < j+1; k++) {
                    if(company[i][k] + dp[i-1][j-k] > max) {
                        max = company[i][k] + dp[i-1][j-k];
                        tmp = k;
                    }
                }
                dp[i][j] = max;
                prev[i][j] = tmp;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i= m;
        int j = n;

        while(i >0 || j >0) {
            sb.insert(0,prev[i][j] + " ");

            j -= prev[i][j];
            i--;
        }
        System.out.println(dp[m][n]);
        System.out.println(sb.toString());





    }
}
