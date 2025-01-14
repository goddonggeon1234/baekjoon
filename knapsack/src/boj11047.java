import java.io.*;
import java.util.*;

public class boj11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n+1];
        for (int i = 1; i <= n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        for (int i = n, tmp = 0; i > 0; i--) {
            if ( k==0) break;
            if (coins[i] > k) continue;
            tmp = k/coins[i];
            k -= tmp*coins[i];
            ans += tmp;


        }

        ans = (k > 0) ? 0 : ans;

        System.out.println(ans);


    }
}
