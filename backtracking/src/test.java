import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test {

    static class Move {
        int[] affectedClocks;
        public Move(int[] affectedClocks) {
            this.affectedClocks = affectedClocks;
        }
        public void turn() {
            for (int clock : affectedClocks) {
                clocks[clock] = (clocks[clock] + 1) % 4;
            }
        }
        public void recover() {
            for (int clock : affectedClocks) {
                clocks[clock] = (clocks[clock] + 3) % 4;
            }
        }
    }

    static Move[] moves = new Move[10];
    static int[] clocks = new int[10];
    static int[] solution = new int[27];  // 최대 27번 move 가능
    static boolean foundSolution = false;

    static void search(int depth) {
        if (Arrays.stream(clocks).sum() == 0) { // 모든 시계가 12시를 가리킬 경우
            foundSolution = true;
            for (int i = 0; i < depth; i++) {
                System.out.print(solution[i] + " ");
            }
            System.out.println();
            return;
        }
        if (depth == 27) return;

        for (int i = 1; i < 10; i++) { // Move 1~9번 적용
            for (int j = 0; j < 3; j++) { // 각 Move는 최대 3번 사용 가능
                solution[depth] = i;
                moves[i].turn();
                search(depth + 1);
                if (foundSolution) return; // 정답을 찾으면 더 이상 탐색할 필요 없음
            }
            moves[i].recover();
        }
    }

    public static void main(String[] args) throws IOException {
        moves[1] = new Move(new int[]{1, 2, 4, 5});
        moves[2] = new Move(new int[]{1, 2, 3});
        moves[3] = new Move(new int[]{2, 3, 5, 6});
        moves[4] = new Move(new int[]{1, 4, 7});
        moves[5] = new Move(new int[]{2, 4, 5, 6, 8});
        moves[6] = new Move(new int[]{3, 6, 9});
        moves[7] = new Move(new int[]{4, 5, 7, 8});
        moves[8] = new Move(new int[]{7, 8, 9});
        moves[9] = new Move(new int[]{5, 6, 8, 9});

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            clocks[3 * i + 1] = Integer.parseInt(st.nextToken());
            clocks[3 * i + 2] = Integer.parseInt(st.nextToken());
            clocks[3 * i + 3] = Integer.parseInt(st.nextToken());
        }

        search(0);
    }
}
