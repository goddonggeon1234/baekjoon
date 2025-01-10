import java.io.*;
import java.util.*;

public class boj1958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        int[][][] map = new int[a.length()+1][b.length()+1][c.length()+1];


        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                for (int k = 0; k < c.length(); k++) {
                    if (a.charAt(i) == b.charAt(j) && b.charAt(j) == c.charAt(k)) {
                        map[i+1][j+1][k+1] = map[i][j][k] + 1;
                    }
                    else{
                        map[i+1][j+1][k+1] = Math.max(Math.max(map[i][j+1][k+1],map[i+1][j][k+1]),map[i+1][j+1][k]);

                    }
                }
            }
        }

        System.out.println();

    }

}
