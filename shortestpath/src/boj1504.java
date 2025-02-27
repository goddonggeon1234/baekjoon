import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Arrays;

import static java.lang.System.exit;

public class boj1504 {
    static class node{
        int v;
        int w;
        public node(int v, int w){
            this.v = v;
            this.w = w;
        }
    }

    static ArrayList<node>[] map;

    static int inf = 987654321;

    static int[] dijkstra(int start){
        int[] adj = new int[map.length];
        Arrays.fill(adj, inf);
        adj[start] = 0;
        PriorityQueue<node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        pq.add(new node(start, 0));
        while(!pq.isEmpty()){
            node cur = pq.poll();
            int v = cur.v;
            int w = cur.w;
            for(node node : map[v]){
                if(adj[node.v] > node.w +w){
                    adj[node.v] = w + node.w;
                    pq.add(new node(node.v, adj[node.v]));
                }
            }
        }

        return adj;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        map = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a-1].add(new node(b-1, c));
            map[b-1].add(new node(a-1, c));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken())-1;
        int v2 = Integer.parseInt(st.nextToken())-1;

        int[] adj = dijkstra(0);
        if(adj[v1] == inf||adj[v2] == inf||adj[n-1] == inf) {
            System.out.println("-1");
            br.close();
            exit(0);
        }
        int dist_v1 = adj[v1];
        int dist_v2 = adj[v2];
        adj = dijkstra(n-1);

        dist_v1 += adj[v2];
        dist_v2 += adj[v1];



        int shortest = Math.min(dist_v1, dist_v2);

        adj = new int[n];
        Arrays.fill(adj, inf);
        adj[v1] = 0;
        PriorityQueue<node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        pq.add(new node(v1, 0));
        while(!pq.isEmpty()){
            node cur = pq.poll();
            int v = cur.v;
            int w = cur.w;
            if(v == v2) break;
            for(node node : map[v]){
                if(adj[node.v] > node.w +w){
                    adj[node.v] = w + node.w;
                    pq.add(new node(node.v, adj[node.v]));
                }
            }
        }
        shortest += adj[v2];

        System.out.println(shortest);






    }
}
