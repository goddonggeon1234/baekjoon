import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2629 {
    static int[] weights;
    //memoizaion 활용
    static boolean[][] checkboard;


    static StringBuilder sb = new StringBuilder();

    static void backtrack(int depth, int ans){
        if (checkboard[depth][ans]) return;
        checkboard[depth][ans] = true;
        if(depth == weights.length-1) return;

        int weight = weights[depth+1];
        backtrack(depth+1, ans);
        backtrack(depth+1, ans + weight);
        backtrack(depth+1, Math.abs(ans - weight));

    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int weightnum = Integer.parseInt(br.readLine());
        weights = new int[weightnum+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= weightnum; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }
        checkboard = new boolean[weightnum+1][150001];

        backtrack(0, 0);

        int beadnum = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < beadnum; i++) {
            int bead = Integer.parseInt(st.nextToken());

            if(bead > 15000) sb.append("N ");
            else sb.append(checkboard[weightnum][bead] ? "Y " : "N ");
        }

        System.out.println(sb);
        br.close();






    }

}
