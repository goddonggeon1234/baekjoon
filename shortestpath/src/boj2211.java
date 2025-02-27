import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Collections;


public class boj2211 {
    static int[] dist;
    static ArrayList<node>[] map;
    static ArrayList<node>[] track;
    static int inf = 99999999;

    static class node{
        int v;
        int w;
        public node(int v, int w){
            this.v = v;
            this.w = w;
        }

        public String toString(){
            return v + " " + w;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        dist = new int[n];
        Arrays.fill(dist, inf);

        track = new ArrayList[n];
        map = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
            track[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(st.nextToken());

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a-1].add(new node(b-1,c));
            map[b-1].add(new node(a-1,c));
        }

        PriorityQueue<node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        dist[0] = 0;
        pq.add(new node(0, 0));

        ArrayList<node> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            node cur = pq.poll();
            int v = cur.v;
            int w = cur.w;
            for(node node : track[v]){
                if(!ans.contains(node))ans.add(node);
            }
            for(node node : map[v]){
                if(dist[node.v] > w +node.w){
                    dist[node.v] = w + node.w;
                    pq.add(new node(node.v, dist[node.v]));
                    track[node.v].clear();
                    track[node.v].addAll(track[v]);

                    int minv = Math.min(v, node.v);
                    int maxv = Math.max(v, node.v);
//                    track[node.v].add(new node(v, node.v));

                    track[node.v].add(new node(minv+1, maxv+1));



                }
            }
        }
        StringBuilder sb = new StringBuilder();

        sb.append(ans.size()).append("\n");

        for(node node : ans){
            sb.append(node.toString()).append("\n");
        }





        System.out.print(sb);

    }
}
