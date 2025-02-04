import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.exit;


public class boj5520 {


    //move method
    static class move{
        int[] method;
        public move(int[] method){
            this.method = method;
        }
        public void turn(int [] tmp_clock){
            for (int j : method) {
                tmp_clock[j] = (tmp_clock[j] + 1) % 4;
            }
        }

    }

    static move[] moves = new move[10];


    static int[] clocks = new int[10];
    //지금까지 사용된 move들
    static int[] sol = new int[10];

    static StringBuilder sb = new StringBuilder();

    static void search(int depth){
        if(depth == 10){

            int[] tmp = clocks.clone();
            for (int i = 1; i < depth; i++) {
                for(int j = 1; j <= sol[i]; j++){
                    moves[i].turn(tmp);
                }
            }

            if(Arrays.stream(tmp).sum() ==0){
                for(int i = 1; i < depth; i++){
                    for(int j = 1; j <= sol[i]; j++){
                        sb.append(i).append(" ");
                    }
                }
                System.out.println(sb);
                exit(0);
            }
            return ;

        }

        for(int i = 0; i < 4; i++){
            sol[depth] = i;
            search(depth+1);
        }


    }



    public static void main(String[] args) throws IOException {
        moves[1] = new move(new int[]{1, 2, 4, 5});
        moves[2] = new move(new int[]{1, 2, 3});
        moves[3] = new move(new int[]{2, 3, 5, 6});
        moves[4] = new move(new int[]{1, 4, 7});
        moves[5] = new move(new int[]{2, 4, 5, 6, 8});
        moves[6] = new move(new int[]{3, 6, 9});
        moves[7] = new move(new int[]{4, 5, 7, 8});
        moves[8] = new move(new int[]{7, 8, 9});
        moves[9] = new move(new int[]{5, 6, 8, 9});

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            clocks[3*i+1] = Integer.parseInt(st.nextToken());
            clocks[3*i+2] = Integer.parseInt(st.nextToken());
            clocks[3*i+3] = Integer.parseInt(st.nextToken());
        }

        search(1);





    }
}
