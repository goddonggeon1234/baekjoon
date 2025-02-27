import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Arrays;

public class boj1261 {
    static class person{
        int x;
        int y;
        int cnt;
        public person(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int bfs(int n, int m){
        PriorityQueue<person> pq = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);
        pq.add(new person(0, 0, 0));
        while(!pq.isEmpty()){
            person cur = pq.poll();
            int curx = cur.x;
            int cury = cur.y;
            if(curx == n-1 && cury == m-1){
                return cur.cnt;
            }
            int curcnt = cur.cnt;
            for(int i = 0; i < 4; i++){
                int x = curx + dx[i];
                int y = cury + dy[i];
                if(x< 0 || x>n-1 || y< 0 || y>m-1) continue;
                if(!visited[x][y]){
                    visited[x][y] = true;
                    pq.add(new person(x, y, curcnt+map[x][y]));
                }


            }
        }
        return -1;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }

        }
        int cnt = bfs(n, m);
        System.out.println(cnt);




    }
}
