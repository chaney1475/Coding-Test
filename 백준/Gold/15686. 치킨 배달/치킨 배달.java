import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;

    static List<int[]> stores;
    static List<int[]> persons;
    static int[][] grid;

    static int[] s;
    static int answer;

    public static void main(String[] args) throws IOException {
        // 치킨 배달

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // M개의 치킨집을 골라서 거리 계산

        grid = new int[N][N];

        stores = new ArrayList<>();
        persons = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());

                if (temp == 2) {
                    stores.add(new int[] {i,j});
                }else if (temp == 1) {
                    persons.add(new int[] {i,j});
                }
                grid[i][j] = temp;
            }
        }
        //골라야하는 치킨 집의 수가 M

        answer = Integer.MAX_VALUE;
        s = new int[M];

        make(0, 0);
        System.out.println(answer);

    }

    static void make(int cnt, int index) {
        if (cnt == M) {
            int temp = 0;
            for (int i = 0; i < persons.size(); i++) {
                int x = persons.get(i)[0];
                int y = persons.get(i)[1];
                temp += check(x,y);
            }
            answer = Math.min(answer, temp);
            return;
        }

        if (index == stores.size()) {
            return;
        }

        s[cnt] = index;
        make(cnt + 1, index +1);
        make(cnt, index + 1);
    }

    static int check(int a, int b) {
        int minDist = Integer.MAX_VALUE;

        for(int i = 0; i < s.length; i++){
            int x = stores.get(s[i])[0];
            int y = stores.get(s[i])[1];
            minDist = Math.min(minDist,Math.abs(a - x) + Math.abs(b-y));
        }
        return minDist;

    }

}
