import java.io.*;
import java.util.*;

public class boj2091 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[][] coins = new int[5][2];

        //[0]은 갯수 [1] 가치
        for (int i = 1; i < 5; i++) {
            switch(i){
                case 1:
                    coins[i][0] = 1;
                    coins[i][1] = a;
                    break;
                case 2:
                    coins[i][0] = 5;
                    coins[i][1] = b;
                    break;
                case 3:
                    coins[i][0] = 10;
                    coins[i][1] = c;
                    break;
                default:
                    coins[i][0] = 25;
                    coins[i][1] = d;
            }
        }
        int[][] dp = new int[5][x+1];
        int[][] prev = new int[5][x+1];


        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < x+1; j++) {
                int max = 0;
                int tmp = 0;
                for (int k = 0; k <= coins[i][1]; k++) {
                    if(j < coins[i][0]*k) break;
                    if(dp[i-1][j-coins[i][0]*k] == 0 && coins[i][0]*k != j){
                        continue;
                    }
                    if(max < dp[i-1][j-coins[i][0]*k] + k){
                        max = dp[i-1][j-coins[i][0]*k] +k ;
                        tmp = k;
                    }

                }
                dp[i][j] = max;
                prev[i][j] = tmp;

            }

        }


        StringBuilder sb = new StringBuilder();

        for (int i = 4; i >0 ; i--) {

            sb.insert(0,prev[i][x] + " ");
            x -= prev[i][x]*coins[i][0];
        }

        System.out.println(sb);






    }
}