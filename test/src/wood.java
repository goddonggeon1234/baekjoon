import java.util.*;

public class wood {

    public static long bs(long[] woods, long limit){

        long lo = 1;
        long hi = Arrays.stream(woods).max().getAsLong() +1;

        while(lo < hi){
            long mid = lo + (hi - lo)/2;
            long sum = 0;
            for(long wood : woods) sum += Math.max(0, wood- mid);

            if(sum >= limit) lo = mid +1;
            else hi = mid;
        }

        return hi - 1;




    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m =sc.nextLong();


        long [] woods = new long[n];
        for (int i = 0; i < n; i++) woods[i] = sc.nextLong();



        System.out.println(bs(woods, m));




    }
}
