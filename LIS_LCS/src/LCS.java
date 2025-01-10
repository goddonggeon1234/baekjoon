import java.util.*;

public class LCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[sc.nextInt()+1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int max = 0;
        int[] dp = new int[arr.length];

        /*for (int i = 1; i < arr.length; i++) {
            int curnum = arr[i];
            int curmaxpos = 0;
            for (int j = 1; j <= i; j++) {
                if(curnum > arr[j] && dp[j] > dp[curmaxpos]) curmaxpos = j;
            }
            max = Math.max(max, (dp[i] = dp[curmaxpos] + 1));

        }*/

        for(int i=1; i<arr.length; i++){
            dp[i] = 1;
            for(int j=1; j<i; j++){
                if(arr[i]>arr[j]) dp[i] = Math.max(dp[i], dp[j]+1);

            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);


    }
}