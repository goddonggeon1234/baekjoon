import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj4485 {
    static int[][] map;
    static int[][] adj;
    static int inf = 9999999;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class node{
        int x, y, cnt;
        public node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<node> pq = new PriorityQueue<>((o1,o2) ->o1.cnt -o2.cnt);

        int n = Integer.parseInt(br.readLine());
        int turn =1;
        while(n !=0){
            map = new int[n][n];
            adj = new int[n][n];
            for(int i = 0; i < n; i++){
                Arrays.fill(adj[i], inf);
            }

            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            adj[0][0] = map[0][0];
            pq.offer(new node(0, 0, adj[0][0]));
            while(!pq.isEmpty()){
                node cur = pq.poll();

                for(int i=0; i<4; i++){
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if(nx<0||nx>n-1||ny<0||ny>n-1) continue;
                    if(adj[nx][ny]> cur.cnt + map[nx][ny]){
                        adj[nx][ny] = cur.cnt + map[nx][ny];
                        pq.offer(new node(nx, ny, adj[nx][ny]));
                    }
                }
            }
//            for(int i=0; i<n; i++){
//                System.out.println(Arrays.toString(adj[i]));
//            }
            sb.append("Problem ").append(turn++).append(": ");
            sb.append(adj[n-1][n-1]).append("\n");

            n = Integer.parseInt(br.readLine());



        }

        System.out.print(sb);
    }
}
