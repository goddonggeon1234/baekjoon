import java.sql.Array;
import java.util.*;

public class test{
    static Queue<pair> q = new LinkedList<>();
    static class pair{
        int x;
        int y;
        pair(int x,int y){
            this.x=x;
            this.y=y;
        }
        public String toString(){
            return x+","+y;
        }
    }
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(1);
        list.sort(Collections.reverseOrder());
//        list.sort(null);
        System.out.println(list);



    }
}