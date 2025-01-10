import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class test2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String[] sa = new String[n];

        for (int i = 0; i < n; i++) {
            sa[i] = br.readLine();
            System.out.println(sa[i]);

        }

    }
}
