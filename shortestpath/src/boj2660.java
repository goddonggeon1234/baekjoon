import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2660 {

    static int[][] map;
    static int[] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        score = new int[n];
        int inf = 100000;
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], inf);
            map[i][i] = 0;
        }
        for (int i = 0; i < n; i++) {

        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken())-1;
        int b = Integer.parseInt(st.nextToken())-1;

        while(!(a==-2 && b==-2)) {
            map[a][b] = 1;
            map[b][a] = 1;
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken())-1;
            b = Integer.parseInt(st.nextToken())-1;
        }
        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(map[i][j]> map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }

                }
            }
        }
        for(int i=0;i<n;i++) {
//            System.out.println(Arrays.toString(map[i]));
            score[i] = Arrays.stream(map[i]).max().getAsInt();
        }
        int min = Arrays.stream(score).min().getAsInt();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<n; i++) {
            if(min == score[i]) {
                list.add(i+1);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(list.size()).append("\n");
        for(int i : list){
            sb.append(i).append(" ");
        }
        sb.append("\n");

        System.out.println(sb);



    }

}
