import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1759 {
    static int l;
    static int[] used;
    static char[] chars;
    static StringBuilder sb = new StringBuilder();


    static void backtrack(int depth){
        if(depth == chars.length){
            if(check()){
                for (int i = 0; i < used.length; i++) {
                    if (used[i] == 1) sb.append(chars[i]);
                }
                sb.append("\n");
            }

            return;
        }
        //점점 깊게 파고들어감
        for(int i = 1 ; i >= 0; i--){
            used[depth] = i;
            backtrack(depth+1);
        }
    }
    static boolean check() {

        int mo = 0;
        int ja = 0;
        int cnt = 0;


        for (int i = 0; i < used.length; i++) {
            cnt += used[i];
            if (chars[i] == 'a' || chars[i] == 'e' ||
                    chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u') {
                mo += used[i];
            }
            else ja += used[i];

        }

        //사용된 문자수가 암호수와 같은지 확인
        if(cnt != l) return false;
        // 자음과 모음의 최소갯수 확인
        return mo >= 1 && ja >= 2;

    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        //암호의 길이
        l = Integer.parseInt(st.nextToken());
        //입력값의 수지만 실질적으로 쓰이지 않음
        int c = Integer.parseInt(st.nextToken());
        String s = in.readLine();
        //들어온 입력들에서 공백을 제거하고 char 배열로 받음, 그 이후 사전순
        chars = s.replaceAll(" ", "").toCharArray();
        Arrays.sort(chars);

        //사용여부 확인을 위한 배열
        used = new int[chars.length];

        backtrack(0);
        System.out.print(sb);
    }
}