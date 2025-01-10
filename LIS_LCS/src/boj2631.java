import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj2631 {
    static int lower(int start, int end, int key, ArrayList<Integer> arr) {
        int mid;
        while(start < end){
            mid = (start + end) / 2;
            if(arr.get(mid) < key) start = mid + 1;
            else end = mid;
        }
        return start;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(-1000000001);

        for (int i = 1; i <= n; i++) {
            int curnum = arr[i];
            int pos = lower(0, dp.size(), curnum, dp);
            if(pos == dp.size()) dp.add(arr[i]);
            else dp.set(pos, arr[i]);
        }

        System.out.println(dp.size()-1 );
    }
}
