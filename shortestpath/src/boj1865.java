import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1865 {
    static class node{
        public int e;
        public int w;

        public node(int e, int w){
            this.e = e;
            this.w = w;
        }
    }
    static ArrayList<node>[] map;
    static int[] adj;
    static int inf = 10000000;
    static boolean bellman(){
        int n = map.length-1;

        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(node node: map[i]){
                    if(adj[node.e] >adj[i] + node.w){
                        adj[node.e] = adj[i] + node.w;
                        if( k == n) return true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());
        int n,m,w = 0;

        StringBuilder sb = new StringBuilder();

        while (tc-->0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new ArrayList[n+1];
            for (int j = 1; j <= n; j++) {
                map[j] = new ArrayList<>();
            }

            adj = new int[n+1];
            Arrays.fill(adj, inf);


            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                map[a].add(new node(b,c));
                map[b].add(new node(a,c));
            }
            for(int j=0; j< w; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                map[a].add(new node(b,-c));
            }
            adj[1] = 0;

            String str = (bellman() ? "YES\n" : "NO\n");
            sb.append(str);



        }
        br.close();

        System.out.print(sb);

    }
}
