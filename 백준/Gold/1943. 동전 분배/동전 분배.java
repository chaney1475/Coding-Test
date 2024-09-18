import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int t = 0;  t < 3; t++){
            int N = Integer.parseInt(br.readLine()); // 동전의 종류
            int[] coin = new int[N];
            int[] cNum = new int[N];

            int sum = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                coin[i] = Integer.parseInt(st.nextToken());
                cNum[i] = Integer.parseInt(st.nextToken());
                sum += coin[i] * cNum[i];
            }

            // 조기 종료
            if (sum % 2 != 0){
                System.out.println("0");
                continue;
            }

            int half = sum / 2;

            boolean[] dp = new boolean[half + 1];
            dp[0] = true;

            for (int i = 0; i < N; i++){
                int value = coin[i]; // 해당 코인
                int num = cNum[i]; // 코인 갯수

                for (int j = half; j >= 0; j--) {
                    if (!dp[j]) continue; // 해당 j원이 가능한 경우에만 다음 경우 탐색
                    for (int k = 1; k <= num; k++) {
                        if (j + k * value <= half) {
                            dp[j + k * value] = true;
                        }else{
                            break;
                        }
                    }
                }
            }

            System.out.println(dp[half] ? "1" : "0");


        }


    }

}
