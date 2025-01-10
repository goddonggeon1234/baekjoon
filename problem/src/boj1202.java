import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class juwel{
    int m;
    int v;
    public juwel(int m, int v){
        this.m = m;
        this.v = v;
    }
}

public class boj1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        juwel[] juwels = new juwel[n];
        int[] bags = new int[k];

        //보석들 입력받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            juwels[i] = new juwel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        //가방 입력받기
        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        //가방 우선순위
        Arrays.sort(bags);

        Arrays.sort(juwels,(o1 ,o2) -> Integer.compare(o1.m, o2.m));

        long ans = 0;
        PriorityQueue<juwel> pq = new PriorityQueue<>((o1, o2) -> o2.v - o1.v);
        int pos = 0;
        for (int i = 0; i < k; i++) {
            while(pos < n && bags[i] >= juwels[pos].m){
                pq.offer(juwels[pos++]);
            }
            if(!pq.isEmpty()){
                ans += pq.poll().v;
            }
        }
        System.out.println(ans);


    }
}
