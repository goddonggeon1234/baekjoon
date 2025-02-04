import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class boj9663 {
    static int n;
    static int cnt = 0;
    static int[] sol;

    static void backtrack(int depth){
        if(depth ==n+1){
            cnt++;
            return;
        }
        for(int i =1;i< n+1;i++){
            sol[depth] = i;
            if(check(depth)) backtrack(depth+1);

        }

    }

    static boolean check (int depth){
        for(int i =1; i<depth;i++){
            if(sol[i] == sol[depth] ||
                    Math.abs(sol[depth]-sol[i])==Math.abs(depth- i) ) return false;

        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sol = new int[n+1];

        backtrack(1);
        System.out.println(cnt);


    }
}
