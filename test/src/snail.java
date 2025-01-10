import java.util.*;


public class snail {

    public static int check(int a, int b, int day){
        return (a-b)*(day-1) + a;


    }

    public static int bs(int a, int b, int v){
        int lo = v /a ;
        int hi = v /(a-b) +1;

        while(lo< hi){
            int mid = lo + (hi-lo)/2;
            int length = check(a,b,mid);

            if(length < v) lo= mid +1;
            else hi = mid;

        }

        return lo;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int v = sc.nextInt();

        System.out.println(bs(a,b,v));
        int answer = (v-b)/(a-b) + ((v-b)%(a-b) ==0 ? 0 : 1);
        System.out.println(answer);


    }
}
