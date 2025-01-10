import java.util.*;

public class boj11724_bfs {
    static int[] visit;
    static Queue<Integer> q;

    public static void bfs(int[][]graph , int s){
        visit[s] = 1;
        q.add(s);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i=0; i<graph[cur].length; i++){
                if(visit[i] ==0 && graph[cur][i] == 1){
                    visit[i] = 1;
                    q.add(i);

                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n][n];

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a-1][b-1] = graph[b-1][a-1] = 1;
        }

        q = new LinkedList<>();
        visit = new int[n];

        int num = 0;

        for(int i = 0; i < n; i++){
            if(visit[i] == 0){
                bfs(graph, i);
                num += 1;


            }
        }

        System.out.println(num);


    }
}
