import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj2178 {
    static Queue<pair> q = new LinkedList<>();
    static char[][] labyrinth;
    static int[][] dist;
    static int[] dx =  {-1, 1, 0, 0};
    static int[] dy =  {0, 0, -1, 1};


    public static class pair{
        int x;
        int y;
        pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        int getx(){ return x;}
        int gety(){ return y;}
        public String toString(){
            return x + ", " + y;
        }

    }
    public static void bfs(int n, int m){
        q.add(new pair(0 ,0));
        dist[0][0] = 1;

        while(!q.isEmpty()){
            pair cur = q.poll();
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx<0 || ny< 0 ||nx>= n || ny >=m ) continue;
                if(labyrinth[nx][ny] == '0' || dist[nx][ny] != -1) continue;
                q.add(new pair(nx,ny));
                dist[nx][ny]  = dist[cur.x][cur.y] + 1;



            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stt = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stt.nextToken());
        int m = Integer.parseInt(stt.nextToken());
        labyrinth = new char[n][m];
        dist = new int[n][m];



        for (int i = 0; i < n; i++) {
            String st = br.readLine();
            for (int j = 0; j < m; j++) {
                labyrinth[i][j] = st.charAt(j);
                dist[i][j] = -1;
            }
        }
        bfs(n, m);
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(dist[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(dist[n-1][m-1]);


    }
}
