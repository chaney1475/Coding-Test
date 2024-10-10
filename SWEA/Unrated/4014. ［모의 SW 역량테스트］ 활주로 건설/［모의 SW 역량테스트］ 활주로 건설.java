import java.io.*;
import java.util.*;

public class Solution {

    static int ans;
    static int[][] map;
    static int N;
    static int X;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            ans = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken()); // 경사로의 길이

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            ans = 0;

            for (int i = 0; i < N; i++) {
                if ((check(map[i]))) {
                    ans++;
                }
            }

            for (int j = 0; j < N; j++) {
                int[] a = new int[N];
                for (int i = 0; i < N; i++) {
                    a[i] = map[i][j];
                }

                if (check(a)) {
                    ans++;
                }
            }

            System.out.printf("#%d %d\n", t, ans);
        }
    }

    static boolean check(int[] arr) {

        int before = arr[0];
        int cnt = 1;

        for (int i = 1; i < N; i++) {

            int diff = arr[i] - before;

            if (Math.abs(diff) > 1) { // 높이 차가 1보다 크면 경사로를 설치할 수 없음
                return false;
            }

            if (before == arr[i]) {
                cnt++; // 같은 높이의 길이를 셈
            } else if (before < arr[i]) { // 오르막일 경우
                if (cnt < X) return false; 

                cnt = 1; 
                before = arr[i];
            } else { // 내리막일 경우
                int now = arr[i];
                int tmpCnt = 1; // 경사로를 놓을 길이 체크
                i++;

                while (i < N && tmpCnt < X) { // 경사로를 놓기 위해 다음 X칸 확인
                    if (arr[i] != now) { // 경사로를 놓을 칸이 모두 같은 높이가 아니면 실패
                        return false;
                    }
                    i++;
                    tmpCnt++;
                }

                if (tmpCnt < X) return false; // 경사로의 길이가 부족하면 불가능
                i--; // 다음 반복에서 i가 정상적으로 진행되도록 복구
                cnt = 0; // 경사로를 놓았으니 초기화
                before = arr[i]; // 현재 높이로 업데이트
            }
        }
        return true;
    }
}
