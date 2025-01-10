import java.util.*;

public class boj11724_dfs {
    static int[] checked;


    public static void dfs(int[][] graph, int start){
        checked[start] = 1;
//        sb.append(start+" ");
        for(int i =1; i<graph[start].length; i++){
//            System.out.println(start + " " + i);
            if(graph[start][i] ==1 && checked[i] ==0){
//                System.out.println(start + " " + i);
                dfs(graph, i);
            }
        }



    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] graph = new int[n+1][n+1];
        checked = new int[n+1];

        for(int i =0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = graph[b][a] =  1;
        }
        int num = 0;
        for(int i = 1; i<=n; i++){
            if(checked[i] == 0){
                dfs(graph, i);
//                sb.append("\n");
                num += 1;
            }
        }
        System.out.println(num);



    }
}
