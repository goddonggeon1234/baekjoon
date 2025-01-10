import java.util.*;

public class boj11727 {
    static long[] mem;
    static long get(int n){
        if(n <3) return mem[n];
        for(int i=3;i<=n;i++){
            int a = i%2;
            mem[i] = (2*mem[i-2] + mem[i-1])%10007;
        }
        return mem[n];

    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        mem = new long[n+1];

        mem[1] = 1;
        if( n>1) mem[2] = 3;

        System.out.println(get(n));


    }
}
