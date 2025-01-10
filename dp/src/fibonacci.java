
import java.util.*;



public class fibonacci {
    static pair[] mem;

    static class pair{
        public int x;
        public int y;

        public pair add(pair pair) {
            return new pair(this.x + pair.x, this.y + pair.y);
        }
        public pair(int x,int y){
            this.x=x;
            this.y=y;
        }
        public String toString(){
            return this.x + " " + this.y;
        }
    }

    static pair fibo(int n){
        if (n <=1) return mem[n];
        if(mem[n]!=null) return mem[n];
        return mem[n] = fibo(n-1).add(fibo(n-2));


    }

    static pair fibo2(int n){
        if (n <=1) return mem[n];
        for(int i=2; i<=n; i++){
            mem[i] = mem[i-1].add(mem[i-2]);
        }
        return mem[n];

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        mem = new pair[41];
        mem[0] = new pair(1,0);
        mem[1] = new pair(0,1);

        for(int i=1;i<=n;i++){
            int m = sc.nextInt();
            System.out.println(fibo2(m));

        }

    }
}