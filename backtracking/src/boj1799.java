import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class boj1799 {
    static int n;
    //대각선의 비숍확인
    static boolean[] diag1, diag2;
    static int[][] map;

    static int black = 0, white = 0;

    static void backtrack(int row, int col, int cnt, boolean isblack){
        if(col >=n){
            row++;
            col = (col%2 ==1) ? 0 :1;
        }
        if(row ==n){
            if(isblack) black = Math.max(black, cnt);
            else white = Math.max(white, cnt);
            return;
        }

        if(map[row][col] == 1 && diag1[row + col] && diag2[row - col + n -1]){
            diag1[row + col] = diag2[row- col +n -1] = false;
            backtrack(row, col +2, cnt+1, isblack);
            diag1[row + col] = diag2[row- col +n -1] = true;
        }
        backtrack(row, col+2, cnt, isblack);

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        diag1 = new boolean[2*n];
        Arrays.fill(diag1, true);
        diag2 = new boolean[2*n];
        Arrays.fill(diag2, true);


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtrack(0 ,0 ,0, true);
        backtrack(0 ,1 ,0, false);
        System.out.println(black + white);



        //확인 할것:
        //대각선 비숍확인 : boolean[]  o(n)
        //흑백 나눠서 확인
        //greedy로 하면 안됨 넣고 안넣고 확인 다해봐야함
        //원상복구 시켜놓을것

    }
}
