import java.util.*;

public class lancable {
    public static long ps(long[] cables, int n){
        long lo = 1;
        Arrays.sort(cables);
        long hi = Arrays.stream(cables).max().getAsLong();
//        long hi = Arrays.stream(cables).min().getAsLong();

        hi += 1;
//        System.out.println(hi);

        while(lo < hi){
            long mid = lo + (hi - lo)/2;
            long sum = 0;
            for(long cable : cables) sum += cable/mid;


//            System.out.println(mid);
//            System.out.println(sum);
//
//            System.out.println(lo + ", " + hi);

            if(sum < n) hi = mid;
            else lo = mid +1;

        }
//
//        int sum = 0;
//        for(int cable : cables) sum += cable/lo;


//        System.out.println(sum);

        return hi - 1;


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();
        long[] cables = new long[k];

        for(int i = 0; i < k; i++)  cables[i] = sc.nextLong();

        System.out.println(ps(cables, n));




    }
}
