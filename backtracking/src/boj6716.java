import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class boj6716 {

    static class pair{
        int x;
        int y;
        public pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static boolean[] visited;
    static int cnt;
    static pair start;
    static pair[] beepers;
    static pair map;

    static StringBuilder sb = new StringBuilder();

    static void pickup(int bnum, int curb, int dist){
        if(bnum == beepers.length-1){
            int difx = Math.abs(beepers[curb].x - beepers[0].x);
            int dify = Math.abs(beepers[curb].y - beepers[0].y);
            cnt  = Math.min(cnt, dist + difx + dify);
            return ;
        }
        for(int i = 1 ; i < beepers.length ; i++){
            if(!visited[i]){
                visited[i] = true;
                int difx = Math.abs(beepers[i].x - beepers[curb].x);
                int dify = Math.abs(beepers[i].y - beepers[curb].y);
                pickup(bnum+1, i, dist + difx + dify);
                visited[i] = false;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            start = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            int m = Integer.parseInt(br.readLine());
            beepers = new pair[m+1];
            visited = new boolean[m+1];
            for (int j = 1; j < m+1; j++) {
                st = new StringTokenizer(br.readLine());
                beepers[j] = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            beepers[0] = start;
            cnt = Integer.MAX_VALUE;
            pickup(0, 0, 0);
            sb.append("The shortest path has length " + cnt);
            sb.append("\n");

        }
        System.out.print(sb);
        br.close();
    }

}
