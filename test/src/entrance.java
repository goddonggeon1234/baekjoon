import java.util.*;

public class entrance {
    public static long search(long[] testers, long m){

        long lo = Arrays.stream(testers).min().getAsLong();
        long hi = Arrays.stream(testers).min().getAsLong() * m + 1;

        while (lo < hi){
            long mid = lo + (hi - lo) / 2;
            long sum = 0;

            for(long test : testers) sum += mid/test;

            if(sum >= m ) hi = mid;
            else lo = mid + 1;
        }



        return lo;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextLong();

        long [] testers = new long[n];

        for (int i = 0; i < n; i++) {
            testers[i] = sc.nextLong();
        }

        System.out.println(search(testers, m));




    }
}
