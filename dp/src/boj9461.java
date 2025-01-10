import java.util.*;

public class boj9461 {
    static int[] fmap = {1, 1, 1, 2, 2};
    static int spiralarr(int n){
        if(n<=5) return fmap[n-1];
        long[] map = new long[n];
        for(int i=0; i<5; i++){
            map[i] = fmap[i];
        }
        for(int i=5; i<n; i++){
            map[i] = map[i-5] + map[i-1];
        }
        return map[n-1];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(spiralarr(sc.nextInt()));
        }


    }
}
