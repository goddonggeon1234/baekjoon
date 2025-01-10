import java.util.*;

public class jewerly {
    public static int quot(int a, int b) {
        return a/b + (a%b ==0 ? 0 : 1);
    }

    public static int bs(int[] jewers, int n){
        int arrsum = Arrays.stream(jewers).sum();

        int lo = quot(arrsum , n);
        int hi = Arrays.stream(jewers).max().getAsInt();

        while(lo< hi){
            int mid = lo + (hi - lo)/2;
            int sum = 0;
            for (int jewer : jewers) sum += quot(jewer, mid);
            if( sum <= n) hi = mid;
            else lo = mid+ 1;
        }

        return lo;


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] jewers = new int[m];
        int sum = 0;

        for (int i = 0; i < m; i++) {
            jewers[i] = sc.nextInt();

        }

        System.out.println(bs(jewers, n));



    }
}

