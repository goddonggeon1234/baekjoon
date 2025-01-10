import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class binarysearch {

    public static int bs (int[] arr, int key){
        int left, right, mid;
        left = 0;
        right = arr.length - 1;

        while(left <= right){
            mid = left + (right - left) / 2;
            if(arr[mid] > key){right = mid - 1;}
            else if(arr[mid] < key) left = mid + 1;
            else return 1;
        }
        return 0;
    }

    public static int lower(int[] arr, int key){
        int lo = 0, hi = arr.length;

        while(lo < hi){
            int mid = lo + (hi - lo) / 2;

            if(arr[mid] >= key) hi = mid;
            else lo = mid +1 ;

        }
        return hi;
    }
    public static int upper(int[] arr, int key){
        int lo = 0, hi = arr.length ;
        int mid = lo + (hi - lo) / 2;

        while(lo < hi){
            mid = lo + (hi - lo) / 2;
            if(arr[mid] > key) hi = mid;
            else lo = mid +1 ;

        }
        return hi;
    }

    public static void main(String[] args) {
        int n,m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

//        System.out.println(Arrays.toString(arr));

        m= sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<m; i++) {
            int key = sc.nextInt();
//            System.out.println(upper(arr, key));
//            System.out.println(lower(arr, key));
            sb.append(upper(arr, key) - lower(arr, key)).append(" ");
//            if (i ==1) break;
        }
        System.out.println(sb.toString());



    }
}