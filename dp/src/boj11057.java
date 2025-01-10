import java.util.*;

public class boj11057 {
    static int[][] map;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        map = new int[n][10];
        for (int i = 0; i < 10; i++) {
            map[0][i] = 1;
        }
        if (n ==1) System.out.println(10);
        else{
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < 10; j++) {
                    int tmp = 0;
                    for (int k = j; k < 10; k++) {
                        tmp += map[i-1][k];
                    }
                    map[i][j] = tmp%10007;
//                    System.out.println(tmp);
                }
            }
            int tmp = 0;
            for (int i = 0; i < 10; i++) {
                tmp += map[n-1][i];
                tmp %= 10007;
            }
            System.out.println(tmp);
        }
//         int tmp = 0;
//        for (int i = 0; i < 10; i++) {
//            tmp += map[n-1][i];
//        }
//        System.out.println(tmp);


    }
}
