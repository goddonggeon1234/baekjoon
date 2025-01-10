import java.io.InputStreamReader;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.Object;


public class boj7576 {
//    public static class LinkedList<E> extends LinkedList<E>{
//        public LinkedList<E> deepclone() {
//            LinkedList<E> clonedList = new LinkedList<>();
//            for (E element : this) {
//                clonedList.add(element); // 객체가 복사될 때 직접 처리하도록
//            }
//            return clonedList;
//        }
//    }
    static int[][] box;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static Queue<Queue<pair>> fq = new LinkedList<>();
    static Queue<pair> secondq;

    public static class pair{
        public int x;
        public int y;
        pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
        public String toString(){
            return "(" + x+ ", " +y + ")";
        }
    }

    public static int bfs (int n, int m){
        int days = 0;
        Queue<pair> myqueue = new LinkedList<>();
        for(pair element : secondq){
            myqueue.offer(element);
        }

        fq.offer(myqueue);

        while(!fq.isEmpty()){
            Queue<pair> curq = fq.poll();
            secondq = new LinkedList<>();
            while(!curq.isEmpty()){
                pair cur = curq.poll();
                int x = cur.x;
                int y = cur.y;

                for(int i = 0; i < 4; i++){
                    int curdx = x+ dx[i];
                    int curdy = y+ dy[i];
                    if (curdx <0 || curdx >=n || curdy <0|| curdy >=m) continue;
                    if (box[curdx][curdy] == 1 || box[curdx][curdy] == -1) continue;
                    secondq.add(new pair(curdx, curdy));
                    box[curdx][curdy] = 1;

                }



            }

            if(!secondq.isEmpty()){
                myqueue = new LinkedList<>();
                for(pair element : secondq){
                    myqueue.offer(element);
                }
                fq.offer(myqueue);
                days += 1;
            }

//            for(int i=0; i<n; i++){
//                for(int j=0; j<m; j++){
//                    System.out.print(box[i][j] + " ");
//                }
//                System.out.println();
//            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(box[i][j] == 0){
                    days = -1;
                    break;
                }
            }
        }


        return days;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stt = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(stt.nextToken());
        int n = Integer.parseInt(stt.nextToken());

        box = new int[n][m];
        pair start;
        secondq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            stt = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] =  Integer.parseInt(stt.nextToken());
                if (box[i][j] == 1){
                    start = new pair(i, j);
                    secondq.add(start);
                }
            }
        }
        System.out.println(bfs(n, m));



//        for(int i=0; i<n; i++){
//            for(int j=0; j<m; j++){
//                System.out.print(box[i][j]+" ");
//            }
//            System.out.println();
//        }



    }
}
