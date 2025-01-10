import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class member implements Comparable<member> {
    int age;
    int idx;
    String name;
    public member(int age, String name, int idx){
        this.age = age;
        this.name = name;
        this.idx = idx;

    }


    public String toString(){
        return age+" "+name;
    }
    public int compareTo(member o) {
        if(age==o.age) return idx-o.idx;
        else return age-o.age;
    }

}
public class boj10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        member[] members = new member[n];

        PriorityQueue<member> pq = new PriorityQueue<>(new Comparator<member>() {
            public int compare(member m1, member m2) {
                if (m1.age == m2.age) {
                    return m1.idx - m2.idx;
                } else
                    return m1.age - m2.age;
            }
        });
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            pq.add(new member(age, name, i));
            members[i]  = new member(age, name, i);
        }

        Arrays.sort(members);

//        while (!pq.isEmpty()) {
//            System.out.println(pq.poll());
//        }

        for(member m : members){
            System.out.println(m);
        }
    }
}
