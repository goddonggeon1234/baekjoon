import java.util.*;

public class ball {
    public static long search(int[] balls, int m){
        long lo = 0;
        long hi = Arrays.stream(balls).sum();

        while(lo < hi){
            int cnt = 0;
            long mid = lo + (hi - lo)/2;
            int sum = 0;

            for(int ball : balls){
                if(sum + ball > mid){


                    cnt +=1;
                    if(sum == 0&&cnt == 1) {
//                        System.out.println(ball);
                        continue;
                    }
                    sum = 0;
                }
//                System.out.println("test");
                sum += ball;

            }

            cnt +=1;

//            System.out.println(cnt + "  " + lo+ " " + mid + " " + hi);

            if(cnt <= m) hi = mid;
            else lo = mid +1;

        }



        return lo;


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue q = new LinkedList<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();


        long max = search(arr, m);
//        System.out.println(max);

        StringBuilder sb = new StringBuilder();


        int cnt = 0, sum = 0, summax = 0;
        for(int ball : arr){
            if(sum + ball > max){
                if(sum == 0 && cnt ==0){
                    summax = ball;
                    q.add(1);
                    continue;
                }
                summax = Math.max(sum,summax);
                sum = 0;
                q.add(cnt);
                cnt = 0;
            }
            sum += ball;
            cnt += 1;
        }
        q.add(cnt);

//        System.out.println(max);
        summax = Math.max(sum,summax);
        max = Math.max(max, summax);
//
//        for(int ball : arr){
//            if(sum + ball > max){
//                sum = 0;
//                q.add(cnt);
//                cnt = 0;
//            }
//            sum += ball;
//            cnt += 1;
//        }
//
//        q.add(cnt);






//
        while(!q.isEmpty()){
            sb.append(q.remove()).append(" ");
        }

        System.out.println(max);
        System.out.println(sb);





    }

}
