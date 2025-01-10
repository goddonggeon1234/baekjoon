import java.util.*;


public class boj10844 {
    static int limit = 1000000000;
    static int[][] map;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        map = new int[n][10];
        for (int i = 0; i < 10; i++) {
            map[0][i] = 1;
        }
        if (n ==1) {
            System.out.println(9);
            return ;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                if(j == 0) {
                    map[i][j] = map[i-1][1]%limit;
                    continue;
                }
                if(j == 9) {
                    map[i][j] = map[i-1][8]%limit;
                    continue;
                }
                map[i][j] = (map[i-1][j-1] + map[i-1][j+1])%limit;
            }
        }
        int tmp = 0;
        for (int i = 1; i < 10; i++) {
            tmp +=map[n-1][i];
            tmp %= limit;
        }
        System.out.println(tmp);

    }
}
