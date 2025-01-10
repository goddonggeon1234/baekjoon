import java.util.*;

public class boj14002 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];

        for(int i=1;i<=n;i++){
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[n+1];
        int max = 0;
        for(int i=1;i<=n;i++){
            int curnum = arr[i];
            int curmaxpos = 0;
            for(int j=0;j<i;j++){
                if(curnum > arr[j]&& dp[j] > dp[curmaxpos]){
                    curmaxpos = j;
                }
            }
            max = Math.max(max, dp[i] = dp[curmaxpos] + 1);
        }
        int curmax = max;
        Stack<Integer> stack = new Stack<>();
        for(int i=n;i>0;i--){
            if(dp[i] == curmax){
                stack.push(arr[i]);
                curmax --;
            }
        }
        System.out.println(max);
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
