import java.util.*;


public class kthnum {
    public static long search(long n, long k){
        long lo = 1;
        long hi = k;
//        System.out.println("test");

        while(lo < hi){
            long mid = lo + (hi - lo)/2;
            long sum = 0;
            for(int i = 1; i < n+1; i++) sum += Math.min(mid/i,n);

            if(sum < k) lo = mid +1;
            else hi = mid;
        }


        return lo ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();
//        System.out.println("test");
        System.out.println(search(n, k));
    }
}
