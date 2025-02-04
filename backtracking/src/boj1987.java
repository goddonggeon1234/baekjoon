import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class boj1987 {

    static int cnt = 0;
    static char[] footprint;
    static char[][] map;

    static int[] dx = {-1 ,1 ,0, 0};
    static int[] dy = { 0, 0, -1, 1};

    static void backtrack(int x, int y, int depth){
        if(endcheck(x,y,depth)){
            cnt = Math.max(cnt, depth-1);
            return ;
        }
        footprint[depth] = map[x][y];
        for(int i = 0, curx, cury ; i < 4 ; i++){
            curx = x + dx[i];
            cury = y + dy[i];
            backtrack(curx, cury, depth+1);
        }


    }

    static boolean endcheck(int x, int y, int depth){
        if(x < 0 || x >= map.length || y < 0 || y >= map[0].length) return true;
        for(int i = 0 ; i < depth ; i++){
            if(map[x][y] == footprint[i]) return true;
        }
        return false;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        footprint = new char[r * c +1 ];
        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
        }
        backtrack(0, 0, 1);

        System.out.println(cnt);





    }
}
