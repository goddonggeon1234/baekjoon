import java.io.IOException;
import java.util.*;

public class boj2565 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n+1][2];

        for (int i = 1; i <= n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();

        }
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        int[] dp = new int[n+1];

        int max = 0;
        for (int i = 1; i <= n; i++) {
            int curnum = arr[i][1];
            int curmaxpos = 0;
            for (int j = 1; j < i; j++) {
                if(curnum > arr[j][1]&& dp[j] > dp[curmaxpos]) curmaxpos = j;
            }
            max = Math.max(max, dp[i] = dp[curmaxpos] + 1);
        }
        System.out.println(n - max);

        Stack<Integer> stack = new Stack<>();
        for(int i =n; i>0; i--){
            if(dp[i] == max){
                stack.push(arr[i][1]);
                max --;
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();


    }
}