import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1753 {
    static class node{
        public int v;
        public int w;

        public node(int end, int weight){
            this.v = end;
            this.w = weight;
        }
    }

    static int inf = 10000000;
    static List<node>[] graph;
    static int[] dist;


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        dist = new int[n+1];

        Arrays.fill(dist, inf);
        graph = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) graph[i] = new ArrayList<>();

        int start = Integer.parseInt(br.readLine());
        dist[start] = 0;

        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new node(v,w));
        }
        PriorityQueue<node>pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        pq.add(new node(start , 0));


        while(!pq.isEmpty()){
            node cur = pq.poll();

            for(node node : graph[cur.v]){
                int v = node.v;
                int w = node.w;
                if(dist[v] > cur.w +w) {
                    dist[v] = cur.w + w;
                    pq.add(new node(v, dist[v]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=n; i++){
            if(dist[i] != inf) sb.append(dist[i]);
            else sb.append("INF");
            sb.append("\n");
        }

        System.out.println(sb);




    }
}