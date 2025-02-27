import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class boj1261_dijk {
    static int[][] map;
    static int[][] adj;
    static int inf = 987654321;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class node{
        int x, y;
        int cnt;
        public node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        adj = new int[n][m];
        for(int[] arr : adj){
            Arrays.fill(arr, inf);
        }
        adj[0][0] = 0;


        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        PriorityQueue<node> pq = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);
        pq.add(new node(0, 0, 0));
        while (!pq.isEmpty()) {
            node cur = pq.poll();
            int curx = cur.x;
            int cury = cur.y;
            int curcnt = cur.cnt;
            for (int i = 0; i < 4; i++) {
                int nx = curx + dx[i];
                int ny = cury + dy[i];
                if(nx<0||nx>n-1||ny<0||ny>m-1) continue;
                if(adj[nx][ny]> cur.cnt + map[nx][ny]){
                    adj[nx][ny] = cur.cnt + map[nx][ny];
                    pq.add(new node(nx, ny, adj[nx][ny]));
                }
            }

        }

        System.out.println(adj[n-1][m-1]);




    }
}
