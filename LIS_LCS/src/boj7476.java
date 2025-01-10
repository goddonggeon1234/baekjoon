import java.util.*;
import java.io.*;


public class boj7476{
    static void test(int[][][]dp){
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                System.out.print(dp[i][j][0] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=m;i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int[][][] dp = new int[n+1][m+1][3];



        for(int[][] row: dp){
            for(int[] col: row){
                col[1] = -1;
                col[2] = -1;
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(arr1[i] !=arr2[j]) continue;
                dp[i][j][0] += 1;
                for(int k=1+i;k<=n;k++){
                    if(arr1[i] >= arr1[k]) continue;
                    for(int l = 1+j; l<=m; l++){
                        if(arr1[k] == arr2[l]){
                            if(dp[k][l][0] <dp[i][j][0]){
                                dp[k][l][0] = dp[i][j][0];
                                dp[k][l][1] = i;
                                dp[k][l][2] = j;
                            }
                            break;
                        }
                    }
                }

            }
        }

        int leng = 0;
        int x= 0;
        int y = 0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(dp[i][j][0] > leng){
                    leng = dp[i][j][0];
                    x = i;
                    y = j;
                }
            }
        }




        System.out.println(leng);

        ArrayList<Integer> list = new ArrayList<>();
        while(x>0 || y>0){
            list.add(arr1[x]);
            int tmpx = x;
            int tmpy = y;
            x = dp[tmpx][tmpy][1];
            y = dp[tmpx][tmpy][2];

        }
        Collections.reverse(list);

        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
















    }
}