import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj12015 {
    static int lower(int start, int end, int key, ArrayList<Integer> arr){
        int mid;
        while(start < end){
            mid = start + (end - start)/2;
            if(arr.get(mid) < key) start = mid + 1;
            else end = mid;
        }
        return start;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n+1];

        ArrayList<Integer> dp = new ArrayList<Integer>();
        dp.add(0);



        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            int curnum = arr[i];
            int pos = lower(0, dp.size(), curnum, dp);
            if(pos == dp.size()) dp.add(arr[i]);
            else dp.set(pos, curnum);
        }

        System.out.println(dp.size()-1);


    }

}
