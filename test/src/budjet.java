import java.util.*;

public class budjet {

    public static long bs(long[] budgets, long limit){

        long lo = 1;
        long hi = Arrays.stream(budgets).max().getAsLong() +1;

        while(lo < hi){
            long mid = lo + (hi - lo)/2;
            long sum = 0;
            for(long budget : budgets) sum += Math.min(mid, budget);

            if(sum > limit) hi = mid;
            else lo = mid +1;
        }

        return hi - 1;




    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long [] budgets = new long[n];
        for (int i = 0; i < n; i++) budgets[i] = sc.nextLong();

        long m = sc.nextLong();

        System.out.println(bs(budgets, m));



        
    }
}
