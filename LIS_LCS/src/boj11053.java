import java.util.*;

public class boj11053 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int [n+1];
        int[] dp = new int[n+1];

        for (int i = 1; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            int curnum = arr[i];
            int curposmax = 0;
            for (int j = 1; j <= i; j++) {
                if(curnum> arr[j] && dp[j] > dp[curposmax]) {
                    curposmax = j;
                }

            }
            max = Math.max(max, (dp[i] = dp[curposmax]+1));
        }
        System.out.println(max);

    }
}
