import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        int[][] map = new int[N][M];
        int[][] all = new int[N*M][2];

        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
                all[i * M + j][0] = map[i][j];
                all[i * M + j][1] = i + 1; // 번째 행이라는 뜻
            }
        }
        Arrays.sort(all, (a, b) -> a[0] - b[0]);

        Map<Integer, Integer> cntClass = new HashMap<>();
        int count = 0;

        int s = 0;
        int e = 0;
        int answer = Integer.MAX_VALUE;

        while (true) {
            if (count >= N) {

                int curClass = all[s++][1];
                int curClassCnt = cntClass.getOrDefault(curClass,0);
                if (curClassCnt - 1 == 0) {
                    count--;
                }
                cntClass.put(curClass, curClassCnt - 1);

            } else if (e == N * M) {
                break;
            } else {
                int curClass = all[e++][1];
                int curClassCnt = cntClass.getOrDefault(curClass,0);
                if (curClassCnt == 0) {
                    count++;
                }
                cntClass.put(curClass, curClassCnt + 1);
            }

            if (count == N) {
                 answer  = Math.min(answer, all[e - 1][0] - all[s][0]);
            }
        }
        System.out.println(answer);
    }
}