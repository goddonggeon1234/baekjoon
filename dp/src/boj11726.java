import java.util.*;


public class boj11726 {
    static int[] mem;

    static int get(int n){
        if(n <= 2) return mem[n];
        for(int i =3; i<=n; i++){
            mem[i] = (mem[i-2] + mem[i-1]);
        }
        return mem[n];
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        mem = new int[n+1];
        mem[1] = 1;
        mem[2] = 2;

        System.out.println(get(n));


    }
}
