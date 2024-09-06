import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        // 투 포인터 사용
        int s = 0;
        int e = N - 1;
        long diff = Long.MAX_VALUE;
        long n1 = 0, n2 = 0;
        
        while (s < e) {
            long sum = A[s] + A[e];

            // 최소 차이 갱신
            if (Math.abs(sum) < diff) {
                diff = Math.abs(sum);
                n1 = A[s];
                n2 = A[e];
            }

            // 양수인 경우 오른쪽 포인터 이동
            if (sum > 0) {
                e--;
            }
            // 음수인 경우 왼쪽 포인터 이동
            else {
                s++;
            }
        }

        // 결과 출력
        System.out.println(n1 + " " + n2);
    }
}
