import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N]; 
        int[] cnt = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 오른쪽
        for (int i = 0; i < N; i++) {
            // 최소 값으로 초기화
            double maxSlope = Double.NEGATIVE_INFINITY;
            for (int j = i + 1; j < N; j++) {
                double slope = (double) (A[j] - A[i]) / (j - i);
                if (slope > maxSlope) {
                    maxSlope = slope;
                    cnt[i]++;
                }
            }
        }

        // 왼쪽
        for (int i = N - 1; i >= 0; i--) {
            // 더 작은 기울기만 유효하므로 최대 값으로 초기화
            double maxSlope = Double.POSITIVE_INFINITY;
            for (int j = i - 1; j >= 0; j--) {
                // 처음거를 기준으로 기울기가 더 작아지는 경우만 볼 수 있음
                double slope = (double)(A[j] - A[i]) / (j - i);
                if (slope < maxSlope) {  // 기울기가 더 작을 때만 갱신
                    maxSlope = slope;
                    cnt[i]++;
                }
            }
        }
        
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(cnt[i], ans);
        }
        System.out.println(ans);
    }
}
