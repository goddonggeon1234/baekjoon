import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj3055 {
    static class pair{
        int x;
        int y;
        public pair(int x, int y){
            this.x = x;
            this.y = y;
        }

    }

    static String[][] map;
    static Queue<pair> water;




    static int[] flow_x = {-1,1, 0, 0};
    static int[] flow_y = {0,0, 1, -1};

    static void waterflow(){

        int size = water.size();
        while(size-- > 0){
            pair flow = water.poll();
            int x = flow.x;
            int y = flow.y;
            for(int i=0; i<4; i++){
                int newX = x + flow_x[i];
                int newY = y + flow_y[i];
                if(newX <0 || newX >= map.length || newY <0 || newY >= map[0].length){
                    continue;
                }
                if(map[newX][newY].equals("X") || map[newX][newY].equals("D")|| map[newX][newY].equals("*")){
                    continue;
                }
                else {
                    map[newX][newY] = "*";
                    water.add(new pair(newX, newY));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stt = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(stt.nextToken());
        int m = Integer.parseInt(stt.nextToken());
        map = new String[n][m];

        water = new LinkedList<>();
        Queue<pair> victim = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String st = in.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = String.valueOf(st.charAt(j));
                if (map[i][j].equals("S")) {
                    victim.offer(new pair(i, j));

                }
                else if(map[i][j].equals("*")){
                    water.add(new pair(i, j));
                }
            }
        }

        if(victim.isEmpty()){
            System.out.println("KAKTUS");
            return ;
        }



        int days = 0;
        boolean clear = false;

        while(!victim.isEmpty() & !clear){
            waterflow();

            int size = victim.size();
            while(size-- > 0){
                pair curvictim = victim.poll();
                int x = curvictim.x;
                int y = curvictim.y;


                for(int i=0; i<4; i++){
                    int newX = x + flow_x[i];
                    int newY = y + flow_y[i];
                    if(newX < 0 || newX >= map.length || newY <0 || newY >= map[0].length){
                        continue;
                    }
                    else if(map[newX][newY].equals("*")||map[newX][newY].equals("X")||map[newX][newY].equals("#")){
                        continue;
                    }
                    else if(map[newX][newY].equals("D")){
                        clear = true;
                        break;
                    }
                    else if(map[newX][newY].equals(".")){
                        map[newX][newY] = "#";
                        victim.offer(new pair(newX, newY));
                    }
                }
                if(clear) break;

            }
            days++;



/*
            for(int i=0; i< map.length; i++){
                for(int j=0; j< map[0].length; j++){
                    System.out.print(map[i][j]+ " ");
                }
                System.out.println();
            }
            System.out.println(days + "day is over");
*/


        }
        if(clear) System.out.println(days);
        else System.out.println("KAKTUS");


    }
}