import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.System.exit;


public class boj2661 {
    static int[] sol;
    static StringBuilder sb = new StringBuilder();
    static void backtrack(int depth){
        if(depth == sol.length){
            //dfs로 백트래킹을 햇을때 최초로 만들어진 수가 가장 작은수
            for(int i = 0; i < sol.length; i++){
                sb.append(sol[i]);
            }
            System.out.println(sb);
            exit(0);
        }

        for(int i=1; i< 4; i++){
//            System.out.println(depth);
            sol[depth] = i;
            if (check(depth)) backtrack(depth+1);
        }
    }

    static boolean check(int depth) {
        boolean flag = false;


        //가장 뒤에서부터 중간까지 반복수가 없는지 확인
        for(int i=1; i <= (depth+1)/2; i++){
            flag = true;
            for(int j=0; j <i; j++){
                flag = flag  && (sol[depth -j] == sol[depth-j-i]);
            }
            if(flag) break;
        }
        return !flag;


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        sol = new int[n];

        backtrack(0);

    }
}
