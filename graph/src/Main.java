import java.util.*;


public class Main {
    static int [] visited;
    static Queue<Integer> q;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int[][] graph, int start){
        visited[start-1] = 1;
        sb.append(start+" ");
        for(int  i =1; i <= graph[start-1].length; i++){
            if(graph[start-1][i-1] == 1 && visited[i-1] == 0) dfs(graph, i);
        }


    }

    public static void bfs(int[][] graph, int start){
        visited[start -1] = 1;
        q.add(start);
        while(!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur+" ");
            for(int  i =1; i <= graph[cur-1].length; i++) {
                if (graph[cur - 1][i-1] == 1 && visited[i - 1] == 0) {
                    q.add(i);
                    visited[i - 1] = 1;
                }
            }

        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();

        int[][] graph = new int[n][n];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a-1][b-1] = graph[b-1][a-1] =  1;
        }
        visited = new int[n];
        dfs(graph, start);
        visited = new int[n];
        sb.append("\n");
//        System.out.println(sb);
        q = new LinkedList<>();
        bfs(graph, start);
        System.out.println(sb);


    }
}