import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class boj1916 {
    static class node implements Comparable<node> {
        public int v;
        public int w;
        public node(int v, int w){
            this.v = v;
            this.w = w;
        }

        public int compareTo(node n){
            return this.w - n.w;
        }
    }

    static int[] dist;
    static ArrayList<node> adj[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dist = new int[n+1];
        adj = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            adj[i] = new ArrayList<>();
        }
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new node(b ,c));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());

        int inf = Integer.MAX_VALUE;

        Arrays.fill(dist, inf);
        dist[start] = 0;

        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.add(new node(start, 0));

        boolean flag = false;

        while (!pq.isEmpty()) {
            node cur = pq.poll();
            if(cur.v == dest) flag = true;
            if(flag) break;
            for(node node : adj[cur.v]) {
                int v = node.v;
                int w = node.w;
                if(dist[v] > cur.w + w){
                    dist[v] = cur.w + w;
                    pq.add(new node(v, w + cur.w));
                }
            }
        }

        System.out.println(dist[dest]);
        br.close();







    }
}
