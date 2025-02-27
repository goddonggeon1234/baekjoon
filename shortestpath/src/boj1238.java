import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1238 {
    static class node{
        public int v;
        public int w;
        public node(int v, int w){
            this.v = v;
            this.w = w;
        }
    }

    static ArrayList<node>[] map;

    static int[] toparty;
    static int[] tohome;

    static int inf = 1987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken())-1;

        map = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        toparty = new int[n];
        tohome = new int[n];

        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[--a].add(new node(--b,c));
        }
        PriorityQueue<node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);

        for (int i = 0; i < n; i++) {
            pq.clear();
            int[] adj = new int[n];
            Arrays.fill(adj, inf);
            adj[i] = 0;
            if(i == x){
                continue;
            }
            pq.add(new node(i, 0));
            while(!pq.isEmpty()){
                node cur = pq.poll();
                int v = cur.v;
                int w = cur.w;

                if(v == x){
                    toparty[i] = w;
                    break;
                }

                for(node node: map[v]){
                    if(adj[node.v] > node.w +w){
                        adj[node.v] =node.w +  w;
                        pq.add(new node(node.v, adj[node.v]));
                    }
                }
            }
        }

        pq.clear();
        Arrays.fill(tohome, inf);
        tohome[x] = 0;
        pq.add(new node(x, 0));
        while(!pq.isEmpty()){
            node cur = pq.poll();
            int v = cur.v;
            int w = cur.w;
            for(node node: map[v]){
                if(tohome[node.v] > node.w + w){
                    tohome[node.v] =node.w +  w;
                    pq.add(new node(node.v, tohome[node.v]));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            tohome[i] += toparty[i];
        }

        System.out.println(Arrays.stream(tohome).max().getAsInt());






    }
}
