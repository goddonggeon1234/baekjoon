import java.io.BufferedReader;
import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1726 {
    static int[][] map;

    static int[] dy = {0, 1, -1, 0, 0};
    static int[] dx = {0, 0, 0, 1, -1};



    static int[][][] visit;

    static int turnright(int dir){
        if(dir == 1) return 3;
        if(dir == 2) return 4;
        if(dir == 3) return 2;
        return 1;
    }
    static int turnleft(int dir){
        if(dir == 1) return 4;
        if(dir == 2) return 3;
        if(dir == 3) return 1;
        return 2;
    }
    static class pair{
        int x, y, z;
        public pair(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
        public String toString(){
            return "(" + x + "," + y + ", dir:" + z + ")";
        }
    }

    static int bfs(pair start, pair dest){
        int num = 0;
        Queue<pair> q = new LinkedList<>();

        visit[start.x][start.y][start.z] = 1;
        q.add(start);
        //시작
        while(true) {
            Queue<pair> nextq = new LinkedList<>();
            while (!q.isEmpty()) {
                //로테이션 시작
                    pair cur = q.poll();
                    if (cur.x == dest.x && cur.y == dest.y && cur.z == dest.z) return num;
                    for (int i = 1; i < 4; i++) {
                        int x = cur.x + dx[cur.z] * i;
                        int y = cur.y + dy[cur.z] * i;
                        if (x < 0 || y < 0 || x >= map.length || y >= map[0].length) continue;
                        if (map[x][y] == 1) break;
                        if (visit[x][y][cur.z] == 1) continue;
                        nextq.add(new pair(x, y, cur.z));
                        visit[x][y][cur.z] = 1;
                    }
                    if (visit[cur.x][cur.y][turnright(cur.z)] == 0) {
                        nextq.add(new pair(cur.x, cur.y, turnright(cur.z)));
                        visit[cur.x][cur.y][turnright(cur.z)] = 1;
                    }

                    if (visit[cur.x][cur.y][turnleft(cur.z)] == 0) {
                        nextq.add(new pair(cur.x, cur.y, turnleft(cur.z)));
                        visit[cur.x][cur.y][turnleft(cur.z)] = 1;
                    }





            }
            num += 1;
            //다음 로테이션 준비
            for (pair cur : nextq) {
                q.offer(cur);
            }


        }
    }



    public static void main(String[] args) throws IOException {
        int[] dx = {0, 1, -1, 0, 0};
        int[] dy = {0, 0, 0, -1, 1};


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int [n][m];
        visit = new int[n][m][5];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        pair start = new pair(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        pair dest = new pair(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));

        System.out.println(bfs(start, dest));









    }
}
