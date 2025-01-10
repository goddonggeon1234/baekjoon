import java.io.BufferedReader;
import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj2206 {

    static int[][] map;
    static int[] dx = {-1 ,1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int[][][] visit;

    static class pair{
        int x;
        int y;
        int z;
        public pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public String toString() {
            return "(" + x + ", " + y + ", num:" + z + ")";
        }
    }
    static int bfs(int n, int m) {



        int num= 1;
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(0,0, 0));
        visit[0][0][0] = 1;


        while (!q.isEmpty()) {
            pair cur = q.poll();
            if(cur.x == n-1 && cur.y == m-1) return visit[cur.x][cur.y][cur.z];

            for (int i = 0; i < 4; i++) {
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];
                if (x < 0 || x >= n || y < 0 || y >= m) continue;
                if(visit[x][y][cur.z] !=-1) continue;
                if (map[x][y] == 1) {
                    if(cur.z ==0 && visit[x][y][1] == -1){
                        visit[x][y][1] = visit[cur.x][cur.y][0]+ 1;
                        q.offer(new pair(x,y,1));
                    }
                    else continue;
                }
                else{

                    visit[x][y][cur.z] = visit[cur.x][cur.y][cur.z]+1;
                    q.offer(new pair(x,y,cur.z));
                }

            }



        }






        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
                visit[i][j][0] = -1;
                visit[i][j][1] = -1;
            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(visit[i][j][0] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(visit[i][j][1] + " ");
            }
            System.out.println();
        }*/
        System.out.println(bfs(n, m));


    }
}
