import java.io.BufferedReader;
import java.util.*;
import java.io.InputStreamReader;

import java.io.IOException;



public class boj2667 {
    static int [][] home;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<pair> q = new LinkedList<>();

    static class pair{
        int x;
        int y;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
    static void bfs(){
        List<Integer> list = new ArrayList<>();

        q.clear();
        for (int i = 0; i < home.length; i++) {
            for (int j = 0; j < home[i].length; j++) {
                if(home[i][j] == 0) continue;
                if(visit[i][j]) continue;
                visit[i][j] = true;
                q.add(new pair(i, j));
                int num = 0;

                while(!q.isEmpty()){
                    pair cur = q.poll();
                    num += 1;
                    for(int k=0; k<4; k++){
                        int x = cur.x + dx[k];
                        int y = cur.y + dy[k];
                        if(x<0 || y<0 || x>=home.length || y>=home[i].length) continue;
                        if(visit[x][y] || home[x][y] == 0) continue;
                        visit[x][y] = true;
                        pair a = new pair(x, y);
                        q.add(a);



                    }

                }

                list.add(num);

            }
        }
        list.sort(null);
        System.out.println(list.size());
        for (Integer integer : list) System.out.println(integer);
    }




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st;
        int n = Integer.parseInt(br.readLine());
        home = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = br.readLine();
            for (int j = 0; j < n; j++) {
                home[i][j] = st.charAt(j) - '0';
            }

        }

        bfs();



    }

}
