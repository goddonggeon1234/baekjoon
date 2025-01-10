import java.io.BufferedReader;
import java.util.*;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class boj7562 {
    static int [] l;
    static pair[] start;
    static pair[] dest;

    static int[] dx = {1, 1, 2, 2, -1, -1, -2, -2};
    static int[] dy = {2, -2, 1, -1, 2, -2, 1, -1};


    static class pair{
        int x;
        int y;
        pair(int x,int y){
            this.x=x;
            this.y=y;
        }
        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
    static int bfs(int a, pair start, pair dest){
        int num = 0;
        int[][] board = new int[a][a];
        board[start.x][start.y] = 0;
        Queue<pair> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            pair cur = q.poll();
            if(cur.x == dest.x && cur.y == dest.y){ return board[cur.x][cur.y]; }
            for(int i=0; i<dx.length; i++){
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];
                if(x<0 || x>=a || y<0 || y>=a) continue;
                if(board[x][y]>0) continue;
                board[x][y] = 1 + board[cur.x][cur.y];
                q.add(new pair(x,y));

            }


        }




        return num;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();
        l = new int[n];
        start = new pair[n];
        dest = new pair[n];

        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int fx = sc.nextInt();
            int fy = sc.nextInt();
            start[i] = new pair(x, y);
            dest[i] = new pair(fx,fy);

        }

        for(int i=0; i<n; i++){
            System.out.println(bfs(l[i], start[i], dest[i]));
        }


    }
}
