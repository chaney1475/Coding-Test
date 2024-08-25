import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();

        int[] dp = new int[X+1];
        int[][] dpCnt = new int[X+1][4];

        int[] coins = new int[4];

        coins[0] = 1;
        coins[1] = 5;
        coins[2] = 10;
        coins[3] = 25;

        int[] coinCnt = new int[]{A,B,C,D};

        if (Arrays.stream(coinCnt).sum() == 0){
            System.out.println("0 0 0 0");
            System.exit(0);
        }

        int max_num  = 0;

        for (int j = 0; j < 4; j++){

            max_num += coins[j] * coinCnt[j];

            int c = coins[j];

            if (c > X || coinCnt[j] == 0) continue;

            if (dp[c] == 0) {
                dp[c] = 1;
                dpCnt[c][j] = 1;
            }

            for (int i = c + 1; i <= X && i <= max_num; i++) {
                if (dp[i-c] != 0 && dp[i] <= dp[i - c] + 1) {
                    dp[i] = dp[i - c] + 1;

                    for (int cc = 0; cc < 4; cc++) {
                        dpCnt[i][cc] = dpCnt[i - c][cc];
                    }

                    dpCnt[i][j]++;
                }
            }

        }

        System.out.println(dpCnt[X][0]  + " " + dpCnt[X][1]  + " " + dpCnt[X][2] + " " +dpCnt[X][3]);

    }
}
