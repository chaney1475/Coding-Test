import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] results;
    static int maxScore = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        results = new int[N][9];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                results[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1번 선수는 4번 타자로 고정이므로, 나머지 8명의 순열만 구한다.
        int[] order = new int[9];
        boolean[] selected = new boolean[9];

        order[3] = 0; // 1번 선수는 4번 타자에 고정
        selected[0] = true; // 1번 선수는 이미 선택됨

        findMaxScore(order, selected, 0);

        System.out.println(maxScore);
    }

    // 타순을 결정하는 함수
    public static void findMaxScore(int[] order, boolean[] selected, int depth) {
        if (depth == 3) {
            findMaxScore(order, selected, depth + 1);
            return;
        }

        if (depth == 9) {
            maxScore = Math.max(maxScore, simulate(order));
            return;
        }

        for (int i = 1; i < 9; i++) {
            if (!selected[i]) {
                selected[i] = true;
                order[depth] = i;
                findMaxScore(order, selected, depth + 1);
                selected[i] = false;
            }
        }
    }

    // 주어진 타순에 따라 경기를 시뮬레이션하고 득점을 계산하는 함수
    public static int simulate(int[] order) {
        int score = 0;
        int startIdx = 0;

        for (int inning = 0; inning < N; inning++) {
            int outCount = 0;
            boolean[] base = new boolean[3];

            while (outCount < 3) {
                int player = order[startIdx];
                startIdx = (startIdx + 1) % 9;

                switch (results[inning][player]) {
                    case 0: // 아웃
                        outCount++;
                        break;
                    case 1: // 안타
                        if (base[2]) score++;
                        base[2] = base[1];
                        base[1] = base[0];
                        base[0] = true;
                        break;
                    case 2: // 2루타
                        if (base[2]) score++;
                        if (base[1]) score++;
                        base[2] = base[0];
                        base[1] = true;
                        base[0] = false;
                        break;
                    case 3: // 3루타
                        if (base[2]) score++;
                        if (base[1]) score++;
                        if (base[0]) score++;
                        base[2] = true;
                        base[1] = false;
                        base[0] = false;
                        break;
                    case 4: // 홈런
                        score += 1 + (base[0] ? 1 : 0) + (base[1] ? 1 : 0) + (base[2] ? 1 : 0);
                        base[0] = false;
                        base[1] = false;
                        base[2] = false;
                        break;
                }
            }
        }

        return score;
    }
}
